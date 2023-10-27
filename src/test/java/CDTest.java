import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CDTest {
    CD cd;

    @BeforeEach
    public void setUp() {
        cd = new CD(89456185, 5.7, 1000.0); // CD account with ID 12345678, 5% APR, and $1000 initial balance
    }

    @Test
    public void CD_created_with_amount_deposited() {
        double initialBalance = cd.getBalance();
        double depositAmount = 500.0;
        cd.depositBalance(depositAmount);
        double newBalance = cd.getBalance();

        assertEquals(initialBalance + depositAmount, newBalance, 0.001);
    }
}
