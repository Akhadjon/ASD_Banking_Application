package project.framwork.command;


import project.ccard.*;
import project.framwork.command.Command;

public class AccountWithdraw extends Command {
    public AccountWithdraw(AccountServiceImpl accountService) {
        super(accountService);
    }

    @Override
    public double execute(String ID, double amount) {
        accountService.withdraw(ID,amount);
        return accountService.getAccount(ID).getBalance();
    }
}
