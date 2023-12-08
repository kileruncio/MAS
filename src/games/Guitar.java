package games;

public class Guitar extends Controler {
    private int numberOfPorts;

    public Guitar(String producer, int numberOfButtons, int numberOfPorts) {
        super(producer, numberOfButtons);
        this.numberOfPorts = numberOfPorts;
    }

    public Guitar(Controler controler, int numberOfPorts) {
        super(controler.getProducer(), controler.getNumberOfButtons());
        this.numberOfPorts = numberOfPorts;
    }

    public int getNumberOfPorts() {
        return numberOfPorts;
    }

    @Override
    public String toString() {
        return "Guitar, producer: " +  this.getProducer() + " nuber of ports: " + getNumberOfPorts();
    }

}
