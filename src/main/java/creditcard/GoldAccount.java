package main.java.creditcard;

import main.java.framework.AccountTypeCommand;

public class GoldAccount implements AccountTypeCommand {
    private double getMonthlyInterest(double credit) {
        return credit * 0.06;
    }

    private double getMonthlyMinimumPayment(double credit) {
        return credit * 0.1;
    }

    @Override
    public double[] execute(double credit) {
        double[] a = new double[2];
        a[0] = getMonthlyInterest(credit);
        a[1] = getMonthlyMinimumPayment(credit);
        return a;
    }

    @Override
    public String getAccountTypeName() {
        return "Gold";
    }
}
