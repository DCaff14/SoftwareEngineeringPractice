package edu.ithaca.dragon.bank;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid or if amount is invalid
     */
    public BankAccount(String email, double startingBalance){
        if (isEmailValid(email) && isAmountValid(startingBalance)){
            this.email = email;
            this.balance = startingBalance;
        }
        else {
            throw new IllegalArgumentException("Either email or starting balance is invalid");
        }
    }

    public double getBalance(){
        return balance;
    }

    public String getEmail(){
        return email;
    }

    /**
     * @throws InsufficientFundsException if amount is greater than balance
     * @throws IllegalArgumentException if amount is invalid
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     */
    public void withdraw (double amount) throws InsufficientFundsException, IllegalArgumentException {
        if (amount > balance) {
            throw new InsufficientFundsException("Withdraw not made; Insufficient funds");
        }
        if (!isAmountValid(amount)) {
            throw new IllegalArgumentException("Amount must be greater than 0 and have 2 or fewer decimal places");
        }
        balance -= amount;

    }


    public static boolean isEmailValid(String email){
        if (email.length() < 3) {
            return false;
        }
        int numOfAts = 0;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                numOfAts++;
            }
        }
        if (numOfAts != 1){
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * @param amount
     * @return true if amount is positive and has two decimal points or less and false otherwise
     */
    public static boolean isAmountValid(double amount) {
        if (amount > 0) {
            int decimalPlaces = String.valueOf(amount).split("\\.")[1].length();
            if (decimalPlaces <= 2) {
                return true;
            }
            return false;
        } else {
            return false;
        }
    }
}
