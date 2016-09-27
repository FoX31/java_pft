package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by EvgeniKutsenko on 28.09.16.
 */
public class ContactHelper extends HelperBase{

    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void deleteSelectedContact() {
        wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
    }

    public void selectContact() {
        wd.findElement(By.name("selected[]")).click();
    }

    public void acceptAllert(){
        wd.switchTo().alert().accept();
    }
}
