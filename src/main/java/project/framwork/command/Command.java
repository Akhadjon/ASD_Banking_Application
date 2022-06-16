package project.framwork.command;

import project.ccard.AccountServiceImpl;

public abstract class Command {
    AccountServiceImpl accountService;

    public Command(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }
    abstract double execute(String ID, double amount);
}
