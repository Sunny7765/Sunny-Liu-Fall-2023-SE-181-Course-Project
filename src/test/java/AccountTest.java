import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    Checking checking;

    @BeforeEach
    public void setUp() {
        checking = new Checking(12345678, 0.6);
    }

    @Test
    public void deposit_to_account() {
        double initialBalance = checking.getBalance();
        double depositAmount = 420.00;

        checking.depositBalance(depositAmount);

        assertEquals(depositAmount, 420.00);
    }

}