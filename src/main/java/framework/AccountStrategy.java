package main.java.framework;

public interface AccountStrategy {
    double[] execute(double credit);
    String getAccountTypeName();
}
