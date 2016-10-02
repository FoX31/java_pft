package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by e.kutsenko on 30.09.2016.
 */
public class ContactModificationTest extends TestBase{

  @Test
  public void testContactModification() {
    app.getNavigationHelper().returnToHomePage();
    app.getContactHelper().modificationSelectedContact();
    app.getContactHelper().birthdayMonthSelectedContact();
    app.getContactHelper().fillContactForm(new ContactData("Evgeniy", null, null, "1990", "8", null), false);
    app.getContactHelper().updateSelectedContact();
    app.getNavigationHelper().returnToHomePage();
  }
}
