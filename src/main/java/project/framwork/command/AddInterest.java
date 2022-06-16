package project.framwork.command;

import project.ccard.*;
import project.framwork.AccountService;
import project.framwork.command.Command;

public class AddInterest extends Command {
    public AddInterest(AccountService accountService) {
        super(accountService);
    }

    @Override
    public double execute(String ID, double amount) {
        accountService.addInterest(ID);
        return accountService.getAccount(ID).getBalance();
    }
}
