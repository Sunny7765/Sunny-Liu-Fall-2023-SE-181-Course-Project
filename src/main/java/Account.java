public abstract class Account {
    private int id;
    private double apr;
    private double balance;

    public Account(int id, double apr) {
        this.id = id;
        this.apr = apr;
        this.balance = 0.0;
    }

    public int getId() {
        return id;
    }

    public double getApr() {
        return apr;
    }

    public double getBalance() {
        return balance;
    }

    public double depositBalance(double amount) {
        balance += amount;
        return amount;
    }

    public void withdrawBalance(double amount) {
        if (balance - amount >= 0) {
            balance -= amount;
        } else {
            balance = 0;
        }
    }
}
