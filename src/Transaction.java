import java.time.LocalDateTime;

public class Transaction {
    private LocalDateTime dateOfTransaction;
    private double cost;
    private Owner owner;
    private ToolShop toolShop;

    public Transaction(double cost, Owner owner, ToolShop toolShop) {
        this.dateOfTransaction = LocalDateTime.now();
        this.cost = cost;
        this.owner = owner;
        this.toolShop = toolShop;
        addTransaction();
    }

    private void addTransaction(){
        this.owner.addTransaction(this);
        this.toolShop.addTransaction(this);
    }

    @Override
    public String toString() {
        return super.toString() + ' ' + this.dateOfTransaction.toString() + ' ' + this.owner.toString() + ' ' + this.toolShop.toString();
    }
}
