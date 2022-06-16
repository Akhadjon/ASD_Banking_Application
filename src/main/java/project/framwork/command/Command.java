package project.framwork.command;

import project.ccard.AccountServiceImpl;
import project.framwork.AccountService;

public abstract class Command {
    AccountService accountService;

    public Command(AccountService accountService) {
        this.accountService = accountService;
    }
    abstract double execute(String ID, double amount);
}
