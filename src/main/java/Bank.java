import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Integer, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public Account getAccount(int accountId) {
        return accounts.get(accountId);
    }

    public void deposit(int accountId, double amount) {
        Account account = accounts.get(accountId);
        if (account != null) {
            account.depositBalance(amount);
        }
    }

    public void withdraw(int accountId, double amount) {
        Account account = accounts.get(accountId);
        if (account != null) {
            account.withdrawBalance(amount);
        }
    }

    public int getNumberOfAccounts() {
        return accounts.size();
    }
}
