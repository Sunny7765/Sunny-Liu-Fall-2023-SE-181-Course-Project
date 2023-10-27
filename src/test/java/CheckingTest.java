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
}
