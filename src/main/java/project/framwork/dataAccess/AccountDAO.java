package project.framwork.dataAccess;

import project.framwork.model.Account;

public interface AccountDAO {
    boolean findAccount(String accountNumber);
    void addAccount(String accountNumber, Account account);
    Account getAccount(String accountNumber);
    boolean updateAccount(Account account);
}
