package tool;

import java.util.List;

public class Screwdriver extends Tool {
    public String color;

    public Screwdriver(String owner, String type, String producent, int numberOfTools, String color,
            List<String> languagesOfInstruction) {
        super(owner, type, producent, numberOfTools, languagesOfInstruction);
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
