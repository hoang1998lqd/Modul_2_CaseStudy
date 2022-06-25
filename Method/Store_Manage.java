package Method;

import All_Classes.Brand;
import All_Classes.Product;
import All_Classes.account;

import java.util.Scanner;

public class Store_Manage {
    protected final Method_Account  method_account = new Method_Account();
    protected final Method_Brand method_brand = new Method_Brand();
    protected final Method_Product method_product = new Method_Product();
    protected final Method_User method_user = new Method_User();
    protected final Method_Oder method_oder = new Method_Oder();
    protected final Scanner scanner = new Scanner(System.in);


    //----------------------Account-----------------------------
    public account addAccount(){
        account account = creatAccount();
        return method_account.add(account);
    }

    public account creatAccount(){
        System.out.println("Nhập tên tài khoản: ");
        String name = scanner.nextLine();
        System.out.println("Nhập mật khẩu: ");
        String pass = scanner.nextLine();
        return new account(name,pass);
    }

    public void editPassword(){
        System.out.println("Nhập ID cần thay đổi mật khẩu: ");
        int id = Integer.parseInt(scanner.nextLine());
        account account = method_account.getById(id);
        System.out.println("Nhập mật khẩu mới cần thay đổi: ");
        String password = scanner.nextLine();
        account.setPassword(password);
        method_account.update(account);
    }

    public void deleteById(){
        System.out.println("Nhập ID tài khoản cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        account account = method_account.deleteById(id);
        if (account != null){
            System.out.println("Xóa tài khoản thành công !!!");
        }else {
            System.out.println("Không tìm thấy ID theo yêu cầu !!!");
        }
    }

    public void displayByIdAccount(){
        System.out.println("Nhập ID bạn cần hiển thị: ");
        int id = Integer.parseInt(scanner.nextLine());
        method_account.displayById(id);
    }

    public void displayAllAccount(){
        method_account.displayAll();
    }

    //----------------------Brand----------------------------

    public Brand addBrand(){
        Brand brand = creatBrand();
        return method_brand.add(brand);
    }

    public Brand creatBrand(){
        System.out.println("Nhập tên thương hiệu laptop: ");
        String nameBrand = scanner.nextLine();
        return new Brand(nameBrand);
    }

    public void editBrand(){
        System.out.println("Nhập ID cần thay đổi : ");
        int id = Integer.parseInt(scanner.nextLine());
        Brand brand = method_brand.getById(id);
        System.out.println("Nhập tên thương hiệu mới : ");
        String name = scanner.nextLine();
        brand.setNameBrand(name);
        method_brand.update(brand);
    }

    public void deleteByIdBrand(){
        System.out.println("Nhập ID thương hiệu cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        Brand brand = method_brand.deleteById(id);
        if (brand != null){
            System.out.println("Xóa thương hiệu thành công !!!");
        }else {
            System.out.println("Không tìm thấy ID theo yêu cầu !!!");
        }
    }

    public void displayByIdBrand(){
        System.out.println("Nhập ID bạn cần hiển thị: ");
        int id = Integer.parseInt(scanner.nextLine());
        method_brand.displayById(id);
    }

    public void displayAllBrand(){
        method_brand.displayAll();
    }

    //------------------------Products---------------------------

    public Product addProduct(){
        Product product = creatProduct();
        method_product.add(product);
        return product;
    }

    public Product creatProduct(){
        System.out.println("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.println("Nhập giá tiền của sản phẩm: ");
        long price = Long.parseLong(scanner.nextLine());
        System.out.println("Nhập số lượng sản phẩm có trong cửa hàng: ");
        int amount = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập màu sắc cho sản phẩm: ");
        String color = scanner.nextLine();
        Brand brand = null;
        do {
            System.out.println("Nhập thương hiệu cho sản phẩm: ");
            int choice =Integer.parseInt(scanner.nextLine());
            if  (choice == 0){
                System.out.println("Nhập tên thương hiệu mới: ");
                addBrand();
                displayAllBrand();
                continue;
            }
            if (method_brand.getById(choice) == null){
                System.out.println("Lựa chọn không đúng !!");
            }
            brand = method_brand.getById(choice);
        }while (brand == null);
        return new Product(name,price,amount,color,brand);
    }

    public void editProduct(){
        System.out.println("Nhập ID bạn cần sửa thông tin sản phẩm: ");
        int id = Integer.parseInt(scanner.nextLine());
        Product product = method_product.getById(id);
        System.out.println("Nhập tên mới cho sản phẩm: ");
        String name = scanner.nextLine();
        product.setName_product(name);
        System.out.println("Nhập giá mới cho sản phẩm: ");
        long price = Long.parseLong(scanner.nextLine());
        product.setPrice(price);
        System.out.println("Nhập số lượng sản phẩm: ");
        int amount = Integer.parseInt(scanner.nextLine());
        product.setAmount(amount);
        displayAllBrand();
        int choice = Integer.parseInt(scanner.nextLine());
        Brand brand = method_brand.getById(choice);
        product.setBrand(brand);
        method_product.update(product);
    }


}
