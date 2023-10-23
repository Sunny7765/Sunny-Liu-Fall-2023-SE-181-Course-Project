import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SavingsTest {
    Savings savings;

    @BeforeEach
    public void setUp() {
        savings = new Savings(00000001, 7.9);
    }

    @Test
    public void savings_account_has_balance_of_zero_initially() {
        assertEquals(0, savings.getBalance());
    }

    @Test
    public void savings_account_has_0_apr_initially() {
        double apr = savings.getApr();

        assertEquals(7.9, apr);
    }

    @Test
    public void deposit_to_savings_account() {
        double initialBalance = savings.getBalance();
        double depositAmount = 420.0;
        double newBalance = savings.depositBalance(depositAmount);

        assertEquals(initialBalance + depositAmount, newBalance, 0.001);
    }

    @Test
    public void withdraw_from_savings_account() {
        savings.depositBalance(420.00);
        double initialBalance = savings.getBalance();
        double withdrawAmount = 100.0;
        savings.withdrawBalance(withdrawAmount);
        double newBalance = savings.getBalance();

        assertEquals(initialBalance - withdrawAmount, newBalance, 0.001);
    }

    @Test
    public void withdraws_can_not_go_below_0() {
        savings.depositBalance(50);
        savings.withdrawBalance(100);
        double newBalance = savings.getBalance();

        assertEquals(0.0, newBalance, 0.001);
    }

    @Test
    public void deposit_twice_into_the_same_account() {
        savings.depositBalance(100.0);
        savings.depositBalance(150.0);
        assertEquals(250.0, savings.getBalance(), 0.001);
    }

    @Test
    public void withdraw_twice_from_the_same_account() {
        savings.depositBalance(300.0);
        savings.withdrawBalance(50.0);
        savings.withdrawBalance(75.0);
        assertEquals(175.0, savings.getBalance(), 0.001);
    }
}
