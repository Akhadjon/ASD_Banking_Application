package project.ui.bank;

import project.bank.AccountServiceImpl;

public class AccountWithdraw extends CommanderPage {
    public AccountWithdraw(AccountServiceImpl accountService) {
        super(accountService);
    }

    @Override
    double execute(String ID, double amount) {
        accountService.withdraw(ID,amount);
        return accountService.getAccount(ID).getBalance();
    }
}
