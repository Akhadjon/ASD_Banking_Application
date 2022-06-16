package project.framwork.dataAccess;

import project.framwork.model.Account;

import java.util.HashMap;

public class AccountDAOImplementation implements AccountDAO {
    private HashMap<String, Account> creditCardMap;

    public AccountDAOImplementation() {
        creditCardMap = new HashMap<>();
    }

    public boolean findAccount(String accountNumber){
        if(null == accountNumber) return false;
        if(creditCardMap.containsKey(accountNumber)) return true;
        return false;
    }
    public void addAccount(String ID, Account account){
        if(null != account.getAccountNumber())
        if(!findAccount(account.getAccountNumber())){
            creditCardMap.put(account.getAccountNumber(),account);
        }
    }

    public Account getAccount(String accountNumber){
        if(null == accountNumber) return null;
        if(findAccount(accountNumber)){
            return creditCardMap.get(accountNumber);
        }return null;
    }

    public boolean updateAccount(Account account){
        if(null == account) return false;
        if(findAccount(account.getAccountNumber())){
            creditCardMap.remove(account.getAccountNumber());
            creditCardMap.put(account.getAccountNumber(),account);
            return true;
        }return false;
    }
}
