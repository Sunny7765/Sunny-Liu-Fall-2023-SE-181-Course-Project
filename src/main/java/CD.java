public class CD extends Account {
    public CD(int id, double apr, double balance) {
        super(id, apr);
        this.depositBalance(balance);
    }
}
