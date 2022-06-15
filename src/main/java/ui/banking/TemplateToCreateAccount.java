package main.java.ui.banking;

import main.java.creditcard.AccountServiceImpl;
import main.java.framework.Account;
import main.java.framework.AccountTypeCommand;
import main.java.framework.Address;
import main.java.framework.Customer;

public abstract class TemplateToCreateAccount {
    private Address address;
    private Customer customer;
    private AccountTypeCommand accountType;
    AccountServiceImpl accountService;

    public TemplateToCreateAccount(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    public Account create(String name, String street, String city, String state, String zip, String email, String ID, String dateOfBirth, String customerType, String accountType, String accountNumber){
        address = createAddress(street,city,state,zip);
        customer = createCustomer(name, ID, email, dateOfBirth, address, customerType);
        this.accountType = createAccountType(accountType);
        return createAccount(customer,this.accountType,accountNumber);
    }
    abstract Address createAddress(String street, String city, String state, String zip);
    abstract Customer createCustomer(String name, String ID, String email, String dateOfBirth,Address address, String customerType);
    abstract AccountTypeCommand createAccountType(String accountType);
    abstract Account createAccount(Customer customer, AccountTypeCommand accountType, String accountNumber);
}
