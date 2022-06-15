package main.java.ui.banking;

//import main.java.banking;
import main.java.banking.CompanyAccount;
import main.java.banking.PersonalAccount;
import main.java.creditcard.AccountServiceImpl;
import main.java.framework.Account;
import main.java.framework.AccountTypeCommand;
import main.java.framework.Address;
import main.java.framework.Customer;

public class CreateAccountConcrete extends TemplateToCreateAccount {
    public CreateAccountConcrete(AccountServiceImpl accountService) {
        super(accountService);
    }

    @Override
    Address createAddress(String street, String city, String state, String zip) {
        return new Address(street,city,state,zip);
    }

    @Override
    Customer createCustomer(String name, String ID, String email, String dateOfBirth, Address address, String customerType) {
        if(customerType.equalsIgnoreCase("company")){
            return new CompanyAccount(name,ID,email,address,dateOfBirth);
        }else return new PersonalAccount(name,ID,email,dateOfBirth,address);
    }

    @Override
    AccountTypeCommand createAccountType(String accountType) {
        if(accountType.equalsIgnoreCase("Checking")){
            return new CheckingAccount();
        }else return new SavingAccount();
    }

    @Override
    Account createAccount(Customer customer, AccountTypeCommand accountType, String accountNumber) {
        return accountService.createAccount(customer,accountType,accountNumber);
    }
}
