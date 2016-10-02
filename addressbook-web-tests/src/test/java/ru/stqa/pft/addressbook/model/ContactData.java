package ru.stqa.pft.addressbook.model;

/**
 * Created by EvgeniKutsenko on 02.10.16.
 */
public class ContactData {
    private final String firstname;
    private final String lastname;
    private final String email;
    private final String birthdayYear;
    private final String birthdayDay;
    private final String group;

    public ContactData(String firstname, String lastname, String email, String birthdayYear, String birthdayDay, String group){
        this.birthdayYear = birthdayYear;
        this.birthdayDay = birthdayDay;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.group = group;
    }
    public String getBirthdayYear () {return birthdayYear;}

    public String getBirthdayDay () {return birthdayDay;}

    public String getFirstname() {return firstname;}

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {return group;}
}

