package project.ui.ccard;

import project.framwork.CodeGenerator;
import project.framwork.TemplateToCreateAccount;
import project.ccard.AccountServiceImpl;
import project.framwork.command.AccountDeposit;
import project.framwork.command.AccountWithdraw;
import project.framwork.command.AddInterest;

public class Controller {
    public static AccountServiceImpl accountService = AccountServiceImpl.myAccountService();
    public static TemplateToCreateAccount templateToCreateAccount = new CreateAccountConcrete(accountService);
    public static AccountDisplayer displayer;
    public static AccountDeposit accountDeposit;
    public static AccountWithdraw accountWithdraw;
    public static AddInterest addInterest;
    public static CodeGenerator accountNumberGenerator = CodeGenerator.myAccountGenerator();

    public static String[] createAccount(String name,String street,String city,String state,String zip,String email,String ID,String dateOfBirth, String customerType,String accountType){
        String code= accountNumberGenerator.generateCode();
        displayer = new AccountDisplayer(templateToCreateAccount.create(name,street,city,state,zip,email,ID,dateOfBirth, customerType,accountType,code));
        String[] result = new String[6];
        result[0] = displayer.getID();
        result[1] = displayer.getName();
        result[2] = displayer.getAccountNumber();
        result[3] = displayer.getCustomerType();
        result[4] = displayer.getAccountType();
        result[5] = String.valueOf(displayer.getBalance());

        return result;
    }

    public static double deposit(String ID, double amount){
        accountDeposit = new AccountDeposit(accountService);
        return accountDeposit.execute(ID, amount);
    }

    public static double withdraw(String ID, double amount){
        accountWithdraw = new AccountWithdraw(accountService);
        return accountWithdraw.execute(ID, amount);
    }

    public static double addInterest(String ID, double amount){
        addInterest = new AddInterest(accountService);
        return addInterest.execute(ID, amount);
    }

    public static String generateReport(String ID){
        return accountService.generateReport(ID);
    }
}
