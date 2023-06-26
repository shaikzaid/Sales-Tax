package dsaProblems;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ItemList {
    private List<Product> products;

    public ItemList() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product, int quantity) {
        for (int i = 0; i < 1; i++) {
            products.add(product);
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public double calculateTotalSales() {
        double totalSales = 0;
        for (Product product : products) {
            totalSales += product.getPrice();
        }
        return totalSales;
    }

    public double calculateSalesTaxes() {
        double salesTaxes = 0;
        for (Product product : products) {

            double taxAmount = 0;

            if (product.isImported() && product.isExempted()) {
                taxAmount += calculateImportTax(product.getPrice());
            } else if (product.isImported() && !product.isExempted()) {
                taxAmount += calculateImportTax(product.getPrice()) + calculateSalesTax(product.getPrice());
            } else if (!product.isExempted()) {
                taxAmount += calculateSalesTax(product.getPrice());
            } else if (product.isExempted()) {
                taxAmount = 0;
            }

            salesTaxes += taxAmount;
            double price1 = product.getPrice();
            price1 += taxAmount;
            if (product.isImported()) {
                System.out.print(product.getQuantity()+" Imported " + product.getName() + " ");
             System.out.printf("%.2f%n", price1);

            } else {
                System.out.print(product.getQuantity()+" " + product.getName() + " ");
                System.out.printf("%.2f%n", price1);
            }


        }
        return salesTaxes;
    }
    public double calculateImportTax(double price) {
        double percent = 0.05;
        return Math.round(price * percent * 20) / 20.0;
    }

    public double calculateSalesTax(double price) {
        double percent = 0.1;
        return Math.round(price * percent * 20) / 20.0;
    }
}


