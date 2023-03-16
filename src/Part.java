public class Part {
    private Tool tool;
    private String name;

    private Part(String name, Tool tool) {
        this.name = name;
        this.tool = tool;
    }

    public static Part createPart(String name, Tool tool) throws Exception {
        if (tool == null)
            throw new Exception("Tool does not exists");

        Part part = new Part(name, tool);

        part.tool.addPart(part);
        return part;
    }

    // kompozycja z tool
}
