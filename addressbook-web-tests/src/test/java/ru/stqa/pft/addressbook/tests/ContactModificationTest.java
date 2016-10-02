package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by e.kutsenko on 30.09.2016.
 */
public class ContactModificationTest extends TestBase{

  @Test
  public void testContactModification() {
    app.getNavigationHelper().returnToHomePage();
    app.getContactHelper().modificationSelectedContact();
    app.getContactHelper().birthdayDaySelectedContact();
    app.getContactHelper().birthdayMonthSelectedContact();
    app.getContactHelper().filContactForm(new ContactData("1990"));
    app.getContactHelper().updateSelectedContact();
    app.getNavigationHelper().returnToHomePage();
  }
}
