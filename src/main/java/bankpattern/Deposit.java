package bankpattern;

import main.java.banking.AccountServiceImp;

public class Deposit extends bankpattern.Command {
    public Deposit(AccountServiceImp accountService) {
        super(accountService);
    }

    @Override
    double execute(String ID, double amount) {
        accountService.deposit(ID,amount);
        return accountService.getAccount(ID).getBalance();
    }
}
