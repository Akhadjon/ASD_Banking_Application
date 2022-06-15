package bankpattern;

import banking.AccountServiceImp;

public class Deposit extends Command {
    public Deposit(AccountServiceImp accountService) {
        super(accountService);
    }

    @Override
    double execute(String ID, double amount) {
        accountService.deposit(ID,amount);
        return accountService.getAccount(ID).getBalance();
    }
}
