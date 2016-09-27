package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.AddNewData;

/**
 * Created by e.kutsenko on 27.09.2016.
 */
public class NavigationHelper extends HelperBase{


  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }

  public void gotoAddNewPage() {wd.findElement(By.linkText("add new")).click();}

  public void returnToLogoutPage() {
    wd.findElement(By.linkText("Logout")).click();
  }

  public void returnToMainFormPage() {
    wd.findElement(By.name("MainForm")).click();
  }

  public void returnToHomePage() {
    wd.findElement(By.linkText("home")).click();
  }

  public void submitAddNewCreation() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }


  public void fillAddNewForm(AddNewData addNewData) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(addNewData.getFirstname());
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(addNewData.getLastname());
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(addNewData.getEmail());
  }




}
