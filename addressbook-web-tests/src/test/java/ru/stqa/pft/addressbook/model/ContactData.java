package ru.stqa.pft.addressbook.model;

/**
 * Created by EvgeniKutsenko on 02.10.16.
 */
public class ContactData {
    private final String birthdayYear;
    private final int birthdayDay;

    public ContactData (String birthdayYear, int birthdayDay){
        this.birthdayYear = birthdayYear;
        this.birthdayDay = birthdayDay;
    }
    public String getBirthdayYear () {return birthdayYear;}
    public int getBirthdayDay () {return birthdayDay + 2;}
}
