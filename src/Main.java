import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    final static String fileName = "data/data.kfc";

    public static void main(String[] args) throws Exception {
        List<String> languages0 = new ArrayList<>();
        List<String> languages1 = new ArrayList<>();
        languages0.add("en");
        languages0.add("fr");
        languages1.add("jp");
        languages1.add("hr");

        Tool[] tools = {
                new Tool(null/*atrybut opcjonalny - można to umieścić wartość lub podać null*/, "machanick", null, 2, languages0),
                new Tool("Bosh"/*atrybut złożony - podaję tutaj obiekt kolekcji*/, "automatic", "A new company", 5, languages1),
                new Hammer("me", "one-hand", null, 1, new ArrayList<>()/*atrybut powtarzalny - jest użyta tutaj lista która może mieć wiele wartości*/)
        };

        for (Tool it : Tool.tools/*ekstenscja - zbiór wszystkich utowrzonych obiektów*/){
            System.out.println(it.toString());
            System.out.println(it.use()/*przesłonięcie - funkcja use jest przesłonięta w obiekcie klasy Hammer*/);
        }

        System.out.println(Tool.numberOfDifferentTools());

        try {
            var out = new ObjectOutputStream(new FileOutputStream(fileName));
            Tool.writeTools(out);                                             // ekstencsja - trwałość
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

        System.out.println(tools[1].getNumberOfInstructions()); // atrybut pochodny - ten atrybut jest wyliczany z innych wartości, a nie trzymany w pamięci
        System.out.println(Tool.numberOfDifferentTools());
        System.out.println(Tool.getFromTools());            // metoda klasowa - działa na obiektach klasy Tool
    }
}
