package main.java.creditcard;

import main.java.framework.Account;
import main.java.framework.AccountDAO;

import java.util.HashMap;

public class CreditCardAccountDAO implements AccountDAO {
    private HashMap<String, Account> creditCardMap;

    public CreditCardAccountDAO() {
        this.creditCardMap = new HashMap<>();
    }

    @Override
    public boolean findAccount(String accountNumber) {
        if (null == accountNumber) return false;
        if (creditCardMap.containsKey(accountNumber)) return true;
        return false;
    }

    @Override
    public void addAccount(String accountNumber, Account account) {
        if (null != account.getAccountNumber())
            if (!findAccount(account.getAccountNumber())) {
                creditCardMap.put(account.getAccountNumber(), account);
            }
    }

    @Override
    public Account getAccount(String accountNumber) {
        if(null == accountNumber) return null;
        if(findAccount(accountNumber)){
            return creditCardMap.get(accountNumber);
        }
        return null;
    }

    @Override
    public boolean updateAccount(Account account) {
        if(null == account) return false;
        if(findAccount(account.getAccountNumber())){
            creditCardMap.remove(account.getAccountNumber());
            creditCardMap.put(account.getAccountNumber(),account);
            return true;
        }
        return false;
    }
}
