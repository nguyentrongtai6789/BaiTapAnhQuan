package bai_4_category_product;

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
            File file = new File("D:\\module2\\BaiTapAnhQuan\\BaiTapAnhQuanTuan2\\src\\bai_4_category_product\\Category");
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
            File file = new File("D:\\module2\\BaiTapAnhQuan\\BaiTapAnhQuanTuan2\\src\\bai_4_category_product\\Category");
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
    }

    public void checkIdCategory(int id) throws Exception {

        boolean check = false;
        for (Category category : categoryList) {
            if (category.getId() == id) {
                check = true;
                break;
            }
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
        categoryList.add(category);
        writeCategoryListToFile(categoryList);
        System.out.println("Bạn đã thêm danh mục mới thành công.");
    }

    public void editCategory() {
        while (true) {
            int id;
            try {
                System.out.println("Nhập id của danh mục sản phẩm bạn muốn sửa: ");
                id = Integer.parseInt(scanner.nextLine());
                checkIdCategory(id);
                for (Category category : categoryList) {
                    if (category.getId() == id) {
                        System.out.println("Nhập tên mới của danh mục:");
                        String name = scanner.nextLine();
                        category.setName(name);
                        writeCategoryListToFile(categoryList);
                        System.out.println("Bạn đã sửa danh mục thành công.");
                        break;
                    }
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Kiểu dữ liệu nhập vào không đúng.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
