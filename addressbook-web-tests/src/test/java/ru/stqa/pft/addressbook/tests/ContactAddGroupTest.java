package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by EvgeniKutsenko on 18.12.16.
 */
public class ContactAddGroupTest extends TestBase {


    @BeforeMethod
    public void ensurePrecondition() {
        app.goTo().groupPage();
        if (app.db().groups().size() == 0) {
            app.group().create(new GroupData().withName("Fox1").withFooter("Fox2").withHeader("Fox3"));
        }
        app.goTo().homePage();
        if (app.db().contacts().size() == 0) {
            app.contact().create(new ContactData().withFirstname("Evgeniy - " + (int) (Math.random() * 100)).withLastname("Kutsenko - " + (int) (Math.random() * 100))
                    .withEmail("h-ebreh@mail.ru").withBirthdayDay("5"));
        }
    }

    @Test
    public void testContactAddGroup() throws InterruptedException {
        app.goTo().homePage();
        Contacts before = app.db().contacts();
        ContactData contact = before.iterator().next();
        GroupData group = app.db().groups().iterator().next();
        app.contact().addContactGroup(contact, group.getName());
        Contacts after = app.db().contacts();
        Groups contactGroupsBefore = before.getContactById(contact.getId()).getGroups();
        Groups contactGroupsAfter = after.getContactById(contact.getId()).getGroups();
        assertThat(contactGroupsAfter, equalTo(contactGroupsBefore.withAdded(group)));
    }

}
