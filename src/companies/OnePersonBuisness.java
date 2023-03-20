package companies;

import java.time.LocalDateTime;

public class OnePersonBuisness extends SmallBuisness implements companies.Personable {
    private int yearOfBirth;
    private double tax;

    public OnePersonBuisness(String address, String name, int yearOfBirth, double tax) {
        super(address, name);
        this.yearOfBirth = yearOfBirth;
        this.tax = tax;
    }

    public int getAge() {
        return LocalDateTime.now().getYear() - this.yearOfBirth;
    }

    @Override
    public double moneyAfterTax() {
        return super.getProfit() * (1 - this.tax);
    }

}
