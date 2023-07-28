package bai_4_category_product;

import java.io.Serializable;

public class Category implements Serializable {
    private String name;
    private static int idCate = 1;
    private int id;
    private static final long seriaizable = 12345678l;

    public Category(String name) {
        this.name = name;
        this.id = idCate;
        idCate++;
    }
    public Category() {
        this.id = idCate;
        idCate++;
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
