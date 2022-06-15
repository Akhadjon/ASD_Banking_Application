package main.java.creditcard;

import main.java.framework.Account;
import main.java.framework.Address;
import main.java.framework.Customer;

import java.util.List;

public class PersonalAccount implements Customer {
    private String fullName;
    private String ID;
    private String birthDate;
    private String email;
    private Address address;
    List<Account> myAccountList;

    public PersonalAccount(String fullName, String ID, String birthDate, String email, Address address, List<Account> myAccountList) {
        this.fullName = fullName;
        this.ID = ID;
        this.birthDate = birthDate;
        this.email = email;
        this.address = address;
        this.myAccountList = myAccountList;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public String getAge() {
        return birthDate;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public Address getAddress() {
        return address;
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public void setAccount(Account account) {
        myAccountList.add(account);
    }

    @Override
    public void update() {

    }
}
