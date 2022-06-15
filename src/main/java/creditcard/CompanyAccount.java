package main.java.creditcard;

import main.java.framework.Account;
import main.java.framework.Address;
import main.java.framework.Customer;

import java.util.List;

public class CompanyAccount implements Customer {

    private String fullName;
    private String ID;
    private String dateEstablished;
    private String email;
    private Address address;
    List<Account> myAccountList;

    public CompanyAccount(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public String getAge() {
        return dateEstablished;
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
