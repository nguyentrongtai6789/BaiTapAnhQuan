package bai_3_ArrayListProduct;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductManage extends ArrayList<Product> {
    Scanner scanner = new Scanner(System.in);
     Product product1 = new Product(1, "Bánh quy", 10000, 30, "Bánh quy bơ sữa");
    Product product2 = new Product(2, "Bánh mỳ", 12000, 20, "Bánh mì pa-te");
    Product product3 = new Product(3, "Kẹo lạc", 15000, 40, "Kẹo lạc dừa");
    Product product4 = new Product(4, "Nước ngọt", 10000, 50, "Nước cam");
    Product product5 = new Product(5, "Bim bim", 5000, 25, "Bim bim đậu xanh");
    ArrayList<Product> productList;

    public ProductManage() {
        productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
    }

    public void displayProductList() {
        System.out.println("All product:");
        for (Product product : productList) {
            System.out.println((productList.indexOf(product) + 1) + ". " + product);
        }
    }

    public void addProduct() {
        System.out.println("Enter the name of the new product:");
        String name = scanner.nextLine();
        System.out.println("Enter the id of the new product:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the price of the new product:");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter the quantity of the new product:");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the describe of the new product:");
        String describe = scanner.nextLine();
        Product newProduct = new Product(id, name, price, quantity, describe);
        productList.add(newProduct);
    }

    public void editProduct() {
        System.out.println("Enter the ID of the product:");
        int id = Integer.parseInt(scanner.nextLine());
        boolean flag = false;
        for (Product product : productList) {
            if (product.getId() == id) {
                flag = true;
                System.out.println("Enter the new name:");
                String name = scanner.nextLine();
                product.setName(name);
                System.out.println("Enter the new ID:");
                int idNew = Integer.parseInt(scanner.nextLine());
                product.setId(idNew);
                System.out.println("Enter the new price:");
                double price = Double.parseDouble(scanner.nextLine());
                product.setPrice(price);
                System.out.println("Enter the new quantity:");
                int quantity = Integer.parseInt(scanner.nextLine());
                product.setQuantity(quantity);
                System.out.println("Enter the new describe:");
                String describe = scanner.nextLine();
                product.setDescription(describe);
                Product newEditProduct = new Product(idNew, name, price, quantity, describe);
                product = newEditProduct;
                break;
            }

        }
        if (flag) {
            System.out.println("The ID exist in the list products.");
        } else {
            System.out.println("The ID is no exist in the list products.");
        }
    }

    public void deleteProduct() {
        System.out.println("Enter the ID of the product must to delete:");
        int id = Integer.parseInt(scanner.nextLine());
        boolean flag = false;
        int idDelete;
        for (Product product : productList) {
            if (product.getId() == id) {
                flag = true;
                productList.remove(product);
                break;
            }
        }
        if (flag) {
            System.out.println("The ID exist in the list products.");
        } else {
            System.out.println("The ID is no exist in the list products.");
        }
    }

    public void maxPrice() {
        double maxPrice = product1.getPrice();
        for (Product product : productList) {
            if (product.getPrice() > maxPrice) {
                maxPrice = product.getPrice();
            }
        }
        System.out.println("The products with max price: ");
        for (Product product : productList) {
            if (product.getPrice() == maxPrice) {
                System.out.println(product);
            }
        }
    }

    public void minPrice() {
        double minPrice = product1.getPrice();
        for (Product product : productList) {
            if (product.getPrice() < minPrice) {
                minPrice = product.getPrice();
            }
        }
        System.out.println("The products with min price:");
        for (Product product : productList) {
            if (product.getPrice() == minPrice) {
                System.out.println(product);
            }
        }
    }
}
