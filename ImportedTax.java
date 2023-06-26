package dsaProblems;

public class ImportedTax implements Taxable{
    private static final double TAX_RATE = 0.05;

    @Override
    public double calculateTax(double price) {
        return Math.round(price * TAX_RATE * 20) / 20.0;
    }
}
