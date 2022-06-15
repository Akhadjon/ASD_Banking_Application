package main.java.ui.creditCard;


import main.java.creditcard.AccountServiceImpl;

public class AccountWithdraw extends CommanderPage{
    public AccountWithdraw(AccountServiceImpl accountService) {
        super(accountService);
    }

    @Override
    public double execute(String ID, double amount) {
        accountService.withdraw(ID,amount);
        return accountService.getAccount(ID).getBalance();
    }
}
