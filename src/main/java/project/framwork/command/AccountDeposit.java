package project.framwork.command;

import project.ccard.*;
import project.framwork.AccountService;
import project.framwork.command.Command;

public class AccountDeposit extends Command {
    public AccountDeposit(AccountService accountService) {
        super(accountService);
    }

    @Override
    public double execute(String ID, double amount) {
        accountService.deposit(ID,amount);
        return accountService.getAccount(ID).getBalance();
    }
}
