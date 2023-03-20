package companies;

public class Corporation extends Company {
    private double income;

    public Corporation(String address, String name) {
        super(address, name);
        this.income = Math.random() * 100000;
    }

    @Override
    public double getProfit() {
        return income * 0.3;
    }

}
