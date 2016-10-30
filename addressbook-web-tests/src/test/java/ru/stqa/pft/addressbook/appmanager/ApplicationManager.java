package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;
import java.util.concurrent.TimeUnit;

/**
 * Created by e.kutsenko on 23.09.2016.
 */
public class ApplicationManager {
  WebDriver wd;

  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private ContactHelper contactHelper;
  private String browser;

  public ApplicationManager(String browser) {

    this.browser = browser;
  }

  public void init() {
    if (browser == BrowserType.FIREFOX) {
      wd = new FirefoxDriver();
    }else if (browser == BrowserType.CHROME) {
      wd = new ChromeDriver();
    }else if (browser == BrowserType.IE){
      wd = new InternetExplorerDriver();
    }else {
        wd = new SafariDriver();
    }
    wd.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
    wd.get("http://localhost/addressbook");
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    contactHelper = new ContactHelper(wd);
    sessionHelper.login("admin", "secret");

  }


  public void stop() {
    wd.quit();
  }

  public GroupHelper group() {return groupHelper; }

  public NavigationHelper goTo() {
    return navigationHelper;
  }

  public ContactHelper contact() {
        return contactHelper;
    }
}
