package ru.stqa.pft.addressbook.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

/**
 * Created by EvgeniKutsenko on 28.09.16.
 */
public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void deleteSelectedContact() {
        wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void acceptAllert() {
        wd.switchTo().alert().accept();
    }

    public void modificationSelectedContactById(int id) {
        wd.findElement(By.cssSelector(String.format( "a[href='edit.php?id=%s']", id))).click();
    }

    private void detailedContactFormById(int id) {
        wd.findElement(By.cssSelector(String.format( "a[href='view.php?id=%d']", id))).click();
    }

    public void updateSelectedContact() {
        wd.findElement(By.xpath("//div[@id='content']/form[1]/input[22]")).click();
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("email"), contactData.getEmail());
        type(By.name("byear"), contactData.getBirthdayYear());
        new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getBirthdayDay());
        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

    }

    public void gotoAddNewPage() {
        click(By.linkText("add new"));
    }

    public void submitAddNewCreation() {
        wd.findElement(By.name("submit")).click();
    }

    public void create(ContactData contact) {
        gotoAddNewPage();
        fillContactForm(contact, true);
        submitAddNewCreation();
        contactsCash = null;
        homePage();
    }

    public void modify(ContactData contact) {
        modificationSelectedContactById(contact.getId());
        fillContactForm(contact, false);
        updateSelectedContact();
        contactsCash = null;
        homePage();
    }

    Contacts contactsCash = null;

    public Contacts all() {
        if(contactsCash != null){
            return new Contacts(contactsCash);
        }
        contactsCash = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            List<WebElement> data = element.findElements(By.tagName("td"));
            String lastname = data.get(1).getText();
            String firstname = data.get(2).getText();
            int id = Integer.parseInt(data.get(0).findElement(By.tagName("input")).getAttribute("id"));
            List <WebElement> emails = data.get(4).findElements(By.tagName("a"));
            String allEmails = "";
            for (WebElement email : emails) {
                allEmails +=  email.getText() + "\n";
            }
            String address = data.get(3).getText();
            String allPhones =  data.get(5).getText();
            contactsCash.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).withAllEmails(allEmails)
                   .withAllPhones(allPhones).withAddress(address));
        }
        return new Contacts(contactsCash);
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteSelectedContact();
        acceptAllert();
        contactsCash = null;
        homePage();
    }

    private void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[id='" + id + "']")).click();
    }

    public int count() {
        return wd.findElements(By.name("entry")).size();
    }

    public ContactData infoFromEditForm(ContactData contact) {
        modificationSelectedContactById(contact.getId());
        String firstName = wd.findElement(By.name("firstname")).getAttribute("value").trim();
        String lastName = wd.findElement(By.name("lastname")).getAttribute("value").trim();
        String home = wd.findElement(By.name("home")).getAttribute("value").trim();
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value").trim();
        String work = wd.findElement(By.name("work")).getAttribute("value").trim();
        String email = wd.findElement(By.name("email")).getAttribute("value").trim();
        String email2 = wd.findElement(By.name("email2")).getAttribute("value").trim();
        String email3 = wd.findElement(By.name("email3")).getAttribute("value").trim();
        String address = wd.findElement(By.name("address")).getText().trim();
        return new ContactData().withId(contact.getId()).withFirstname(firstName).withLastname(lastName)
                .withMobilePhone(mobile).withHomePhone(home).withWorkPhone(work)
                .withEmail(email).withEmail2(email2).withEmail3(email3).withAddress(address);
    }

    public ContactData infoFromDetailedForm(ContactData contact) {
        detailedContactFormById(contact.getId());
        WebElement content = wd.findElement(By.id("content"));
        String[] contactAllData = content.getText().split("\n");
        String fio = contactAllData[0].trim();
        String address = contactAllData[1].trim();
        String home = contactAllData[3].substring(3).trim();
        String mobile = contactAllData[4].substring(3).trim();
        String work = contactAllData[5].substring(3).trim();

        return new ContactData().withFio(fio).withAddress(address).withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
    }


}

