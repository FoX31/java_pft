package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by e.kutsenko on 23.09.2016.
 */
public class ApplicationManager {

  FirefoxDriver wd;

  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private ContactHelper contactHelper;

  public void init() {
    //  System.setProperty("webdriver.gecko.driver", "C:\\\\Geckodriver\\\\geckodriver.exe");
    System.setProperty("webdriver.gecko.driver", "/Users/EvgeniKutsenko/IdeaProjects/java_pft/addressbook-web-tests/geckodriver");
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/group.php");
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
      contactHelper = new ContactHelper(wd);
    sessionHelper.login("admin", "secret");

  }


  public void stop() {
    wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
