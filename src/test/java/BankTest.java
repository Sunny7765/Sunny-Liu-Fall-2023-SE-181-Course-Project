import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BankTest {
    Bank bank;

    @BeforeEach
    void setUp() {
        bank = new Bank();
    }

    @Test
    void bank_has_no_accounts_initially() {
        assertEquals(0, bank.getNumberOfAccounts());
    }

    @Test
    public void add_one_account_to_bank() {
        Account account = new Checking(12345678, 0.0);
        bank.addAccount(account);

        assertEquals(1, bank.getNumberOfAccounts());
    }

    @Test
    public void add_two_accounts_to_bank() {
        Account account1 = new Checking(12345678, 0.0);
        Account account2 = new Checking(87654321, 0.0);
        bank.addAccount(account1);
        bank.addAccount(account2);

        assertEquals(2, bank.getNumberOfAccounts());
    }

    @Test
    public void retrieve_one_account_from_bank() {
        Checking account = new Checking(12345678, 0.0);
        bank.addAccount(account);
        Account retrievedAccount = bank.getAccount(12345678);

        assertEquals(account, retrievedAccount);
    }

    @Test
    public void deposit_money_by_ID_through_bank() {
        Account account = new Checking(12345678, 0.0);
        bank.addAccount(account);
        bank.deposit(12345678, 100.0);

        assertEquals(100.0, account.getBalance(), 0.001);
    }

    @Test
    public void withdraw_money_by_ID_through_bank() {
        Account account = new Checking(12345678, 0.0);
        bank.addAccount(account);
        bank.deposit(12345678, 200.0);
        bank.withdraw(12345678, 100.0);

        assertEquals(100.0, account.getBalance(), 0.001);
    }

    @Test
    public void deposit_twice_through_bank() {
        Account account = new Checking(12345678, 0.0);
        bank.addAccount(account);
        bank.deposit(12345678, 50.0);
        bank.deposit(12345678, 75.0);

        assertEquals(125.0, account.getBalance(), 0.001);
    }

    @Test
    public void withdraw_twice_through_bank() {
        Account account = new Checking(12345678, 0.0);
        bank.addAccount(account);
        bank.deposit(12345678, 200.0);
        bank.withdraw(12345678, 50.0);
        bank.withdraw(12345678, 75.0);

        assertEquals(75.0, account.getBalance(), 0.001);
    }
}
