package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;


/**
 * Created by EvgeniKutsenko on 28.09.16.
 */
public class ContactDeleteTest extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        app.goTo().groupPage();
        if   (app.group().all().size() == 0){
            app.group().create(new GroupData().withName("Fox1").withFooter("Fox2").withHeader("Fox3"));
        }
        app.goTo().homePage();
        if (app.contact().all().size() == 0){
            app.contact().create(new ContactData().withFirstname("Evgeniy - " + (int)(Math.random() * 100 )).withLastname("Kutsenko - " + (int)(Math.random() * 100))
                    .withEmail("h-ebreh@mail.ru").withGroup("Fox1").withBirthdayDay("5"));
        }
    }

    @Test
    public void testContactDelete() {
        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Contacts after = app.contact().all();
        assertEquals(before.size() - 1, after.size());

        assertThat(after, equalTo(before.without(deletedContact)));
    }
}
