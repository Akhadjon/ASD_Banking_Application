package banking;

import main.java.framework.Account;
import main.java.framework.AccountEntry;
import main.java.framework.AccountStrategy;
import main.java.framework.Customer;

import java.util.ArrayList;
import java.util.List;

public class BankAccount implements Account {
    private Customer customer;
    private double balance;
    private AccountStrategy accountType;
    private String accoutTypeName;
    private String accountNumber;

    private List<AccountEntry> entryList = new ArrayList<AccountEntry>();

    public BankAccount(Customer customer, AccountStrategy accountType, double balance, String accountNumber) {
        this.customer = customer;
        this.accountType = accountType;
        this.balance = balance;
        this.accoutTypeName = this.accountType.toString();
        customer.setAccount(this);
        this.accountNumber=accountNumber;
    }

    @Override
    public String getAccountName() {
        return accoutTypeName;
    }

    @Override
    public AccountStrategy getAccountStrategy() {
        return accountType;
    }


    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public double getBalance() {
        double balance = 0.0;
        for(AccountEntry entry: entryList){
            balance+=entry.getAmount();
        }
        return  balance;
    }

    @Override
    public void deposit(double amount) {
        balance+=amount;
        AccountEntry entry = new AccountEntry(amount,"deposit","","");
        entryList.add(entry);
        /**
         * must implemet
         */

    }

    @Override
    public void withdraw(double amount) {
        balance-=amount;
        AccountEntry entry = new AccountEntry(amount,"withdraw","","");
        entryList.add(entry);
        /**
         * must implemet
         */
    }

    @Override
    public void addEntry(AccountEntry entry) {
       entryList.add(entry) ;
    }

    @Override
    public void transferFunds(Account toAccount, double amount, String description) {
AccountEntry fromEntry= new AccountEntry(-amount,description,toAccount.getAccountNumber(),toAccount.getCustomer().getFullName());

AccountEntry toEntry= new AccountEntry(amount,description,toAccount.getAccountNumber(),toAccount.getCustomer().getFullName());
entryList.add(fromEntry);
toAccount.addEntry(toEntry);
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public void setCustomer(Customer customer) {
          // wait
    }

    @Override
    public List<AccountEntry> getEntryList() {

        return entryList;
    }

    @Override
    public String generateBill() {
        return null;
    }
}
