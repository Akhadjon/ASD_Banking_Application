package project.bank;

import project.framwork.command.Command;
import project.framwork.util.AccountDisplayer;
import project.framwork.util.CodeGenerator;
import project.framwork.TemplateToCreateAccount;
import project.framwork.command.AccountDeposit;
import project.framwork.command.AccountWithdraw;
import project.framwork.command.AddInterest;

public class Controller {
    public static AccountServiceImpl accountService = AccountServiceImpl.myAccountService();
    public static TemplateToCreateAccount templateToCreateAccount = new CreateAccountConcrete(accountService);
    public static AccountDisplayer displayer;
    public static Command command;
    public static CodeGenerator accountNumberGenerator = CodeGenerator.myAccountGenerator();

    public static String[] createAccount(String name,String street,String city,String state,String zip,String email,String ID,String dateOfBirth, String customerType,String accountType){
        String code= accountNumberGenerator.generateCode();
        displayer = new AccountDisplayer(templateToCreateAccount.create(name,street,city,state,zip,email,ID,dateOfBirth, customerType,accountType,code));

        String[] result = new String[6];
        result[0] = displayer.getName();
        result[1] = displayer.getAccountNumber();
        result[2] = displayer.getCustomerType();
        result[3] = displayer.getAccountType();
        result[4] = String.valueOf(displayer.getBalance());
        result[5] = displayer.getCity();
        System.out.println(displayer.getAccountNumber());
        return result;
    }

    public static double deposit(String ID, double amount){
        command = new AccountDeposit(accountService);
        return command.execute(ID, amount);
    }

    public static double withdraw(String ID, double amount){
        command = new AccountWithdraw(accountService);
        return command.execute(ID, amount);
    }

    public static double addInterest(String ID, double amount){
        command = new AddInterest(accountService);
        return command.execute(ID, amount);
    }

    public static String generateReport(String ID){
        return accountService.generateReport(ID);
    }

}
