package com.github.zipcodewilmington.casino;

public class CasinoAccount {
    private String accountName;
    private String accountPassword;
    private double accountBalance;

    public CasinoAccount(String accountName, String accountPassword) {
        this.accountName = accountName;
        this.accountPassword = accountPassword;
        accountBalance = 0.00;
    }

    public boolean depositToBalance(double deposit) {
        if (deposit > 0) {
            accountBalance += deposit;
            return true;
        } else {
            System.out.println("Less than $0.00");
            return false;
        }
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {this.accountBalance = accountBalance;}

}



