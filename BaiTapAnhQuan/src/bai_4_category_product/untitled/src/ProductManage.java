import java.io.*;
import java.util.*;

public class ProductManage {
    Product product1 = new Product("Iphone 14 promax", 25_000_000, "Apple", "Hàng xách tay Hàn Quốc, mới 100%",
            CategoryManage.category1, 10);
    Product product2 = new Product("Pavilion", 15_000_000, "Hp", "Hàng công ty, mới 100%",
            CategoryManage.category2, 15);
    Product product3 = new Product("Ipad 2", 8_000_000, "Iphone", "Hàng công ty, mới 100%",
            CategoryManage.category3, 5);
    Product product4 = new Product("Ipad 3", 8_000_000, "Apple", "Hàng công ty, mới 100%",
            CategoryManage.category3, 7);
    Product product5 = new Product("Galaxy zFlip", 18_000_000, "Samsung", "Hàng công ty, mới 100%",
            CategoryManage.category1, 5);
    Product product6 = new Product("ZenBook", 16_000_000, "Asus", "Hàng công ty, mới 100%",
            CategoryManage.category2, 5);
    Product product7 = new Product("Red Mi 10", 8_000_000, "Xiao-mi", "Hàng công ty, mới 100%",
            CategoryManage.category1, 5);
    static List<Product> productList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void setProductList() {
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        productList.add(product6);
        productList.add(product7);
        writeProductListToFile(productList);
    }

