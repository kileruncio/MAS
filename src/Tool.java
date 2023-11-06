import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Tool implements Serializable {
    private String owner;
    private String type;
    private String producent;
    private int numberOfTools;
    private LocalDateTime dateOfAcusition;
    private List<String> languagesOfInstruction;
    private static List<Tool> tools = new ArrayList<>();
    private static int minPeopleToUse = 1;

    public Tool(String owner, String type, String producent, int numberOfTools, List<String> languagesOfInstruction) {
        this.owner = owner;                                   // atrybut opcjonalny - zamiast warości można podać null
        this.type = type;                                     // atrybut złożony - przyjowany jest tutaj obiekt String
        this.producent = producent;
        this.numberOfTools = numberOfTools;
        this.languagesOfInstruction = languagesOfInstruction; // atrybut powtarzalny - jest użyta tutaj lista która może mieć wiele wartości
        this.dateOfAcusition = LocalDateTime.now();
        tools.add(this);
    }

    public static void addTool(Tool tool) {
        tools.add(tool);
    }

    public static void removeTool(Tool tool) {
        tools.remove(tool);
    }

    public static int numberOfDifferentTools() {
        return tools.size();
    }

    /**
     * atrybut pochodny
     * ten atrybut jest wyliczany z innych wartości,
     * a nie trzymany w pamięci
     */
    public int getNumberOfInstructions(){
        return this.numberOfTools * this.languagesOfInstruction.size();
    }

    public String use(){
        return "Usage, usage, usage"; 
    }

    // przeciążenie
    public void increseNumberOfATool(int number) {
        this.numberOfTools += number;
    }
    /**
     * przeciążenie
     * obie funkcje increseNumberOfATool mają tą samą nazwę,
     * ale różnią się przyjmowanymi argumentami i działaniem
     */
    public void increseNumberOfATool() {            // przeciążenie
        this.numberOfTools++;
    }

    /**
     * ekstencja - trwałość
     * funkcja writeTools zapisuje obiekty do pliku by zachować ich trwałość
     */
    public static void writeTools(ObjectOutputStream stream) throws IOException {
        stream.writeObject(tools);
    }

    public static void readTools(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ArrayList<Tool> tmp = (ArrayList<Tool>) stream.readObject();
        for(Tool t : tmp)
            tools.add(t);
    }

    /**
     * metoda klasowa
     * metoda klasowa działa na obiektach Tool
     */
    public static String getFromTools(){
        return tools.toString();
    }

    public String getOwner() {
        return this.owner;
    }

    public String getType() {
        return this.type;
    }

    public String getProducent() {
        return this.producent;
    }

    public int getNumberOfTools() {
        return this.numberOfTools;
    }

    public String getDateOfAcusition() {
        return this.dateOfAcusition.toString();
    }

    public String getLanguagesOfInstruction() {
        return this.languagesOfInstruction.toString();
    }

    @Override
    public String toString() {
        return super.toString() + " owner: " + getOwner() + " type: " + getType() + " producent: "
                + getProducent() + " number of tools: " + " date of acusition: " + getDateOfAcusition()
                + " languages of instruction: " + getLanguagesOfInstruction();
    }
}
