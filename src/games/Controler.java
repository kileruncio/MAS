package games;

public abstract class Controler {
    private String producer;
    private int numberOfButtons;

    public Controler(String producer, int numberOfButtons) {
        this.producer = producer;
        this.numberOfButtons = numberOfButtons;
    }

    public int getNumberOfButtons() {
        return numberOfButtons;
    }

    public String getProducer() {
        return producer;
    }
}
