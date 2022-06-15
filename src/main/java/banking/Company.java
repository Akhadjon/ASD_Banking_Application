package main.java.banking;

import main.java.framework.Account;
import main.java.framework.Address;
import main.java.framework.Customer;

import java.util.List;

public  class Company implements Customer {
    private String fullName;
    private String ID;
    private String establishedDate;
    private String email;
    private Address address;
    List<Account> myAccountList;

    public Company(String fullName, String ID, String establishedDate, String email, Address address, List<Account> myAccountList) {
        this.fullName = fullName;
        this.ID = ID;
        this.establishedDate = establishedDate;
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
        return establishedDate;
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