import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SavingsTest {
    Savings savings;

    @BeforeEach
    public void setUp() {
        savings = new Savings(87654321, 7.9);
    }

    @Test
    public void savings_account_has_balance_of_zero_initially() {
        assertEquals(0, savings.getBalance());
    }
}
