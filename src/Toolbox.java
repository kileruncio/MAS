import java.util.ArrayList;

public class Toolbox {
    private Owner owner;
    private ArrayList<Tool> tools;

    public Toolbox() {
        this.owner = null;
        this.tools = new ArrayList<>();
    }

    public Toolbox(Owner owner) {
        this.owner = owner;
        this.tools = new ArrayList<>();
    }

    public void addTool(Tool tool) {
        this.tools.add(tool);
    }

    public Owner getOwner() {
        return this.owner;
    }

    public ArrayList<Tool> getTools(){
        return this.tools;
    }
}