    public void writeProductListToFile(List<Product> productList) {
        try {
            File file = new File("D:\\module2\\BaiTapAnhQuan\\BaiTapAnhQuan\\src\\bai_4_category_product\\untitled\\src\\ProductFile");
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
            File file = new File("D:\\module2\\BaiTapAnhQuan\\BaiTapAnhQuan\\src\\bai_4_category_product\\untitled\\src\\ProductFile");
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
        System.out.println("..........................");
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
                System.out.println("Dữ liệu nhập vào không đúng.");
            }
        }
        System.out.println("Nhập hãng sản xuất của sản phẩm mới:");
        String manufacturer = scanner.nextLine();
        product.setManufacturer(manufacturer);
        System.out.println("Nhập mô tả của sản phẩm mới: ");
        String description = scanner.nextLine();
        product.setDescription(description);
        while (true) {
            try {
                System.out.println("Nhập id danh mục của sản phẩm:");
                int id = Integer.parseInt(scanner.nextLine());
                CategoryManage categoryManage = new CategoryManage();
                categoryManage.checkIdCategory(id);
                if (id == 0) {
                    product.setCategory(new Category("Chưa cài đặt danh mục", 0));
                }
                for (Category category : CategoryManage.categoryList) {
                    if (category.getId() == id) {
                        product.setCategory(category);
                        break;
                    }
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu nhập vào không đúng.");
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
        int maxId = 0;
        for (Product product4 : productList) {
            maxId = productList.get(0).getId();
            if (product4.getId() > maxId) {
                maxId = product4.getId();
            }
        }
        maxId++;
        Product.idClass = maxId;
        product.setId(maxId);
        productList.add(product);
        writeProductListToFile(productList);
    }

    public void checkIdProduct(int id) throws Exception {
        boolean check = false;
        for (Product product : productList) {
            if (id == product.getId()) {
                check = true;
                break;
            }
        }
        if (!check) {
            throw new Exception("Id không có trong danh sách");
        }
    }

    public void editProductById() {
        int id = 0;
        while (true) {
            if (productList.isEmpty()) {
                System.out.println("Không có sản phẩm nào để sửa.");
                break;
            }
            try {
                System.out.println("Nhập vào id của sản phẩm bạn muốn sửa:");
                id = Integer.parseInt(scanner.nextLine());
                checkIdProduct(id);
                for (Product product : productList) {
                    if (product.getId() == id) {
                        System.out.println("Nhập vào tên mới của sản phẩm:");
                        String name = scanner.nextLine();
                        product.setName(name);
                        while (true) {
                            try {
                                System.out.println("Nhập vào giá mới của sản phẩm:");
                                double price = Double.parseDouble(scanner.nextLine());
                                product.setPrice(price);
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Dữ liệu nhập vào không đúng");
                            }
                        }
                        System.out.println("Nhập hãng sản xuất của sản phẩm:");
                        String manufacturer = scanner.nextLine();
                        product.setManufacturer(manufacturer);
                        System.out.println("Nhập mô tả cho sản phẩm:");
                        String description = scanner.nextLine();
                        product.setDescription(description);
                        while (true) {
                            try {
                                System.out.println("Nhập số lượng của sản phẩm:");
                                int quantity = Integer.parseInt(scanner.nextLine());
                                product.setQuantity(quantity);
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Dữ liệu nhập vào không đúng.");
                            }
                        }
                        while (true) {
                            try {
                                System.out.println("Nhập id danh mục của sản phẩm:");
                                int idCategory = Integer.parseInt(scanner.nextLine());
                                CategoryManage categoryManage = new CategoryManage();
                                categoryManage.checkIdCategory(idCategory);
                                for (Category category : CategoryManage.categoryList) {
                                    if (idCategory == category.getId()) {
                                        product.setCategory(category);
                                        break;
                                    } else product.setCategory(new Category("Chưa cài đặt danh mục", 0));
                                }
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Dữ liệu nhập vào không đúng");
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }

                        }
                        writeProductListToFile(productList);
                        break;
                    }
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu nhập vào không đúng.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void deleteProductById() {
        int id = 0;
        while (true) {
            if (productList.isEmpty()) {
                System.out.println("Làm gì còn cái gì mà xoá.");
                break;
            }
            try {
                System.out.println("Nhập vào id của sản phẩm muốn xoá:");
                id = Integer.parseInt(scanner.nextLine());
                checkIdProduct(id);
                for (Product product : productList) {
                    if (product.getId() == id) {
                        productList.remove(product);
                        writeProductListToFile(productList);
                        break;
                    }
                }
                System.out.println("Xoá thành công.");
                break;
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu nhập vào không đúng.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void displayProductByPriceDown() {
        Collections.sort(productList);
        System.out.println("Danh sách sản phẩm có giá từ cao xuống thấp như sau:");
        for (Product product : productList) {
            System.out.println(product);
        }
        System.out.println("..........................");
    }

    public void displayProductByPriceUp() {
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });
        System.out.println("Danh sách sản phẩm có giá từ thấp lên cao như sau:");
        for (Product product : productList) {
            System.out.println(product);
        }
        System.out.println("..........................");
    }

    public void displayProductByPriceDownInCategory() {
        CategoryManage categoryManage = new CategoryManage();
        int id = 0;
        while (true) {
            if (CategoryManage.categoryList.isEmpty()) {
                System.out.println("Không có danh mục nào để hiển thị.");
                break;
            }
            try {
                System.out.println("Nhập id của danh mục hiển thị sản phẩm:");
                id = Integer.parseInt(scanner.nextLine());
                if (id == 0) {
                    System.out.println("Danh mục có id = 0 không được hỗ trợ.");
                    continue;
                }
                categoryManage.checkIdCategory(id);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu nhập vào không đúng");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        Collections.sort(productList);
        for (Category category : CategoryManage.categoryList) {
            if (id == category.getId()) {
                System.out.println("Danh mục " + category.getName() + " có sắp xếp theo giá từ cao xuống thấp như sau:");
                for (Product product : productList) {
                    if (product.getCategory().getId() == id) {
                        System.out.println(product);
                    }
                }
                break;
            }
        }
        System.out.println(".......................");
    }

    public void displayProductByPriceUpInCategory() {
        CategoryManage categoryManage = new CategoryManage();
        int id = 0;
        while (true) {
            if (CategoryManage.categoryList.isEmpty()) {
                System.out.println("Không có danh mục nào để hiển thị.");
                break;
            }
            try {
                System.out.println("Nhập id của danh mục hiển thị sản phẩm:");
                id = Integer.parseInt(scanner.nextLine());
                if (id == 0) {
                    System.out.println("Danh mục có id = 0 không được hỗ trợ.");
                    continue;
                }
                categoryManage.checkIdCategory(id);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu nhập vào không đúng");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });
        for (Category category : CategoryManage.categoryList) {
            if (id == category.getId()) {
                System.out.println("Danh mục " + category.getName() + " có sắp xếp theo giá từ thấp lên cao như sau:");
                for (Product product : productList) {
                    if (product.getCategory().getId() == id) {
                        System.out.println(product);
                    }
                }
                break;
            }
        }
        System.out.println(".......................");
    }

    public void searchProductByName() {
        int id = 0;
        while (true) {
            if (productList.isEmpty()) {
                System.out.println("Không có sản phẩm nào để tìm kiếṃ.");
                break;
            }
            System.out.println("Nhập tên của sản phẩm muốn tìm:");
            String name = scanner.nextLine();
            boolean flag = false;
            for (Product product : productList) {
                if ((product.getName().toLowerCase()).equals(name.toLowerCase())) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.println("Các sản phẩm có tên " + name + " như sau:");
                for (Product product : productList) {
                    if ((product.getName().toLowerCase()).equals(name.toLowerCase())) {
                        System.out.println(product);
                    }
                }
                System.out.println(".....................");
                break;
            } else {
                System.out.println("Không có sản phẩm nào có tên " + name);
                System.out.println(".....................");
                break;
            }
        }
    }

    public void displayAllProductByCategory() {
        while (true) {
            if (productList.isEmpty()) {
                System.out.println("Danh sách sản phẩm trống.");
                System.out.println("............................");
                break;
            }
            if (CategoryManage.categoryList.isEmpty()) {
                System.out.println("Danh mục sản phẩm trống. Không thể hiển thị.");
                System.out.println(".....................");
                break;
            }
            for (Category category : CategoryManage.categoryList) {
                System.out.println("Danh mục " + category.getName() + " có các sản phẩm sau:");
                for (Product product : ProductManage.productList) {
                    if (product.getCategory().getId() == category.getId()) {
                        System.out.println(product);
                    }
                }
            }
            System.out.println("..................");
            break;
        }
    }
}
