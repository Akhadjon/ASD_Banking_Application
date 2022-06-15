package banking;

import main.java.framework.Account;
import main.java.framework.AccountDAO;

import java.util.HashMap;

public class BankingAccountDAO implements AccountDAO {
    private HashMap<String, Account> bankingAccountMap;

    public BankingAccountDAO() {
        bankingAccountMap = new HashMap<>();
    }

    @Override
    public boolean findAccount(String accountNumber) {
        if (null == accountNumber) return false;
        if (bankingAccountMap.containsKey(accountNumber))
            return true;
        return false;
    }

    @Override
    public void addAccount(String accountNumber, Account account) {
        if (!findAccount(account.getAccountNumber())) {
            bankingAccountMap.put(account.getAccountNumber(), account);
        }
    }

    @Override
    public Account getAccount(String accountNumber) {
        if (null == accountNumber)
            return null;
        return bankingAccountMap.get(accountNumber);
    }

    @Override
    public boolean updateAccount(Account account) {
        if (null == account) return false;
        if (findAccount(account.getAccountNumber())) {
            bankingAccountMap.remove(account.getAccountNumber());
            bankingAccountMap.put(account.getAccountNumber(), account);
            return true;
        }
            return false;
        }

    }
