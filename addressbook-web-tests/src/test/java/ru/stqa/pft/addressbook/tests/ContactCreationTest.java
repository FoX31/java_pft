package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.model.AddNewData;

public class ContactCreationTest extends TestBase{

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoAddNewPage();
    app.getNavigationHelper().fillAddNewForm(new AddNewData("Evgeniy", "Kutsenko", "h-ebreh@mail.ru"));
    app.getNavigationHelper().submitAddNewCreation();
    app.getNavigationHelper().returnToMainFormPage();
    app.getNavigationHelper().returnToLogoutPage();
  }
}
