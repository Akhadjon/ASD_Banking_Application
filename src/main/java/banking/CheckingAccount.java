package banking;

import main.java.framework.AccountType;

public class CheckingAccount implements AccountType {
    @Override
    public double[] execute(double amount) {
        double[] a = new double[1];
        if(amount>1000){
            a[0]= amount*0.025;
            return a;
        }else{
            a[0]= amount*0.015;
            return a;
        }

    }

    @Override
    public String getAccountTypeName() {
        return "Checking Account";
    }
}
