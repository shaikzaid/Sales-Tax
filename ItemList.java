package dsaProblems;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ItemList {
    private List<Product> products;
    private Taxable basicTax;
    private Taxable importedTax;

    public ItemList() {
        products = new ArrayList<>();
        basicTax = new BasicTax();
        importedTax = new ImportedTax();
    }

    public void addProduct(Product product) {
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
            //Products which are imported and belong to Category(Book/Medicine/Food) Therefore only ImportedTax
            if (product.isImported() && product.isExempted()) {
                taxAmount += importedTax.calculateTax(product.getPrice());
            }
           //imported products But do not belong to Category(Book/Medicine/Food) therefore ImportedTax and basicTax
            else if (product.isImported() && !product.isExempted()) {
                taxAmount += importedTax.calculateTax(product.getPrice())+basicTax.calculateTax(product.getPrice());
            }
            else if (!product.isExempted()) {
                taxAmount += basicTax.calculateTax(product.getPrice());
                //taxAmount += calculateSalesTax(product.getPrice());
            }
            else if (product.isExempted()) {
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
}


