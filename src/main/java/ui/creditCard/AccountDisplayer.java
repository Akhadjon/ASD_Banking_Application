package main.java.ui.creditCard;

import main.java.banking.PersonalAccount;
import main.java.framework.Account;

public class AccountDisplayer {
    Account account;

    public AccountDisplayer(Account account) {
        this.account = account;
    }

    public String getID(){
        return account.getAccountID();
    }
    public String getName(){
        return account.getCustomer().getFullName();
    }
    public String getAccountNumber(){
        return account.getAccountNumber();
    }
    public String getCustomerType(){
        if(account.getCustomer() instanceof PersonalAccount) return "Personal";
        return "Company";
    }
    public String getAccountType(){
        return account.getAccountType().getAccountTypeName();
    }
    public double getBalance(){
        return account.getBalance();
    }
    public String getCity(){
        return account.getCustomer().getAddress().getCity();
    }
}
