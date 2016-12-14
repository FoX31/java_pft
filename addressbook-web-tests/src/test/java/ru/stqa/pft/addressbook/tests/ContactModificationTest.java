package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by e.kutsenko on 30.09.2016.
 */
public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        app.goTo().groupPage();
        if (app.db().groups().size() == 0) {
            app.group().create(new GroupData().withName("Fox1").withFooter("Fox2").withHeader("Fox3"));
        }
        app.goTo().homePage();
        if (app.db().contacts().size() == 0) {
            app.contact().create(new ContactData().withFirstname("Evgeniy - " + (int) (Math.random() * 100)).withLastname("Kutsenko - " + (int) (Math.random() * 100))
                    .withEmail("h-ebreh@mail.ru").withGroup("Fox1").withBirthdayDay("5"));
        }
    }

    @Test
    public void testContactModification() {
        app.goTo().homePage();
        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Evgeniy").withLastname("Evgeniy").withBirthdayYear("1990")
                .withEmail("h-ebreh@mail.ru").withBirthdayDay("8");
        app.contact().modify(contact);
        assertEquals(before.size(), app.contact().count());
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }
}
