package banking;

import main.java.framework.AccountStrategy;

public class CreditAccount  implements AccountStrategy {
    @Override
    public double[] execute(double amount) {
        double[] c = new double[1];
        if (amount > 1000) {
            c[0] = amount * 0.025;
            return c;
        } else {
            c[0] = amount * 0.015;
            return c;
        }


    }

    @Override
    public String getAccountTypeName() {
        return "Checking Account";
    }
}