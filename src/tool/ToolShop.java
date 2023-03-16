package tool;
import java.util.ArrayList;

public class ToolShop {
    private String name;
    private ArrayList<Transaction> transactions;

    public ToolShop(String name) {
        this.name = name;
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }
}
