package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase{

  @Test
  public void testContactCreation() {
    app.getContactHelper().createContact(new ContactData("Evgeniy", "Kutsenko", "h-ebreh@mail.ru", null, "5", "Fox1"));
    app.getNavigationHelper().returnToLogoutPage();
  }
}
