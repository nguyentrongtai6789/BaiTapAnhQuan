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
            System.out.println("2. Sửa danh mục sản phẩm theo id.");
            System.out.println("3. Xoá danh mục sản phẩm theo id.");
            System.out.println("4. Thêm sản phẩm.");
            System.out.println("5. Sửa sản phẩm theo id.");
            System.out.println("6. Xoá sản phẩm theo id.");
            System.out.println("7. Hiển thị tất cả sản phẩm có giá từ cao xuống thấp.");
            System.out.println("8. Hiển thị tất cả sản phẩm có giá từ thấp lên cao.");
            System.out.println("9. Hiển thị sản phẩm có giá từ cao xuống thấp theo danh mục. ");
            System.out.println("10. Hiển thị sản phẩm có giá từ thấp lên cao theo danh mục.");
            System.out.println("11. Tìm kiếm sản phẩm theo tên.");
            System.out.println("12. Hiển thị toàn bộ danh sách sản phẩm theo danh mục.");
            System.out.println("13. Tìm kiếm sản phẩm theo giá.");
            System.out.println("0. Thoát");
            System.out.println("Nhập lựa chọn của bạn:");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice != 1 && choice != 0 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6
                && choice != 7 && choice != 8 && choice != 9 && choice != 10 && choice != 11 && choice != 12 && choice != 13)
                    throw new Exception("Lựa chọn không được hỗ trợ");
                switch (choice) {
                    case 1:
                        categoryManage.addCategory();
                        break;
                    case 2:
                        categoryManage.editCategory();
                        break;
                    case 3:
                        categoryManage.deleteCategory();
                        break;
                    case 4:
                        productManage.addProduct();
                        break;
                    case 5:
                        productManage.editProductById();
                        break;
                    case 6:
                        productManage.deleteProductById();
                        break;
                    case 7:
                        productManage.displayProductByPriceDown();
                        break;
                    case 8:
                        productManage.displayProductByPriceUp();
                        break;
                    case 9:
                        productManage.displayProductByPriceDownInCategory();
                        break;
                    case 10:
                        productManage.displayProductByPriceUpInCategory();
                        break;
                    case 11:
                        productManage.searchProductByName();
                        break;
                    case 12:
                        productManage.displayAllProductByCategory();
                        break;
                    case 13:
                        productManage.searchProductByPrice();
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
