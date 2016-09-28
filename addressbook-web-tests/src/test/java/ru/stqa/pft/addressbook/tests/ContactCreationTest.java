package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
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
