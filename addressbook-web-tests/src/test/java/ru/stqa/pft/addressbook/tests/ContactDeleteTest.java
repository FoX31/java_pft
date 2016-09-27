package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

/**
 * Created by EvgeniKutsenko on 28.09.16.
 */
public class ContactDeleteTest extends TestBase{

    @Test

    public void testContactDelete() throws InterruptedException {
        app.getNavigationHelper().returnToHomePage();
        //sleep(4000);
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().acceptAllert();
        app.getNavigationHelper().returnToHomePage();
    }

}
