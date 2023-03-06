import java.time.LocalDateTime;

public class Tool {
    protected String owner;
    protected String type;
    protected String producent;
    protected int numberOfTools;
    protected LocalDateTime dateOfAcusition;

    public Tool(String owner, String type, String producent, int numberOfTools ){
        this.owner = owner;
        this.type = type;
        this.producent = producent;
        this.numberOfTools = numberOfTools;
        this.dateOfAcusition = LocalDateTime.now();
    }

    public void use(){
        
    }
}
