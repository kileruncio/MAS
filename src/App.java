import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import companies.Corporation;
import companies.Company;
import companies.SmallBuisness;
import tool.Hammer;
import tool.Owner;
import tool.Part;
import tool.Tool;
import tool.ToolShop;
import tool.Toolbox;
import tool.Transaction;

public class App {
    final static String fileName = "data/data.kfc";

    public static void main(String[] args) {
        List<String> languages0 = new ArrayList<>();
        List<String> languages1 = new ArrayList<>();
        languages0.add("en");
        languages0.add("fr");
        languages1.add("jp");
        languages1.add("hr");

        Tool[] tools = {
                new Tool(null, "machanick", null, 2, languages0),
                new Tool("Bosh", "automatic", "producer", 5, languages1),
                new Hammer("me", "one-hand", null, 1, new ArrayList<>())
        };

        for (Tool it : tools) {
            System.out.println(it.toString());
            System.out.println(it.use());
        }

        System.out.println(Tool.numberOfDifferentTools());

        try {
            var out = new ObjectOutputStream(new FileOutputStream(fileName));
            Tool.writeTools(out);
            out.close();

            var in = new ObjectInputStream(new FileInputStream(fileName));
            Tool.readTools(in);
            in.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        System.out.println("------------------------\n");

        System.out.println(Tool.numberOfDifferentTools());
        System.out.println(Tool.getFromTools());

        // -----------------------MP2-----------------------
        Toolbox toolbox1 = new Toolbox();
        ToolShop toolShop1 = new ToolShop("cheap");
        Owner owner1 = new Owner("alice", "xx-343-yt");

        // normal
        try {
            tools[0].addToToolbox(toolbox1);
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        System.out.println(toolbox1.getTools().toString());

        // attribute
        Transaction transaction = new Transaction(48.24, owner1, toolShop1);
        System.out.println(owner1.getTransactions().toString());
        System.out.println(toolShop1.getTransactions().toString());

        // aggravated
        try {
            owner1.addToolbox("basic", toolbox1);
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        System.out.println("Owner has: " + owner1.getToolboxes().toString());

        // composition
        try {
            Part.createPart("screw", tools[0]);
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        System.out.println("Parts: " + tools[0].getParts().toString());

        // -----------------------MP3-----------------------

        ArrayList<Company> companies = new ArrayList<>();
        companies.add(new SmallBuisness("Topolowa 8, 00-999 Warcaby", "Wyroby Tomka"));
        companies.add(new Corporation("USA", "Nivea"));

        for(Company company : companies)
            System.out.println(company.getProfit());
    }
}
