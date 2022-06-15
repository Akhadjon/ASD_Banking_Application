package banking;

import main.java.framework.AccountStrategy;

public class SavingAccount implements AccountStrategy {
    @Override
    public double[] execute(double amount) {
        double[] s = new double[1];
        if(amount>5000){
            s[0]= amount*0.04;
            return s;
        }else if (amount>1000 && amount<5000 ){
            s[0]=amount*0.02;
            return s;
        }else {
            s[0] = amount*0.01;
            return s;
        }
    }

    @Override
    public String getAccountTypeName() {
        return "SavingAccount";
    }
}

