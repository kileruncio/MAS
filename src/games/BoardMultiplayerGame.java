package games;

public class BoardMultiplayerGame extends Game {
    private String title;
    private int lengthOfPlay;

    public BoardMultiplayerGame(String producer, double price, int numberOfRequiredPlayers, String title, int lengthOfPlay) {
        super(producer, price, numberOfRequiredPlayers);
        this.title = title;
        this.lengthOfPlay = lengthOfPlay;
    }

    public String getTitle() {
        return title;
    }

    public int getLengthOfPlay() {
        return lengthOfPlay;
    }

    @Override
    public String play() {
        return "Game is being played";
    }

}
