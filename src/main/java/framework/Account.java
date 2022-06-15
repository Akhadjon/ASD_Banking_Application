package main.java.framework;

import java.util.List;

public interface Account extends Observable {
    String getAccountName();

    AccountTypeCommand getAccountType();

    String getAccountID();
    String getAccountNumber();
//        void setAccountNumber(String accountNumber);
    double getBalance();
    void deposit(double amount);
    void withdraw(double amount);
    void addEntry(AccountEntry entry);
    void transferFunds(Account toAccount, double amount, String description);
    Customer getCustomer();
    void setCustomer(Customer customer);
    List<AccountEntry> getEntryList();
    String generateBill();
}
