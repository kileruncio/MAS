import java.util.List;

public class Hammer extends Tool{

    public Hammer(String owner, String type, String producent, int numberOfTools, List<String> languagesOfInstruction) {
        super(owner, type, producent, numberOfTools, languagesOfInstruction);
    }
    
    @Override
    public String use(){
        return "Bum, bum, bum"; 
    }
}
