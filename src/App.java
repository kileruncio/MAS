import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class App {
    final static String fileName = "data/data.kfc";

    public static void main(String[] args) throws Exception {
        List<String> languages0 = new ArrayList<>();
        List<String> languages1 = new ArrayList<>();
        languages0.add("en");
        languages0.add("fr");
        languages1.add("jp");
        languages1.add("hr");

        Tool[] tools = {
                new Tool(null, "machanick", null, 2, languages0),
                new Tool("Bosh", "automatic", "A new company", 5, languages1),
                new Hammer("me", "one-hand", null, 1, new ArrayList<>())
        };

        for (Tool it : tools){
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
    }
}
