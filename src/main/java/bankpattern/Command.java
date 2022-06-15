package bankpattern;

import main.java.banking.AccountServiceImp;

public abstract class Command {
    AccountServiceImp accountService;

    public Command(AccountServiceImp accountService) {
        this.accountService = accountService;
    }
    abstract double execute(String ID, double amount);
}


