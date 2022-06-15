package bankpattern;

import banking.AccountServiceImp;

public abstract class Command {
    AccountServiceImp accountService;

    public Command(AccountServiceImp accountService) {
        this.accountService = accountService;
    }
    abstract double execute(String ID, double amount);
}


