package bai_4_category_product;

import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        ProductManage productManage = new ProductManage();
        CategoryManage categoryManage = new CategoryManage();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            productManage.readProductListFromFile();
            productManage.displayProductList();
            categoryManage.readCategoryListFromFile();
            categoryManage.displayCategoryList();
            int choice;
            System.out.println("Menu:");
            System.out.println("1. Thêm danh mục sản phẩm.");
            System.out.println("2. Sửa danh mục sản phẩm.");
            System.out.println("3. Thêm sản phẩm.");
            System.out.println("0. Thoát");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice != 1 && choice != 0 && choice != 2 && choice != 3) throw new Exception("Lựa chọn không được hỗ trợ");
                switch (choice) {
                    case 1:
                        categoryManage.addCategory();
                        break;
                    case 2:
                        categoryManage.editCategory();
                        break;
                    case 3:
                        productManage.addProduct();
                        break;
                    case 0:
                        System.exit(0);
                }
            } catch (NumberFormatException e) {
                System.out.println("Kiểu dữ liệu nhập vào không đúng.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
