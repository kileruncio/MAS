package games;

public class DigitalGame extends Game {

    public DigitalGame(String producer, double price, String requirements) {
        super(producer, price, requirements);
        
    }

    @Override
    public String play() {
        return "Turning game on";
    }
    
}
