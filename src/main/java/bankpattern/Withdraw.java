package bankpattern;

import banking.AccountServiceImp;

public class Withdraw extends Command {

    public Withdraw(AccountServiceImp accountService) {
        super(accountService);

    }

    @Override
    double execute(String ID, double amount) {
        accountService.withdraw(ID,amount);

        return accountService.getAccount(ID).getBalance();
    }
}