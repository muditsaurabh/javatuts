package com.saurabh;

/**
 * Created by muditsaurabh on 11/10/16.
 */
public class TermDepositAccount extends SavingsAccount {
    public TermDepositAccount(double interestRate, int maturityPeriod) {
        super(interestRate);
        this.maturityPeriod = maturityPeriod;
        this.monthsLeft = maturityPeriod;
    }

    @Override
    public void addInterest() {
        super.addInterest();
        monthsLeft = monthsLeft - 1;
    }

    @Override
    public void withdraw(double amount) {
        if(monthsLeft > 0) {
            // assuming 500 to be penalty
            super.withdraw(amount + 10);
        } else {
            super.withdraw(amount);
        }
    }

    private int maturityPeriod;
    private int monthsLeft;
}
