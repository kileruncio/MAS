import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import companies.Corporation;
import companies.Employee;
import companies.EmployeeType;
import companies.OnePersonBuisness;
import companies.Company;
import companies.SmallBuisness;
import games.BoardGame;
import games.Controler;
import games.DigitalGame;
import games.Game;
import games.Guitar;
import games.Keyboard;
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

        // abstract & polimorfizm
        ArrayList<Company> companies = new ArrayList<>();
        companies.add(new SmallBuisness("Topolowa 8, 00-999 Warcaby", "Wyroby Tomka"));
        companies.add(new Corporation("USA", "Nivea"));

        for (Company company : companies)
            System.out.println("Profit of a company: " + company.getProfit());

        // overlapping
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("MK", true, 3500.50, Arrays.asList(EmployeeType.Employee)));
        employees.add(new Employee("MK", true, 3500.50, Arrays.asList(EmployeeType.Student, EmployeeType.Underage)));

        for (Employee employee : employees)
            System.out.println("Real salary: " + employee.getRealSalary());

        // multiheritage
        OnePersonBuisness wyrobyKrawieckie = new OnePersonBuisness("Taka brama. 07-007 Bulb", "Wyroby Krawieckie", 1993, 0.17);
        System.out.println("Wiek: " + wyrobyKrawieckie.getAge());
        System.out.println("Zarobek: " + wyrobyKrawieckie.getProfit());
        System.out.println("Pieniądze po podatku: " + wyrobyKrawieckie.moneyAfterTax());

        // multiaspects
        ArrayList<Game> games = new ArrayList<>();
        games.add(new BoardGame("lego", 120.0, 3));
        games.add(new DigitalGame("EA", 260.0, "at least one brain"));

        for (Game game : games) {
            if (game.hasNumberOfRequiredPlayers())
                System.out.println("Liczba wymaganych graczy: " + game.getNumberOfRequiredPlayers());
            else if (game.hasRequirements())
                System.out.println("Wymagania: " + game.getRequirements());
        }

        // dynamic
        Controler controler = new Keyboard("MSI", 2137, "chiness");
        System.out.println(controler.toString());
        controler = new Guitar(controler, 2);
        System.out.println(controler.toString());
        controler = new Keyboard(controler, "English simplified");
        System.out.println(controler.toString());
    }
}
