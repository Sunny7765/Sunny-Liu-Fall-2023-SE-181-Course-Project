import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckingTest {
    Checking checking;

    @BeforeEach
    public void setUp() {
        checking = new Checking(12345678, 0.6);
    }

    @Test
    public void checking_account_has_balance_of_zero_initially() {
        assertEquals(0, checking.getBalance());
    }

    @Test
    public void checking_account_has_0_apr_initially() {
        double apr = checking.getApr();

        assertEquals(0.6, apr);
    }

    @Test
    public void deposit_to_checking_account() {
        double initialBalance = checking.getBalance();
        double depositAmount = 420.0;
        double newBalance = checking.depositBalance(depositAmount);

        assertEquals(initialBalance + depositAmount, newBalance, 0.001);
    }

    @Test
    public void withdraw_from_checking_account() {
        checking.depositBalance(420.00);
        double initialBalance = checking.getBalance();
        double withdrawAmount = 100.0;
        checking.withdrawBalance(withdrawAmount);
        double newBalance = checking.getBalance();

        assertEquals(initialBalance - withdrawAmount, newBalance, 0.001);
    }

    @Test
    public void withdraws_can_not_go_below_0() {
        checking.depositBalance(50);
        checking.withdrawBalance(100);
        double newBalance = checking.getBalance();

        assertEquals(0.0, newBalance, 0.001);
    }

    @Test
    public void deposit_twice_into_the_same_account() {
        checking.depositBalance(100.0);
        checking.depositBalance(150.0);
        assertEquals(250.0, checking.getBalance(), 0.001);
    }

    @Test
    public void withdraw_twice_from_the_same_account() {
        checking.depositBalance(300.0);
        checking.withdrawBalance(50.0);
        checking.withdrawBalance(75.0);
        assertEquals(175.0, checking.getBalance(), 0.001);
    }

}
