package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

import static java.lang.Thread.sleep;

/**
 * Created by EvgeniKutsenko on 28.09.16.
 */
public class ContactDeleteTest extends TestBase{

    @Test

    public void testContactDelete() {
        app.getNavigationHelper().returnToHomePage();
        if   (! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("Fox1", "Fox2", "Fox3"));
        }
        app.getNavigationHelper().returnToHomePage();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("Evgeniy", "Kutsenko", "h-ebreh@mail.ru", null, "5", "Fox1"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() -1);
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().acceptAllert();
        app.getNavigationHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(before.size() - 1, after.size());

        before.remove(before.size() -1);
        Assert.assertEquals(before, after);


    }

}
