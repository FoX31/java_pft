package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData()
                .withFirstname("Evgeniy - " + (int) (Math.random() * 100)).withLastname("Kutsenko - " + (int) (Math.random() * 100))
                .withEmail("h-ebreh@mail.ru").withGroup("Fox1").withBirthdayDay("5");
        app.contact().create(contact);
        assertEquals(before.size() + 1, app.contact().count());
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

    }
    @Test
    public void testBadContactCreation() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData()
                .withFirstname("Evgeniy - ' " + (int) (Math.random() * 100)).withLastname("Kutsenko - " + (int) (Math.random() * 100))
                .withEmail("h-ebreh@mail.ru").withGroup("Fox1").withBirthdayDay("5");
        app.contact().create(contact);
        assertEquals(before.size(), app.contact().count());
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before));

    }
}
