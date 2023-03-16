package tool;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Owner {
    private String name;
    private String address;
    private ArrayList<Transaction> transactions;
    private Map<String, Toolbox> toolboxes = new TreeMap<>();

    public Owner(String name, String address) {
        this.name = name;
        this.address = address;
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }

    public void addToolbox(String name, Toolbox toolbox) throws Exception {
        if (toolboxes.get(name) == null) {
            toolboxes.put(name, toolbox);
            toolbox.setOwner(this);
        }else
            throw new Exception("Aleady in collection");

    }

    public Map<String, Toolbox> getToolboxes() {
        return this.toolboxes;
    }
    // kwalifikowana z toolbox
}
