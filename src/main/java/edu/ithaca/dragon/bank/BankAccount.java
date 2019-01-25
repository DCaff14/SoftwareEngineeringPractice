package edu.ithaca.dragon.bank;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance){
        if (isEmailValid(email)){
            this.email = email;
            this.balance = startingBalance;
        }
        else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
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
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     */
    public void withdraw (double amount)  {
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
}
