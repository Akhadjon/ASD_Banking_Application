package main.java.banking;

import main.java.framework.AccountStrategy;

public class CheckingAccount implements AccountStrategy {
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
