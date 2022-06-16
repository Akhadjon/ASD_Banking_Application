package project.framwork;

import project.framwork.model.Account;
import project.framwork.model.Customer;
import project.framwork.strategy.AccountType;

public interface AccountService {
    Account createAccount(Customer client, AccountType accountType, String accountNumber);
    Account getAccount(String accountNumber);
    void deposit (String accountNumber, double amount);
    void withdraw (String accountNumber, double amount);
    void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description);
    void addInterest(String accountNumber);
    String generateReport(String ID);
}
