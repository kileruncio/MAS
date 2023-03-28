package games;

public class FabularDigitalGame extends Game {
    private int possilbeEdings;

    public FabularDigitalGame(String producer, double price, String requirements, int possilbeEdings) {
        super(producer, price, requirements);
        this.possilbeEdings = possilbeEdings;
    }

    public int getPossilbeEdings() {
        return possilbeEdings;
    }

    @Override
    public String play() {
        return "Turning game on";
    }

}
