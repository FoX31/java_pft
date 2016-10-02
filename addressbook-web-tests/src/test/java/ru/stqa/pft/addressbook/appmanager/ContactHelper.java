package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by EvgeniKutsenko on 28.09.16.
 */
public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void deleteSelectedContact() {wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();}

    public void selectContact() {wd.findElement(By.name("selected[]")).click();}

    public void acceptAllert(){
        wd.switchTo().alert().accept();
    }

    public void addSelectContact() { wd.findElement(By.name("add")).click();}

    public void returnToAddContact() { wd.findElement(By.linkText("group page \"Fox\"")).click();}

    public void modificationSelectedContact() {wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img")).click();}

    public void birthdayMonthSelectedContact() {wd.findElement(By.xpath("//div[@id='content']/form[1]/select[2]//option[10]")).click();}

    public void updateSelectedContact() {wd.findElement(By.xpath("//div[@id='content']/form[1]/input[22]")).click();}

    public void filContactForm(ContactData contactData){
        type(By.name("byear"), contactData.getBirthdayYear());
        wd.findElement(By.xpath("//div[@id='content']/form[1]/select[1]//option[" + contactData.getBirthdayDay()  + "]")).click();
    }
}
