package dsaProblems;
import java.util.Objects;
import java.util.List;
import java.util.Scanner;

public class SalesTaxes {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        ItemList cart = new ItemList();

        System.out.println("Please enter the quantity of the product");
        int quantity = scn.nextInt();

        while (quantity > 0) {
            System.out.println("Is the product imported? (y/n)");
            boolean imported = Objects.equals(scn.next(), "y");

            System.out.println("Does the product belong any of following category(Book/Food/Medicine)? (y/n)");
            boolean exempted = Objects.equals(scn.next(), "y");

            System.out.println("Enter the product price");
            double price = scn.nextDouble();

            System.out.println("Enter the product name");
            String name = scn.next();

            Product product1 = new Product(name, price, imported, exempted,quantity);
            cart.addProduct(product1, quantity);

            System.out.println("Enter the quantity of the next product (or 0 to finish)");
            quantity = scn.nextInt();

        }
        String roundedValue2 = roundupVal(cart.calculateSalesTaxes());
        System.out.println("   Sales Tax = " + roundedValue2);
        double number = Double.parseDouble(roundedValue2);

        String roundedValue1 = roundupVal(cart.calculateTotalSales());
        double number1 = Double.parseDouble(roundedValue1);
        number1+=number;
        System.out.println("   Total = " + number1);

    }
    private static String roundupVal(double value) {
        double roundedValue = Math.round(value * 20) / 20.0;
        return String.format("%.2f", roundedValue);
    }
}

