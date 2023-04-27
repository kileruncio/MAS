package taxOffice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaxOffice {
    private String address;
    private int number;
    private List<Director> directors;
    private Director mainDirector;
    private List<Author> authors;
    public static Set<String> addresses = new HashSet<>();

    public TaxOffice(String addres) throws Exception {
        this.directors = new ArrayList<>();
        this.authors = new ArrayList<>();
        setAddress(addres);
    }

    public String getAddress() {
        return this.address;
    }

    public int getNumber() {
        return this.number;
    }

    private void setAddress(String address) throws Exception {
        if (!addresses.contains(address)) {
            addresses.add(address);
            this.address = address;
        } else
            throw new Exception("Ther's already TaxOffice with this address");
    }

    public void setNumber(int number) throws Exception {
        if (number > 0)
            this.number = number;
        else
            throw new Exception("Number of a TaxOffice must be positive");
    }

    public void addDirector(Director director){
        if (directors == null){
            this.directors = new ArrayList<>();
        }
        this.directors.add(director);
        director.setTaxOffice(this);
    }

    public void chooseMainDirector(Director director) throws Exception {
        if (this.directors.contains(director))
            this.mainDirector = director;
        else 
            throw new Exception("This Director is not a part of this TaxOffice");
    }

    public Director getMainDirector() {
        return mainDirector;
    }
}
