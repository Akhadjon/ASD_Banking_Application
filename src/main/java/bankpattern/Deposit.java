package main.java.bankpattern;

import main.java.banking.AccountServiceImp;

public class Deposit extends Command {
    public Deposit(AccountServiceImp accountService) {
        super(accountService);
    }

    @Override
    protected double execute(String ID, double amount) {
        accountService.deposit(ID,amount);
        return accountService.getAccount(ID).getBalance();
    }
}
