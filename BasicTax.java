package dsaProblems;

public class BasicTax implements Taxable {
    private static final double TAX_RATE = 0.1;

    @Override
    public double calculateTax(double price) {
        return Math.round(price * TAX_RATE * 20) / 20.0;
    }
}
