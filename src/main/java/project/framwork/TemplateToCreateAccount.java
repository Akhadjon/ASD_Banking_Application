package project.framwork;

import project.framwork.model.Account;
import project.framwork.model.Customer;

public abstract class TemplateToCreateAccount {
    private Address address;
    private Customer customer;
    private AccountType accountType;


    private AccountService accountService;

    public AccountService getAccountService() {
        return accountService;
    }

    public TemplateToCreateAccount(AccountService accountService) {
        this.accountService = accountService;
    }

    // String clientName,street,city, zip, state,accountType,amountDeposit, expDate, ccnumber;
    public Account create(String name, String street, String city, String state, String zip, String email, String ID, String dateOfBirth, String customerType, String accountType, String accountNumber){
        address = createAddress(street,city,state,zip);
        customer = createCustomer(name, ID, email, dateOfBirth, address, customerType);
        this.accountType = createAccountType(accountType);
        return createAccount(customer,this.accountType,accountNumber);
    }
    public abstract Address createAddress(String street, String city, String state, String zip);
    public abstract Customer createCustomer(String name, String ID, String email, String dateOfBirth, Address address, String customerType);
    public abstract project.framwork.AccountType createAccountType(String accountType);
    public abstract Account createAccount(Customer customer, AccountType accountType,String accountNumber);

}
