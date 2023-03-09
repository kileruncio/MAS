import java.util.ArrayList;

public class Toolbox {
    private String owner;
    private ArrayList<Tool> tools;

    public Toolbox(String owner) {
        this.owner = owner;
        this.tools = new ArrayList<>();
    }

    public void addTool(Tool tool) {
        this.tools.add(tool);
    }

    public String getOwner() {
        return this.owner;
    }
}
