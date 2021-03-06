package main.java.framework;

public interface AccountService {
    Account createAccount(Customer client, AccountTypeCommand accountType, String accountNumber);
    Account getAccount(String accountNumber);
    void deposit (String accountNumber, double amount);
    void withdraw (String accountNumber, double amount);
    void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description);
    void addInterest(String accountNumber);
    String generateReport(String accountNumber);
}
