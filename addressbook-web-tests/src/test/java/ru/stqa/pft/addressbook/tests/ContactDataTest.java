package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import java.util.Arrays;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by EvgeniKutsenko on 02.11.16.
 */
public class ContactDataTest extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("Fox1").withFooter("Fox2").withHeader("Fox3"));
        }
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withFirstname("Evgeniy - " + (int) (Math.random() * 100)).withLastname("Kutsenko - " + (int) (Math.random() * 100))
                    .withEmail("h-ebreh@mail.ru").withGroup("Fox1").withBirthdayDay("5"));
        }
    }

    @Test (enabled = false)
    public void testContactPhone() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAllPhones(), equalTo(merge(contactInfoFromEditForm)));

    }

    @Test
    public void testContactEmail() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));

    }

    @Test
    public void testContactAddress() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));

    }

    @Test
    public void testDetailedForm() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        app.goTo().homePage();
        ContactData contactInfoFromDetailedForm = app.contact().infoFromDetailedForm(contact);
        assertThat(contactInfoFromDetailedForm.getFio(), equalTo(mergeFio(contactInfoFromEditForm)));
        assertThat(contactInfoFromDetailedForm.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
        assertThat(contactInfoFromDetailedForm.getHome(), equalTo(contactInfoFromEditForm.getHome()));
        assertThat(contactInfoFromDetailedForm.getMobile(), equalTo(contactInfoFromEditForm.getMobile()));
        assertThat(contactInfoFromDetailedForm.getWork(), equalTo(contactInfoFromEditForm.getWork()));
    }

    private String merge(ContactData contact) {
        return Arrays.asList(contact.getHome(), contact.getMobile(), contact.getWork())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactDataTest::cleaned)
                .collect(Collectors.joining("\n"));
    }

    private String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s) -> ! s.equals(""))
               // .map(ContactDataTest::cleaned)
                .collect(Collectors.joining("\n")) + "\n";
    }

    private String mergeFio(ContactData contact) {
        return Arrays.asList(contact.getFirstname(), contact.getLastname())
                .stream().filter((s) -> ! s.equals(""))
                // .map(ContactDataTest::cleaned)
                .collect(Collectors.joining(" ")).trim();
    }

    public static String cleaned(String phone){
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }

}
