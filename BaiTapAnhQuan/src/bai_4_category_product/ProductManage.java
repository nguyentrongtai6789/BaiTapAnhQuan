package bai_4_category_product;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class ProductManage {
    Product product1 = new Product("Iphone 14", 25_000_000, "Iphone", "Hàng xách tay Hàn Quốc, mới 100%",
            CategoryManage.category1, 10);
    Product product2 = new Product("Pavillion", 15_000_000, "Hp", "Hàng công ty, mới 100%",
            CategoryManage.category2, 15);
    Product product3 = new Product("Ipad 2", 8_000_000, "Iphone", "Hàng công ty, mới 100%",
            CategoryManage.category3, 5);
    List<Product> productList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void setProductList() {
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        writeProductListToFile(productList);
    }

//    public void setCategorylist() {
//        try {
//            File file = new File("D:\\module2\\BaiTapAnhQuan\\BaiTapAnhQuanTuan2\\src\\bai_4_category_product\\Category");
//            FileInputStream fileInputStream = new FileInputStream(file);
//            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//            categorylist = (List<Category>) objectInputStream.readObject();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }


    public void writeProductListToFile(List<Product> productList) {
        try {
            File file = new File("D:\\module2\\BaiTapAnhQuan\\BaiTapAnhQuanTuan2\\src\\bai_4_category_product\\Product");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(productList);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readProductListFromFile() {
        try {
            File file = new File("D:\\module2\\BaiTapAnhQuan\\BaiTapAnhQuanTuan2\\src\\bai_4_category_product\\Product");
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            productList = (List<Product>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void displayProductList() {
        System.out.println("Danh sách sản phẩm trong cửa hàng gồm có " + productList.size() + " sản phẩm, như sau:");
        for (int i = 0; i < productList.size(); i++) {
            System.out.println((i + 1) + ". " + productList.get(i));
        }
    }

    public void addProduct() {

        Product product = new Product();
        System.out.println("Nhập tên của sản phẩm mới:");
        String name = scanner.nextLine();
        product.setName(name);
        while (true) {
            try {
                System.out.println("Nhập giá của sản phẩm mới:");
                double price = Double.parseDouble(scanner.nextLine());
                product.setPrice(price);
                break;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Nhập hãng sản xuất của sản phẩm mới:");
        String manufacturer = scanner.nextLine();
        product.setManufacturer(manufacturer);
        System.out.println("Nhập mô tả của sản phẩm mới: ");
        String description = scanner.nextLine();
        product.setManufacturer(description);
        while (true) {
            try {
                System.out.println("Nhập danh mục của sản phẩm:");
                String nameCategory = scanner.nextLine();
                boolean flag = false;
                for (Category category : CategoryManage.categoryList) {
                    if (category.getName().equals(nameCategory)) {
                        product.setCategory(category);
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    throw new Exception("Tên danh mục không đúng.");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("Nhập số lượng cúa sản phẩm mới:");
                int quantity = Integer.parseInt(scanner.nextLine());
                product.setQuantity(quantity);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Kiểu dữ liệu nhập vào không đúng.");
            }
        }
        productList.add(product);
        writeProductListToFile(productList);
    }
}
