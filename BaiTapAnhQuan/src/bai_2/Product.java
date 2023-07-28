package bai_2;

public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private String description;
    public Product() {
    }

    public Product(int id, String name, double price, int quantity, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }
    public double getTongTien() {
        return quantity*price;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "San pham " + getName()
                + ", co id la: " + getId()
                + ", co gia la: " + getPrice()
                + ", so luong trong kho la: " + getQuantity()
                + ", mo ta: " + getDescription();
    }
}
