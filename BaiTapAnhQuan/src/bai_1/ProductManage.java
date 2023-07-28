package bai_1;

import java.util.Scanner;

public class ProductManage {
    Scanner scanner = new Scanner(System.in);
    Product[] products;

    public void displayProducts() {
        int totalQuantity;
        do {
            System.out.println("Enter the total quantity of products:");
            totalQuantity = Integer.parseInt(scanner.nextLine());
            if (totalQuantity <= 0) {
                System.out.println("The quantity of products is not available!");
            }
        } while (totalQuantity <= 0);
        products = new Product[totalQuantity];
        for (int i = 0; i < products.length; i++) {
            products[i] = new Product(0, "", 0, 0, "");
        }
        for (int i = 0; i < products.length; i++) {
            System.out.println("Enter the name of product " + (i + 1));
            String name = scanner.nextLine();
            products[i].setName(name);
            System.out.println("Enter the id of product " + (i + 1));
            int id = Integer.parseInt(scanner.nextLine());
            products[i].setId(id);
            System.out.println("Enter the price of product " + (i + 1));
            double price = Double.parseDouble(scanner.nextLine());
            products[i].setPrice(price);
            System.out.println("Enter the quantity of product " + (i + 1));
            int quantity = Integer.parseInt(scanner.nextLine());
            products[i].setQuantity(quantity);
            System.out.println("Enter the describe of product " + (i + 1));
            String describe = scanner.nextLine();
            products[i].setDescription(describe);
        }
        System.out.println("The list of product:");
        for (Product product : products) {
            System.out.println(product);
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
        Product[] newProducts = new Product[products.length + 1];
        System.arraycopy(products, 0, newProducts, 0, products.length);
        newProducts[newProducts.length - 1] = newProduct;
        products = newProducts;
        System.out.println("The new list products: ");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void editProduct() {
        System.out.println("Enter the ID of the product:");
        int id = Integer.parseInt(scanner.nextLine());
        boolean flag = false;
        for (Product product : products) {
            if (id == product.getId()) {
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
            }
        }
        if (flag) {
            System.out.println("The ID exist in the list products.");
            System.out.println("The new list products: ");
            for (Product product : products) {
                System.out.println(product);
            }
        } else {
            System.out.println("The ID is no exist in the list products.");
            System.out.println("The list of products: ");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public void deleteProduct() {
        System.out.println("Enter the ID of the product must to delete:");
        int id = Integer.parseInt(scanner.nextLine());
        boolean flag = false;
        Product[] newProducts = new Product[products.length - 1];
        for (int i = 0; i < products.length; i++) {
            if (products[i].getId() == id) {
                flag = true;
                System.arraycopy(products, 0, newProducts, 0, i);
                for (int j = i; j < newProducts.length; j++) {
                    newProducts[j] = products[j + 1];
                }
            }
        }
        if (flag) {
            products = newProducts;
            System.out.println("The ID exist in the list products.");
            System.out.println("The new list products: ");
            for (Product product : products) {
                System.out.println(product);
            }
        } else {
            System.out.println("The ID is no exist in the list products.");
            System.out.println("The list of products: ");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public void showMaxPrice() {
        double maxPrice = products[0].getPrice();
        for (Product product : products) {
            if (product.getPrice() > maxPrice) {
                maxPrice = product.getPrice();
            }
        }
        System.out.println("The max price is: " + maxPrice);
        System.out.println("The list of the products with max price:");
        for (Product product : products) {
            if (product.getPrice() == maxPrice) {
                System.out.println(product);
            }
        }
        System.out.println("The list of products: ");
        for (Product product : products) {
            System.out.println(product);
        }

    }

    public void showMinPrice() {
        double minPrice = products[0].getPrice();
        for (Product product : products) {
            if (product.getPrice() < minPrice) {
                minPrice = product.getPrice();
            }
        }
        System.out.println("The min price is: " + minPrice);
        System.out.println("The list of the products with min price:");
        for (Product product : products) {
            if (product.getPrice() == minPrice) {
                System.out.println(product);
            }
        }
        System.out.println("The list of products: ");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void showMaxQuantity() {
        int maxQuantity = products[0].getQuantity();
        for (Product product : products) {
            if (product.getQuantity() > maxQuantity) {
                maxQuantity = product.getQuantity();
            }
        }
        System.out.println("The max quantity is: " + maxQuantity);
        System.out.println("The list of the products with max quantity:");
        for (Product product : products) {
            if (product.getQuantity() == maxQuantity) {
                System.out.println(product);
            }
        }
        System.out.println("The list of products: ");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void showMinQuantity() {
        int minQuantity = products[0].getQuantity();
        for (Product product : products) {
            if (product.getQuantity() < minQuantity) {
                minQuantity = product.getQuantity();
            }
        }
        System.out.println("The min quantity is: " + minQuantity);
        System.out.println("The list of the products with min quantity:");
        for (Product product : products) {
            if (product.getQuantity() == minQuantity) {
                System.out.println(product);
            }
        }
        System.out.println("The list of products: ");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void showTotalMoney() {
        double totalMoney = 0;
        for (Product product : products) {
            totalMoney += product.getTongTien();
        }
        System.out.println("The total money of products: " + totalMoney);
        System.out.println("The list of products: ");
        for (Product product : products) {
            System.out.println(product);
        }
    }
}

