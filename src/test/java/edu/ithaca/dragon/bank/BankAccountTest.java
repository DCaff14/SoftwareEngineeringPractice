package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    void withdrawTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        try {
            bankAccount.withdraw(100);
        } catch(Exception e) {
            e.printStackTrace();
        }

        assertEquals(100, bankAccount.getBalance());

        assertThrows(InsufficientFundsException.class, ()-> bankAccount.withdraw(1000));
        assertThrows(IllegalArgumentException.class, ()-> bankAccount.withdraw(-1000));
        assertThrows(IllegalArgumentException.class, ()-> bankAccount.withdraw(35.079));
    }

    @Test
    /**
     * A valid email consists of a local part of minimum length 1, and a domain part of minimum length 1
     * separated by an one and only one @
     */
    void isEmailValidTest(){
        assertTrue(BankAccount.isEmailValid( "a@b.com"));
        assertFalse( BankAccount.isEmailValid(""));
        assertFalse(BankAccount.isEmailValid("abc"));
        assertFalse(BankAccount.isEmailValid("gmail.com"));
        assertFalse(BankAccount.isEmailValid("a@b@c.com"));
        assertTrue(BankAccount.isEmailValid("a@b"));
        assertFalse(BankAccount.isEmailValid("a@"));
    }

    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance());
        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("a@b.com", -35));
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("a@b.com", 2.876));
    }

    @Test
    void isAmountValidTest() {
        assertTrue(BankAccount.isAmountValid(2.05));
        assertFalse(BankAccount.isAmountValid(2.079));
        assertFalse(BankAccount.isAmountValid(-1.15));
        assertTrue(BankAccount.isAmountValid(1.5));
        assertTrue(BankAccount.isAmountValid(5));
    }
}