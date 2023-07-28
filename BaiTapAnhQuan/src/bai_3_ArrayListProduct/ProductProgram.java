package bai_3_ArrayListProduct;

import java.util.Scanner;

public class ProductProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManage productManage = new ProductManage();
        int choice;
        do {
            productManage.displayProductList();
            System.out.println("Menu:");
            System.out.println("1. Add a product.");
            System.out.println("2. Edit information of a product by enter ID.");
            System.out.println("3. Delete a product by enter ID.");
            System.out.println("4. Show products have max price.");
            System.out.println("5. Show products have min price");
            System.out.println("0. Exit.");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productManage.addProduct();
                    break;
                case 2:
                    productManage.editProduct();
                    break;
                case 3:
                    productManage.deleteProduct();
                    break;
                case 4:
                    productManage.maxPrice();
                    break;
                case 5:
                    productManage.minPrice();
                    break;
            }
        }
        while (choice != 0);
    }

}
