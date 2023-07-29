import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CategoryManage {
    public static Category category1 = new Category("Mobile phone");
    public static Category category2 = new Category("Laptop");
    public static Category category3 = new Category("Tablet");
    public static List<Category> categoryList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void setCategoryList() {
        categoryList.add(category1);
        categoryList.add(category2);
        categoryList.add(category3);
        writeCategoryListToFile(categoryList);
    }

    public void writeCategoryListToFile(List<Category> categoryList) {
        try {
            File file = new File("D:\\module2\\BaiTapAnhQuan\\BaiTapAnhQuan\\src\\bai_4_category_product\\untitled\\src\\CategoryFile");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(categoryList);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readCategoryListFromFile() {
        try {
            File file = new File("D:\\module2\\BaiTapAnhQuan\\BaiTapAnhQuan\\src\\bai_4_category_product\\untitled\\src\\CategoryFile");
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            categoryList = (List<Category>) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void displayCategoryList() {
        System.out.println("Danh sách danh mục sản phẩm gồm có " + categoryList.size() + " danh mục, như sau:");
        for (int i = 0; i < categoryList.size(); i++) {
            System.out.println((i + 1) + ". " + categoryList.get(i));
        }
        System.out.println("........................");
    }

    public void checkIdCategory(int id) throws Exception {

        boolean check = false;
        for (Category category : categoryList) {
            if (category.getId() == id) {
                check = true;
                break;
            }
        }
        if (id == 0) {
            check = true;
        }
        if (!check) {
            throw new Exception("Id không có trong danh sách.");
        }
    }

    public void addCategory() {
        Category category = new Category();
        System.out.println("Nhập tên của danh mục mới: ");
        String name = scanner.nextLine();
        category.setName(name);
        int maxID = 0;
        for (Category category4 : categoryList) {
            maxID = categoryList.get(0).getId();
            if (category4.getId() > maxID) {
                maxID = category4.getId();
            }
        }
        maxID++;
        Category.idCate = maxID;
        category.setId(maxID);
        categoryList.add(category);
        writeCategoryListToFile(categoryList);
        System.out.println("Bạn đã thêm danh mục mới thành công.");
    }

    public void deleteCategory() {
        int id = 0;
        while (true) {
            if (CategoryManage.categoryList.isEmpty()) {
                System.out.println("Danh sách danh mục trống, còn gì mà xoá.");
                break;
            }
            try {
                System.out.println("Nhập vào id của danh mục bạn muốn xoá:");
                id = Integer.parseInt(scanner.nextLine());
                CategoryManage categoryManage = new CategoryManage();
                if (id == 0) {
                    System.out.println("Danh mục có id = 0 là mặc định, không được phép xoá.");
                    continue;
                }
                categoryManage.checkIdCategory(id);
                for (Category category : categoryList) {
                    if (category.getId() == id) {
                        categoryList.remove(category);
                        writeCategoryListToFile(categoryList);
                        for (Product product : ProductManage.productList) {
                            if (product.getCategory().getId() == id) {
                                product.setCategory(new Category("Chưa cài đặt danh mục", 0));
                                ProductManage productManage = new ProductManage();
                                productManage.writeProductListToFile(ProductManage.productList);
                            }
                        }
                        break;
                    }
                }
                System.out.println("Đã xoá thành công danh mục.");
                break;
            } catch (NumberFormatException e) {
                System.out.println("Kiểu dữ liệu nhập vào không đúng.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void editCategory() {
        int id = 0;
        while (true) {
            if (CategoryManage.categoryList.isEmpty()) {
                System.out.println("Không có danh mục nào để sửa.");
                break;
            }
            try {
                System.out.println("Nhập id của danh mục sản phẩm bạn muốn sửa: ");
                id = Integer.parseInt(scanner.nextLine());
                if (id == 0) {
                    System.out.println("Danh mục có id = 0 là mặc định, không được phép thay đổi.");
                    continue;
                }
                checkIdCategory(id);
                for (Category category : categoryList) {
                    if (category.getId() == id) {
                        System.out.println("Nhập tên mới của danh mục:");
                        String name = scanner.nextLine();
                        category.setName(name);
                        writeCategoryListToFile(categoryList);
                        for (Product product : ProductManage.productList) {
                            if (product.getCategory().getId() == id) {
                                product.setCategory(category);
                                ProductManage productManage = new ProductManage();
                                productManage.writeProductListToFile(ProductManage.productList);
                            }
                        }
                        break;
                    }
                }

                System.out.println("Bạn đã sửa danh mục thành công.");
                break;
            } catch (NumberFormatException e) {
                System.out.println("Kiểu dữ liệu nhập vào không đúng.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
