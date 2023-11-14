import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
                new Hammer("me", "one-hand", null, 10, new ArrayList<>()/**/)
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

        // normal
        try {
            tools[0].addToToolbox(toolbox1);
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        System.out.println(toolbox1.getTools().toString());

        Transaction transaction = new Transaction(48.24, owner1, toolShop1); // asocjacja z atrybutem - klasa Transaction jest odpowada za atrybut w asocjacji pomiędzy Owner a Toolshop
        System.out.println(owner1.getTransactions().toString());
        System.out.println(toolShop1.getTransactions().toString());
        System.out.println(transaction);

        try {
            owner1.addToolbox(toolbox1.serialNumber, toolbox1); // asocjacja kwalifikowana - Owner może posiadać wiele Toolboxów i są one jednoznacznie klasyfikowane poprzez ich numer seryjny
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        System.out.println("Owner has: " + owner1.getToolboxes().toString());

        try {
            Part.createPart("screw", tools[0]); // kompozycja - obiekty Part są powiązane z konkretnym obiektem Tool i mogą istnieć tylko gdy konkretny obiekt Tool też istnieje 
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        System.out.println("Parts: " + tools[0].getParts().toString());

    }
}
