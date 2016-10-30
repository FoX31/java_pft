package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by e.kutsenko on 27.09.2016.
 */
public class NavigationHelper extends HelperBase{


  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void groupPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new"))){
      return;
    }

    click(By.linkText("groups"));
  }


  public void returnToLogoutPage() {wd.findElement(By.linkText("Logout")).click();}
}
