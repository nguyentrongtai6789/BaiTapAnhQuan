import java.io.Serializable;

public class Category implements Serializable {
    private String name;
    public static int idCate = 1;
    private int id;
    private static final long serializable = 12345678l;
    public Category(String name) {
        this.name = name;
        this.id = idCate;
        idCate++;
    }
    public Category(String name, int id) {
        this.id = id;
        this.name = name;
    }
    public Category() {
        this.id = idCate;
        idCate++;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
