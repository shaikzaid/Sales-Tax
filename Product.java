package dsaProblems;

public class Product {
    private String name;
    private double price;
    private boolean imported;
    private boolean exempted;
    private int quantity;

    public Product(String name, double price, boolean imported, boolean exempted,int quantity) {
        this.name = name;
        this.price = price;
        this.imported = imported;
        this.exempted = exempted;
        this.quantity=quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public boolean isImported() {
        return imported;
    }

    public boolean isExempted() {
        return exempted;
    }
}

