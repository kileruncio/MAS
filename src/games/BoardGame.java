package games;

public class BoardGame extends Game {

    public BoardGame(String producer, double price, int numberOfRequiredPlayers) {
        super(producer, price, numberOfRequiredPlayers);
        
    }

    @Override
    public String play() {
        return "Game is being played";
    }
    
}
