import java.util.ArrayList;

public class Toolbox {
    public int serialNumber;
    private Owner owner;
    private ArrayList<Tool> tools;

    public Toolbox(int serialNumber) {
        this.serialNumber = serialNumber;
        this.owner = null;
        this.tools = new ArrayList<>();
    }

    public Toolbox(Owner owner) {
        this.owner = owner;
        this.tools = new ArrayList<>();
    }

    public void addTool(Tool tool) throws Exception {
        if (!this.tools.contains(tool))
            this.tools.add(tool);
        else
            throw new Exception("Tool already in the toolbox");
    }

    public Owner getOwner() {
        return this.owner;
    }

    public ArrayList<Tool> getTools() {
        return this.tools;
    }

    public void setOwner(Owner owner) throws Exception {
        if (this.owner == null)
            this.owner = owner;
        else
            throw new Exception("Already owned by: " + this.owner.toString());
    }
}
