package banking;

import main.java.framework.*;

import java.util.ArrayList;
import java.util.List;

public class AccountServiceImp implements AccountService {
    private AccountDAO accountDAO;
    //private CustomerDAO customerDAO;

    public AccountServiceImp(AccountDAO accountDAO){
        this.accountDAO=accountDAO;
    }
    @Override
    public Account createAccount(Customer client, AccountType accountType, String accountNumber) {
       Account account=new BankAccount(client,accountType,0,accountNumber);
       accountDAO.addAccount(account.getAccountNumber(),account);
return account;
    }

    @Override
    public Account getAccount(String accountNumber) {

        return  accountDAO.getAccount(accountNumber);
    }

    @Override
    public void deposit(String accountNumber, double amount) {
        Account account= accountDAO.getAccount(accountNumber);
if (account== null){
    System.out.println("No account with this ID");
}else{
    account.deposit(amount);
    accountDAO.updateAccount(account);
}
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        Account account= accountDAO.getAccount(accountNumber);
        if (account.getBalance()< 0){
            System.out.println("You don't have enough amount");
        }else{
            account.withdraw(amount);
            accountDAO.updateAccount(account);
        }
    }

    @Override
    public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
        Account fromAccount = accountDAO.getAccount(fromAccountNumber);
        Account toAccount = accountDAO.getAccount(toAccountNumber);
        fromAccount.transferFunds(toAccount, amount, description);
        accountDAO.updateAccount(fromAccount);
        accountDAO.updateAccount(toAccount);
    }

    @Override
    public void addInterest(String accountNumber) {
        double interest =0;
        Account account = getAccount(accountNumber);
        double[] a =account.getAccountType().execute(account.getBalance());
        interest= a[0];
        deposit(accountNumber,interest);
    }

    @Override
    public String generateReport(String accountNumber) {
        String result="";
        List<AccountEntry> List = new ArrayList<>();
        Account account = getAccount(accountNumber);
        List= account.getEntryList();
        for(AccountEntry e: List){
            result+=(e.report()+ " \n");
        }
        System.out.println(result);
        return result;
    }
}
