package games;

public abstract class Game {
    private String producer;
    private double price;
    private int numberOfRequiredPlayers = 0;
    private String requirements = "";

    
    public Game(String producer, double price){
        this.producer = producer;
        this.price = price;
    }

    public Game(String producer, double price, int numberOfRequiredPlayers){
        this.producer = producer;
        this.price = price;
        this.numberOfRequiredPlayers = numberOfRequiredPlayers;
    }

    public Game(String producer, double price, String requirements){
        this.producer = producer;
        this.price = price;
        this.requirements = requirements;
    }

    public boolean hasNumberOfRequiredPlayers(){
        return this.numberOfRequiredPlayers != 0;
    }

    public boolean hasRequirements(){
        return this.requirements.length() > 0;
    }

    public double getPrice() {
        return price;
    }

    public String getProducer() {
        return producer;
    }

    public int getNumberOfRequiredPlayers(){
        return this.numberOfRequiredPlayers;
    }

    public String getRequirements() {
        return requirements;
    }

    public abstract String play();
}
