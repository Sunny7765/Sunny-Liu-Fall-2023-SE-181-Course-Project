import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Account {

    @Test
    void checking_account_has_balance_of_zero_initially() {
        Checking checking = new Checking();
        assertEquals("Checking", checking.getId());
    }
}
z