package main.java.creditcard;

import main.java.framework.*;

public class AccountServiceImpl implements AccountService {
    private AccountDAO accountDAO;
    private CustomerDAO customerDAO;

    // creat non parameterized constructor
    public AccountServiceImpl() {
        this.accountDAO = accountDAO;
        this.customerDAO = customerDAO;
    }
    private final static AccountServiceImpl accountService = new AccountServiceImpl();

    public static AccountServiceImpl myAccountService(){
        return accountService;
    }

    @Override
    public Account createAccount(Customer client, AccountType accountType, String accountNumber) {
        if(!customerDAO.findCustomer(client)){
            Account account = new CreditCardAccount(client,accountType,0,accountNumber);
            accountDAO.addAccount(account.getAccountNumber(),account);
            customerDAO.addCustomer(client);
            return account;
        }else {
            Customer a = customerDAO.getCustomer(client);
            Account account = new CreditCardAccount(a,accountType,0,accountNumber);
            a.setAccount(account);
            customerDAO.updateCustomer(a);
            accountDAO.addAccount(account.getAccountNumber(),account);
            return account;
        }
    }

    @Override
    public Account getAccount(String accountNumber) {
        // get account will return the account form accountDAO
        return accountDAO.getAccount(accountNumber);

    }

    @Override
    public void deposit(String accountNumber, double amount) {
        Account account = accountDAO.getAccount(accountNumber);
        if(account==null){
            System.out.println("no account with this ID");
        }else {
            account.deposit(amount);
            accountDAO.updateAccount(account);
        }
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        Account account = accountDAO.getAccount(accountNumber);
        account.withdraw(amount);
        accountDAO.updateAccount(account);
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

    }

    @Override
    public String generateReport(String ID) {
        return null;
    }
}
