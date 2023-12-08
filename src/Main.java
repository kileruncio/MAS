import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import companies.Company;
import companies.Corporation;
import companies.Employee;
import companies.EmployeeType;
import companies.OnePersonBuisness;
import companies.SmallBuisness;
import games.BoardMultiplayerGame;
import games.Controler;
import games.FabularDigitalGame;
import games.Game;
import games.Guitar;
import games.Keyboard;
import tool.Hammer;
import tool.Owner;
import tool.Part;
import tool.Screwdriver;
import tool.Tool;
import tool.ToolShop;
import tool.Toolbox;
import tool.Transaction;

public class Main {
    final static String fileName = "data/data.kfc";

    public static void main(String[] args) throws Exception {
        // -----------------------MP1-----------------------
        List<String> languages0 = new ArrayList<>();
        List<String> languages1 = new ArrayList<>();
        languages0.add("en");
        languages0.add("fr");
        languages1.add("jp");
        languages1.add("hr");

        Tool[] tools = {
                new Tool("LG", "machanick", null, 2, languages0),
                new Tool("Bosh", "automatic", "A new company", 5, languages1),
                new Hammer("me", "one-hand", null, 10, new ArrayList<>())
        };

        tools[0].owner = null; // atrybut opcjonalny - można to umieścić wartość lub podać null
        System.out.println(tools[0].owner);
        tools[1].dateOfAcusition = LocalDateTime.of(2022, 10, 5, 10, 47); // atrybut złożony - pojawia się tutaj obiekt klasy LocalDateTime, a nie typ prosty
        System.out.println(tools[1].dateOfAcusition);
        tools[2].languagesOfInstruction = List.of("de", "pl"); // atrybut powtarzalny - jest użyta tutaj lista która może mieć wiele wartości
        System.out.println(tools[2].languagesOfInstruction);
        var allTools = Tool.tools; // ekstenscja - zbiór wszystkich utowrzonych obiektów

        for (Tool it : allTools) {
            var minPeopleToUse = Tool.minPeopleToUse; // atrybut klasowy - atrybut zaimplementowany z użyciem static
            System.out.println("" + minPeopleToUse);
            var tmp = it.use(); // przesłonięcie - funkcja use jest przesłonięta w obiekcie klasy Hammer, czyli pomimo tej samej nazy i argumentów działa inaczej
            System.out.println("Następuje użycie " + tmp);
            System.out.println(it.toString());
        }

        System.out.println(Tool.numberOfDifferentTools());

        // ekstencsja - trwałość, od linii 46 do 56 następuje zapis danych wraz z obsługą wyjątków
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

        tools[2].increseNumberOfATool();  // przeciążenie
        tools[2].increseNumberOfATool(5); // przeciążenie - obie funkcje increseNumberOfATool mają tą samą nazwę, ale różnią się przyjmowanymi argumentami i działaniem

        System.out.println("------------------------\n");

        var numberOfInstrictions = tools[1].getNumberOfInstructions(); // atrybut pochodny - ten atrybut jest wyliczany z innych wartości, a nie trzymany w pamięci
        System.out.println(numberOfInstrictions);
        System.out.println(Tool.numberOfDifferentTools());
        var numberOfAllTools = Tool.getNumberOfAllTools(); // metoda klasowa - nie jest wymaga utworzony obiekt klasy Tool by móc jej użyć
        System.out.println(numberOfAllTools);

        // -----------------------MP2-----------------------
        Toolbox toolbox1 = new Toolbox(596830);
        ToolShop toolShop1 = new ToolShop("cheap");
        Owner owner1 = new Owner("alice", "xx-343-yt");

        try {
            tools[0].addToToolbox(toolbox1); // binarna - obiekt Tool zostaje powiązany z obiektem Toolbox
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        System.out.println(toolbox1.getTools().toString()); // binarna - wypisanie kolekcji

        Transaction transaction = new Transaction(48.24, owner1, toolShop1); // asocjacja z atrybutem - klasa Transaction jest odpowada za atrybut w asocjacji pomiędzy Owner a Toolshop
        System.out.println(owner1.getTransactions().toString());
        System.out.println(toolShop1.getTransactions().toString());
        System.out.println(transaction.toString()); // asocjacja z atrybutem - wypisanie obiektu Transaction zawierającego atrybut i wiążącego ownera z toolshopem 

        try {
            owner1.addToolbox(toolbox1.serialNumber, toolbox1); // asocjacja kwalifikowana - Owner może posiadać wiele Toolboxów i są one jednoznacznie klasyfikowane poprzez ich numer seryjny
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        System.out.println("Owner has: " + owner1.getToolboxes().toString()); // asocjacja kwalifikowana - wypianie kolekcji obiektów Toolbox z obiektu owner1

        try {
            Part.createPart("screw", tools[0]); // kompozycja - obiekty Part są powiązane z konkretnym obiektem Tool i mogą istnieć tylko gdy konkretny obiekt Tool też istnieje 
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        System.out.println("Parts: " + tools[0].getParts().toString()); // kompozycja - wypisanie kolekcji Parts z obiektu Tool

        // -----------------------MP3-----------------------

        // disjoint - klasy screwdriver oraz hammer są implementowane poprzez disjoint, jest to dziedziczenie rozłączne  
        Tool narzedzie = new Tool("Bosh", "automatic", "A new company", 5, languages1);
        Screwdriver screwdriver = new Screwdriver("Maciej P", "krzyżakowo", null, 1, "red", languages1);
        Hammer hammer = new Hammer("me", "one-hand", null, 10, new ArrayList<>());

        System.out.println("Color of a screwdriver: " + screwdriver.getColor());
        System.out.println(hammer.use());
        System.out.println(narzedzie.use());

        ArrayList<Company> companies = new ArrayList<>(); // klasa abstrakcyjna  - powstaje tutaj lista przechowująca obiekty dziedziczące z klasy abstrakcyjnej, dlatego chodź nie są to obiekty klasy Company mogą one być w tej kolekcji
        companies.add(new SmallBuisness("Topolowa 8, 00-999 Warcaby", "Wyroby Tomka"));
        companies.add(new Corporation("USA", "Nivea"));

        for (Company company : companies)
            System.out.println("Profit of a company: " + company.getProfit());

        ArrayList<Employee> employees = new ArrayList<>(); // overlapping - w tej kolekcji powajwiają się obiekty które mogą należeć do kilku klas na raz np do klasy student i underage
        employees.add(new Employee("MK", true, 3500.50, Arrays.asList(EmployeeType.EMPLOYEE), true));
        employees.add(new Employee("MK", true, 3500.50, Arrays.asList(EmployeeType.STUDENT, EmployeeType.UNDERAGE), true));

        for (Employee employee : employees)
            System.out.println("Real salary: " + employee.getRealSalary()); // polimofriczne wywołanie metody - metoda działa inaczej zależnie od właściwej klasy obiektu, w tym trydnym przypadku jest to zależne od obiektu jak i wartości pola employeeType

        OnePersonBuisness wyrobyKrawieckie = new OnePersonBuisness(
            "Taka brama. 07-007 Bulb", "Wyroby Krawieckie", 1993,0.17
            ); // wielodziedziczenie - klasa OnePersonBuisness dziedziczy z klas SmallBuisness oraz Personable
        System.out.println("Wiek: " + wyrobyKrawieckie.getAge());
        System.out.println("Zarobek: " + wyrobyKrawieckie.getProfit());
        System.out.println("Pieniądze po podatku: " + wyrobyKrawieckie.moneyAfterTax());

        ArrayList<Game> games = new ArrayList<>(); // wieloaspektowe - obiekty dziedziczą wieloapektowo po kalsie Game, gry mogą być cyforwe lub wieloosobowe (widać to po konstruktorze), pojawiają się jako przykłady gry planszowe oraz fabularne
        games.add(new BoardMultiplayerGame("lego", 120.0, 3, "dixit", 300));
        games.add(new FabularDigitalGame("EA", 260.0, "at least one brain", 4));

        for (Game game : games) {
            if (game.hasNumberOfRequiredPlayers())
                System.out.println("Liczba wymaganych graczy: " + game.getNumberOfRequiredPlayers());
            else if (game.hasRequirements())
                System.out.println("Wymagania: " + game.getRequirements());
        }

        Controler controler = new Keyboard("MSI", 2137, "chiness"); // dynamiczne - poprzez opcjonalne kopiowanie poprzedniego obiektu obiekt klasy Keyboard może stać się obiektem klasy Guitar i z powrotem
        System.out.println(controler.toString());
        controler = new Guitar(controler, 2);
        System.out.println(controler.toString());
        controler = new Keyboard(controler, "English simplified");
        System.out.println(controler.toString());
    }
}
