package project.ui.ccard;

import project.ccard.strategy.BronzeAccount;
import project.ccard.strategy.GoldAccount;
import project.ccard.strategy.SilverAccount;
import project.framwork.*;
import project.ccard.*;
import project.framwork.model.Account;
import project.framwork.model.CompanyAccount;
import project.framwork.model.Customer;
import project.framwork.model.PersonalAccount;
import project.framwork.strategy.AccountType;

public class CreateAccountConcrete extends TemplateToCreateAccount {

    public CreateAccountConcrete(AccountService accountService) {
        super(accountService);
    }

    @Override
    public Address createAddress(String street, String city, String state, String zip) {
        return new Address(street,city,state,zip);
    }

    @Override
    public Customer createCustomer(String name, String ID, String email, String dateOfBirth, Address address, String customerType) {
        if(customerType.equalsIgnoreCase("company")){
            return new CompanyAccount(name,ID,email,address,dateOfBirth);
        }else return new PersonalAccount(name,ID,email,dateOfBirth,address);
    }

    @Override
    public AccountType createAccountType(String accountType) {
        if(accountType.equalsIgnoreCase("gold")){
            return new GoldAccount();
        }else if(accountType.equalsIgnoreCase("silver")){
            return new SilverAccount();
        }else return new BronzeAccount();
    }

    @Override
    public Account createAccount(Customer customer, AccountType accountType, String accountNumber) {
        return super.getAccountService().createAccount(customer,accountType,accountNumber);
    }

}
