package tool;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Tool implements Serializable {
    public String owner;
    private String type;
    private String producent;
    protected int numberOfTools;
    public LocalDateTime dateOfAcusition;
    public List<String> languagesOfInstruction;
    private List<Part> parts;
    public static List<Tool> tools = new ArrayList<>();
    public static int minPeopleToUse = 1;
    private Toolbox toolbox;

    public Tool(String owner, String type, String producent, int numberOfTools, List<String> languagesOfInstruction) {
        this.owner = owner;
        this.type = type; 
        this.producent = producent;
        this.numberOfTools = numberOfTools;
        this.languagesOfInstruction = languagesOfInstruction;
        this.dateOfAcusition = LocalDateTime.now();
        this.toolbox = null;
        this.parts = new ArrayList<>();
        tools.add(this);
    }

    public void addToToolbox(Toolbox toolbox) throws Exception {
        if (this.toolbox == null) {
            this.toolbox = toolbox;
            this.toolbox.addTool(this);
        } else
            throw new Exception("already in a toolbox");
    }

    public void addPart(Part part) throws Exception {
        if (!this.parts.contains(part))
            this.parts.add(part);
        else
            throw new Exception("Part cannot be added two times to one tool");
    }

    public List<Part> getParts() {
        return this.parts;
    }

    public void removeFromToolbox() {
        this.toolbox = null;
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

    public int getNumberOfInstructions() {
        return this.numberOfTools * this.languagesOfInstruction.size();
    }

    public String use() {
        return "Usage, usage, usage";
    }

    // przeciążenie
    public void increseNumberOfATool(int number) {
        this.numberOfTools += number;
    }

    public void increseNumberOfATool() {
        this.numberOfTools++;
    }

    public static void writeTools(ObjectOutputStream stream) throws IOException {
        stream.writeObject(tools);
    }

    public static void readTools(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ArrayList<Tool> tmp = (ArrayList<Tool>) stream.readObject();
        for (Tool t : tmp)
            tools.add(t);
    }

    // metoda klasowa
    public static int getNumberOfAllTools(){
        return tools.size();
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
