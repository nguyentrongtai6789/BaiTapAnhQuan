import java.io.Serializable;
import java.text.DecimalFormat;

public class Product implements Serializable, Comparable<Product> {
    public static int idClass = 1;
    private String name;
    private double price;
    private String manufacturer;
    private String description;
    private Category category;
    private int id;
    private int quantity;
    private static final long serializable = 1234567l;
    public Product() {
        this.id = idClass;
        idClass++;
    }

    public Product(String name, double price, String manufacturer, String description, Category category, int quantity) {
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
        this.description = description;
        this.category = category;
        this.quantity = quantity;
        this.id = idClass++;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static int getIdClass() {
        return idClass;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public int getId() {
        return id;
    }

    public static void setIdClass(int idClass) {
        Product.idClass = idClass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###.##");
        String formattedPrice = decimalFormat.format(price);
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + formattedPrice +
                ", manufacturer='" + manufacturer + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        return (int) (- this.getPrice() + o.getPrice());
    }
}
