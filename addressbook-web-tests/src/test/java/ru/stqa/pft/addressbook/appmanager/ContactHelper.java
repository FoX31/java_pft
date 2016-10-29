package ru.stqa.pft.addressbook.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EvgeniKutsenko on 28.09.16.
 */
public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void deleteSelectedContact() {wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();}

    public void selectContact(int index) {wd.findElements(By.name("selected[]")).get(index).click();}

    public void acceptAllert(){
        wd.switchTo().alert().accept();
    }

    public void addSelectContact() { wd.findElement(By.name("add")).click();}

    public void returnToAddContact() { wd.findElement(By.linkText("group page \"Fox\"")).click();}

    public void modificationSelectedContact(int index) {wd.findElements(By.name("entry")).get(index).findElements(By.tagName("td")).get(7).click();}

    public void updateSelectedContact() {wd.findElement(By.xpath("//div[@id='content']/form[1]/input[22]")).click();}

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("email"), contactData.getEmail());
        type(By.name("byear"), contactData.getBirthdayYear());
        new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getBirthdayDay());
        if(creation){
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        }else{
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

    }
    public void gotoAddNewPage() {click(By.linkText("add new"));}

    public void submitAddNewCreation() {
        wd.findElement(By.name("submit")).click();
    }

    public void createContact(ContactData contact) {
        gotoAddNewPage();
        fillContactForm(contact, true);
        submitAddNewCreation();
        returnToHomePage();


    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements){
            List<WebElement> data = element.findElements(By.tagName("td"));
            String lastname = data.get(1).getText();
            String firstname = data.get(2).getText();
            int id = Integer.parseInt(data.get(0).findElement(By.tagName("input")).getAttribute("id"));
            String email = data.get(4).getText();
            contacts.add(new ContactData(id, firstname, lastname, email, null, null, null));
        }
        return contacts;
    }
}

