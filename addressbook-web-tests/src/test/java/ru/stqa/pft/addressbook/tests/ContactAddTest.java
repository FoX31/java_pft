package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

/**
 * Created by e.kutsenko on 28.09.2016.
 */
public class ContactAddTest extends TestBase{

  @Test
  public void testAddTest() throws InterruptedException {
    app.getNavigationHelper().returnToHomePage();
    sleep(600);
    app.getContactHelper().selectContact();
    app.getContactHelper().addSelectContact();
    app.getContactHelper().returnToAddContact();
    app.getNavigationHelper().returnToLogoutPage();
  }
}
