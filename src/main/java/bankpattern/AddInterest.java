package bankpattern;

import main.java.banking.AccountServiceImp;

public class AddInterest extends bankpattern.Command {
    public AddInterest(AccountServiceImp accountService) {
        super(accountService);
    }

    @Override
    double execute(String ID, double amount) {
            accountService.addInterest(ID);
            return accountService.getAccount(ID).getBalance();
        }
    }

