package bai_2;

import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int soLuong;
        do {
            System.out.println("Nhap vao so luong san pham trong cua hang:");
            soLuong = scanner.nextInt();
            if (soLuong <= 0) {
                System.out.println("So luong khong phu hop!");
            }
        } while (soLuong <= 0);
        Product[] products = new Product[soLuong];
        for (int i = 0; i < products.length; i++) {
            products[i] = new Product(0, "", 1.0, 0, "");
        }
        for (int i = 0; i < products.length; i++) {
            String name;
            scanner.nextLine();
            System.out.println("Nhap vao ten san pham thu " + (i + 1) + ":");
            name = scanner.nextLine();
            products[i].setName(name);
            int id;
            System.out.println("Nhap vao id cua san pham thu " + (i + 1) + ":");
            id = scanner.nextInt();
            products[i].setId(id);
            double price;
            System.out.println("Nhap vao price cua san pham thu " + (i + 1) + ":");
            price = scanner.nextDouble();
            products[i].setPrice(price);
            int quantity;
            System.out.println("Nhap vao quantity cua san pham thu " + (i + 1) + ":");
            quantity = scanner.nextInt();
            products[i].setQuantity(quantity);
            String description;
            scanner.nextLine();
            System.out.println("Nhap vao description cua san pham thu " + (i + 1) + ":");
            description = scanner.nextLine();
            products[i].setDescription(description);
        }
        do {
            System.out.println();
            System.out.println("Danh sach san pham trong cua hang gom co:");
            for (Product product : products) {
                System.out.println(product.toString());
            }
            System.out.println();
            System.out.println("Menu:");
            System.out.println("1. Them mot san pham.");
            System.out.println("2. Sua thong tin mot doi tuong dua theo id nhap vao.");
            System.out.println("3. Xoa mot san pham dua theo id nhap vao.");
            System.out.println("4. Hien thi cac product co gia lon nhat.");
            System.out.println("5. Hien thi cac product co gia nho nhat.");
            System.out.println("6. Hien thi cac product co so luong nho nhat.");
            System.out.println("7. Hien thi cac product co so luong lon nhat.");
            System.out.println("8. Tinh tong tien hang hien co.");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Nhap id cua san pham: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nhap ten cua san pham: ");
                    String name = scanner.nextLine();
                    System.out.println("Nhap so luong cua san pham: ");
                    int quantity = scanner.nextInt();
                    System.out.println("Nhap price cua san pham: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Nhap mo ta cua san pham: ");
                    String description = scanner.nextLine();
                    Product newProduct = new Product(id, name, price, quantity, description);
                    Product[] newArray = new Product[products.length + 1];
                    System.arraycopy(products, 0, newArray, 0, products.length);
                    newArray[newArray.length - 1] = newProduct;
                    System.out.println("Danh sach san pham trong cua hang gom co: ");
                    for (Product product : newArray) {
                        System.out.println(product);
                    }
                }
                case 2 -> {
                    System.out.println("Nhap vao id cua doi tuong can sua: ");
                    int idEdit = scanner.nextInt();
                    boolean flag = false;
                    for (Product product : products) {
                        if (idEdit == product.getId()) {
                            flag = true;
                            System.out.println("ID co trong danh sach.");
                            scanner.nextLine();
                            System.out.println("Nhap vao ten moi:");
                            String newName = scanner.nextLine();
                            product.setName(newName);
                            System.out.println("Nhap vao price moi:");
                            double newPrice = scanner.nextDouble();
                            product.setPrice(newPrice);
                            System.out.println("Nhap vao quantity moi:");
                            int newQuantity = scanner.nextInt();
                            product.setQuantity(newQuantity);
                            scanner.nextLine();
                            System.out.println("Nhap vao describle moi:");
                            String newDescrible = scanner.nextLine();
                            product.setDescription(newDescrible);
                        }
                    }
                    if (flag) {
                        System.out.println("Danh sach san pham moi la: ");
                        for (Product product : products) {
                            System.out.println(product);
                        }
                    } else System.out.println("ID khong co trong danh sach.");
                }
                case 3 -> {
                    System.out.println("Nhap vao id cua doi tuong can xoa:");
                    int idEdit = scanner.nextInt();
                    boolean flag = false;
                    Product[] newProducts = new Product[products.length - 1];
                    for (int i = 0; i < products.length; i++) {
                        if (idEdit == products[i].getId()) {
                            flag = true;
                            for (int j = 0; j < i; j++) {
                                newProducts[j] = products[j];
                            }
                            for (int j = i; j < newProducts.length; j++) {
                                newProducts[j] = products[j + 1];
                            }
                        }
                        if (flag) {
                            System.out.println("Danh sach san pham moi la: ");
                            for (Product newProduct : newProducts) {
                                System.out.println(newProduct);
                            }
                        } else System.out.println("ID khong co trong danh sach.");
                    }
                }
                case 4 -> {
                    double maxPrice = products[0].getPrice();
                    for (Product value : products) {
                        if (value.getPrice() > maxPrice) {
                            maxPrice = value.getPrice();
                        }
                    }
                    System.out.println("Gia lon nhat la: " + maxPrice);
                    System.out.println("Product co gia lon nhat la: ");
                    for (Product product : products) {
                        if (product.getPrice() == maxPrice) {
                            System.out.println(product);
                        }
                    }
                }
                case 5 -> {
                    double minPrice = products[0].getPrice();
                    for (Product value : products) {
                        if (value.getPrice() < minPrice) {
                            minPrice = value.getPrice();
                        }
                    }
                    System.out.println("Gia nho nhat la: " + minPrice);
                    System.out.println("Product co gia nho nhat la: ");
                    for (Product product : products) {
                        if (product.getPrice() == minPrice) {
                            System.out.println(product);
                        }
                    }
                }
                case 6 -> {
                    int minQuantity = products[0].getQuantity();
                    for (Product value : products) {
                        if (value.getQuantity() < minQuantity) {
                            minQuantity = value.getQuantity();
                        }
                    }
                    System.out.println("So luong nho nhat la: " + minQuantity);
                    System.out.println("Product co so luong nho nhat la:");
                    for (Product product : products) {
                        if (product.getQuantity() == minQuantity) {
                            System.out.println(product);
                        }
                    }
                }
                case 7 -> {
                    int maxQuantity = products[0].getQuantity();
                    for (Product value : products) {
                        if (value.getQuantity() > maxQuantity) {
                            maxQuantity = value.getQuantity();
                        }
                    }
                    System.out.println("So luong lon nhat la: " + maxQuantity);
                    System.out.println("Product co so luong lon nhat la:");
                    for (Product product : products) {
                        if (product.getQuantity() == maxQuantity) {
                            System.out.println(product);
                        }
                    }
                }
                case 8 -> {
                    double tongTien = 0;
                    for (int i = 0; i < products.length; i++) {
                        tongTien = tongTien + products[i].getTongTien();
                    }
                    System.out.println("Tong tien hang hien co la: " + tongTien);
                }
                case 0 -> {
                    System.exit(0);
                }
                default -> System.out.println("No choice!");
            }
        }
        while (-1 != 0);
    }
}

