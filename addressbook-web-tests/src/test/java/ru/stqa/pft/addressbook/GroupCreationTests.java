package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    gotoGroupPage();
    initGroupCreation();
    filGroupForm(new GroupData("Fox1", "Fox2", "Fox3"));
    submitGroupCreation();
    returnToGroupPage();
  }

}
