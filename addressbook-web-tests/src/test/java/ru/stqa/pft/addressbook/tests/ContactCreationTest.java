package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class ContactCreationTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts(){
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{new ContactData().withFirstname("Evgeniy").withLastname("Kutsenko").withEmail("h-ebreh@mail.ru").withGroup("Fox1").withBirthdayDay("5")});
        list.add(new Object[]{new ContactData().withFirstname("Evgeniy1").withLastname("Kutsenko1").withEmail("h-ebreh1@mail.ru").withGroup("Fox1").withBirthdayDay("6")});
        list.add(new Object[]{new ContactData().withFirstname("Evgeniy2").withLastname("Kutsenko2").withEmail("h-ebreh2@mail.ru").withGroup("Fox1").withBirthdayDay("7")});
        return list.iterator();
    }

    @Test(dataProvider = "validContacts")
    public void testContactCreation(ContactData contact) {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        app.contact().create(contact);
        assertEquals(before.size() + 1, app.contact().count());
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

    }

    @DataProvider
    public Iterator<Object[]> invalidContacts(){
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{new ContactData().withFirstname("Evgeniy2'").withLastname("Kutsenko2").withEmail("h-ebreh2@mail.ru").withGroup("Fox1").withBirthdayDay("7")});
        return list.iterator();
    }

    @Test(dataProvider = "invalidContacts")
    public void testBadContactCreation(ContactData contact) {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        app.contact().create(contact);
        assertEquals(before.size(), app.contact().count());
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before));

    }
}
