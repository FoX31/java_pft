package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTest extends TestBase{

  @Test
  public void testContactCreation() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData()
            .withFirstname("Evgeniy - " + (int)(Math.random() * 100 )).withLastname("Kutsenko - " + (int)(Math.random() * 100))
            .withEmail("h-ebreh@mail.ru").withGroup("Fox1").withBirthdayDay("5");
    app.contact().create(contact);
    Contacts after = app.contact().all();
    Assert.assertEquals(before.size() + 1, after.size());

    MatcherAssert.assertThat(after, CoreMatchers.equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }
}
