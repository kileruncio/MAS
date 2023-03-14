import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Owner {
    private String name;
    private String address;
    private ArrayList<Tool> ownedTool;
    private ArrayList<Transaction> transactions;
    private Map<String, Toolbox> toolboxes = new TreeMap<>();

    public Owner(String name, String address) {
        this.name = name;
        this.address = address;
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction){
        this.transactions.add(transaction);
    }

    public ArrayList<Transaction> getTransactions(){
        return this.transactions;
    }
    //kompozycja z toolbox
}
