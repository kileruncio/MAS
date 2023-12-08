package games;

public class Keyboard extends Controler {
    private String typeOfKeyboard;

    public Keyboard(String producer, int numberOfButtons, String typeOfKeyboard) {
        super(producer, numberOfButtons);
        this.typeOfKeyboard = typeOfKeyboard;
    }

    public Keyboard(Controler controler, String typeOfKeyboard) {
        super(controler.getProducer(), controler.getNumberOfButtons());
        this.typeOfKeyboard = typeOfKeyboard;
    }

    public String getTypeOfKeyboard() {
        return typeOfKeyboard;
    }

    @Override
    public String toString() {
        return "Keyboard, producer: " +  this.getProducer() + " type of keyboard: " + getTypeOfKeyboard();
    }

}
