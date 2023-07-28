package bai_1;

import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManage productManage = new ProductManage();
        productManage.displayProducts();
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add a product.");
            System.out.println("2. Edit information of a product by enter ID.");
            System.out.println("3. Delete a product by enter ID.");
            System.out.println("4. Show products have max price.");
            System.out.println("5. Show products have min price");
            System.out.println("6. Show products have max quantity.");
            System.out.println("7. Show products have min quantity.");
            System.out.println("8. Show the total money.");
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
                    productManage.showMaxPrice();
                    break;
                case 5:
                    productManage.showMinPrice();
                    break;
                case 6:
                    productManage.showMaxQuantity();
                    break;
                case 7:
                    productManage.showMinQuantity();
                    break;
                case 8:
                    productManage.showTotalMoney();
                    break;
                default:
                    System.out.println("No choice.");
            }
        }
        while (choice != 0);
    }
}
