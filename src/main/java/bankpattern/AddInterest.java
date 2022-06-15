package main.java.bankpattern;

import main.java.banking.AccountServiceImp;

public class AddInterest extends Command {
    public AddInterest(AccountServiceImp accountService) {
        super(accountService);
    }

    @Override
    protected double execute(String ID, double amount) {
            accountService.addInterest(ID);
            return accountService.getAccount(ID).getBalance();
        }
    }

