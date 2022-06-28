package service;

import model.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Store_Manage {
    protected final Method_Account  method_account = new Method_Account();
        protected final Method_Brand method_brand = new Method_Brand();
    protected final Method_Product method_product = new Method_Product();
    protected final Method_User method_user = new Method_User();
    protected final Method_Order method_oder = new Method_Order();
    protected final HashMap<String,User> userHashMap = new HashMap<>();
    protected final Scanner scanner = new Scanner(System.in);


    //----------------------Account-----------------------------



    //Check Account theo yêu cầu.
    public static boolean checkAccountByChar(String account){
        String regex = "^[a-zA-Z\\d]+[a-zA-Z\\d]\\w{6,30}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(account);
        return matcher.find();
    }

    public Account addAccount(){
        Account account = creatAccount();
        System.out.println("Tạo mới tài khoản thành công !!!");
        userHashMap.put(account.getAccount(),addUser(account));
        return method_account.add(account);
    }

    public Account creatAccount(){
        System.out.println("-------------------------");
        String name;
        do {
            System.out.println("Nhập tên tài khoản: ");
            name = scanner.nextLine();
        }while (method_account.checkAccount(name) && !checkAccountByChar(name));
        String pass;
        do {
            System.out.println("Nhập mật khẩu: ");
            pass = scanner.nextLine();
        }while (!checkAccountByChar(pass));
        if (method_account.accountList.size() > 0){
            Account.ID_Account = method_account.accountList.get(method_user.getSize()-1).getId() + 1;

        }
        return new Account(name,pass);
    }

    public void editPassword(){
        System.out.println("-------------------------");
        System.out.println("Nhập ID cần thay đổi mật khẩu: ");
        int id = Integer.parseInt(scanner.nextLine());
        Account account = method_account.getById(id);
        String password;
        do {
            System.out.println("Nhập mật khẩu mới: ");
            password = scanner.nextLine();
        }while (!checkAccountByChar(password));
        account.setPassword(password);
        method_account.update(account);
    }

    public void deleteById(){
        System.out.println("-------------------------");
        System.out.println("Nhập ID tài khoản cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        Account account = method_account.deleteById(id);
        if (account != null){
            System.out.println("Xóa tài khoản thành công !!!");
        }else {
            System.out.println("Không tìm thấy ID theo yêu cầu !!!");
        }
    }

    public void displayByIdAccount(){
        System.out.println("-------------------------");
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
        System.out.println("Tạo mới thương hiệu thành công !!!");
        return method_brand.add(brand);
    }

    public Brand creatBrand(){
        System.out.println("-------------------------");
        System.out.println("Nhập tên thương hiệu laptop: ");
        String nameBrand = scanner.nextLine();
        if (method_brand.brandList.size() > 0){
            Brand.ID_BRAND = method_brand.brandList.get(method_brand.getSize() - 1).getId() + 1;
        }
        return new Brand(nameBrand);
    }

    public void editBrand(){
        System.out.println("-------------------------");
        System.out.println("Nhập ID cần thay đổi : ");
        int id = Integer.parseInt(scanner.nextLine());
        Brand brand = method_brand.getById(id);
        System.out.println("Nhập tên thương hiệu mới : ");
        String name = scanner.nextLine();
        brand.setNameBrand(name);
        method_brand.update(brand);
    }

    public void deleteByIdBrand(){
        System.out.println("-------------------------");
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
        System.out.println("-------------------------");
        System.out.println("Nhập ID bạn cần hiển thị: ");
        int id = Integer.parseInt(scanner.nextLine());
        method_brand.displayById(id);
    }

    public void showListBrand(){
        System.out.println("Lựa chọn thương hiệu cho sản phẩm: ");
        ArrayList<Brand> brands = method_brand.getBrandList();
        for (Brand brand : brands){
            System.out.println(brand.getId() + ". " + brand.getNameBrand());
        }
        System.out.println("0. Tạo thương hiệu mới...");
    }

    public void displayAllBrand(){
        method_brand.displayAll();
    }

    //------------------------Products---------------------------

    public Product addProduct(){
        Product product = creatProduct();
        System.out.println("Tạo mới sản phẩm thành công !!!");
        method_product.add(product);
        return product;
    }

    public Product creatProduct(){
        System.out.println("-------------------------");
        System.out.println("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.println("Nhập giá tiền của sản phẩm: ");
        long price = Long.parseLong(scanner.nextLine());
        System.out.println("Nhập số lượng sản phẩm có trong cửa hàng: ");
        int amount = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập màu sắc cho sản phẩm: ");
        String color = scanner.nextLine();
        Brand brand = null;
        showListBrand();
        do {
            System.out.println("-------------------------");
            System.out.println("Nhập thương hiệu cho sản phẩm: ");
            int choice =Integer.parseInt(scanner.nextLine());
            if  (choice == 0){
                System.out.println("Nhập tên thương hiệu mới: ");
                addBrand();
                showListBrand();
                continue;
            }
            if (method_brand.getById(choice) == null){
                System.out.println("Lựa chọn không đúng !!");
            }
            brand = method_brand.getById(choice);
        }while (brand == null);
        if (method_product.productList.size() > 0){
            Product.ID_Product = method_product.productList.get(method_product.productList.size() - 1).getId() + 1 ;
        }
        return new Product(name,price,amount,color,brand);
    }

    public void editProduct(){
        System.out.println("-------------------------");
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

    public void deleteByIdProduct(){
        System.out.println("-------------------------");
        System.out.println("Nhập ID bạn cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        Product product = method_product.deleteById(id);
        if (product != null){
            System.out.println("Xóa sản phẩm thành công !!!");
        }
        else {
            System.out.println("Xóa sản phẩm thất bại do không tìm được ID !!!");
        }
    }

    public void displayProductById(){
        System.out.println("-------------------------");
        System.out.println("Nhập ID sản phẩm bạn muốn hiển thị: ");
        int id = Integer.parseInt(scanner.nextLine());
        method_product.displayById(id);
    }

    public void displayAllProduct(){
        method_product.displayAll();
        displayZero();
    }
    // Thay đổi cách hiển thị sản phẩm
    public void displayZero(){
        for (Product product : method_product.productList){
            if (product.getAmount() == 0){
                System.out.println("Product{" +
                        "ID=" + product.getId() +
                        ", Tên sản phẩm: '" + product.getName_product() + '\'' +
                        ", Giá tiền: " + product.getPrice() +
                        ", Số lượng: " + "Tạm thời hết hàng" +
                        ", Màu sắc: '" + product.getColor() + '\'' +
                        ", Thương hiệu: " + product.getBrand().getNameBrand() +
                        '}');
            }
        }
    }




    // Sắp xếp giá tăng dần hoặc giảm dần

    public void displayUp(){
        System.out.println("Giá sản phẩm được sắp xếp tăng dần !!!");
        method_product.productList.sort(method_product.compareUp);
        displayAllProduct();
    }

    public void displayDown(){
        System.out.println("Giá sản phẩm được sắp xếp giảm dần !!!");
        method_product.productList.sort(method_product.compareDown);
        displayAllProduct();
    }

    // Hiển thị theo từng thương hiệu

    public void displayByBrad(Scanner scanner){
        showListBrand();
        Brand brand;
        do {
            System.out.println("-------------------------");
            System.out.println("Nhập thương hiệu cho sản phẩm: ");
            int choice =Integer.parseInt(scanner.nextLine());
            if (method_brand.getById(choice) == null){
                System.out.println("Lựa chọn không đúng !!");
            }
            brand = method_brand.getById(choice);
        }while (brand == null);
        for (Product product : method_product.productList){
            if (brand.getNameBrand().equals(product.getBrand().getNameBrand())){
                System.out.println(product);
            }
        }
    }

    public void displayProduct1(){
        for (Product product : method_product.productList){
            if (product.getPrice() > 15000000 && product.getPrice() < 20000000 ){
                System.out.println(product);
            }
            else {
                System.out.println("Hiện không có sản phẩm nào như yêu cầu của bạn !!! ");
            }
        }
    }

    public void displayProduct2(){
        for (Product product : method_product.productList){
            if (product.getPrice() > 10000000 && product.getPrice() < 15000000 ){
                System.out.println(product);
            } else {
                System.out.println("Hiện không có sản phẩm nào như yêu cầu của bạn !!! ");
            }
        }
    }

    public void displayProduct3(){
        for (Product product : method_product.productList){
            if (product.getPrice() > 20000000 ){
                System.out.println(product);
            } else {
                System.out.println("Hiện không có sản phẩm nào như yêu cầu của bạn !!! ");
            }
        }
    }



    // Hiển thị theo khoản giá:
    // 15000000 - 20000000;
    // 10000000 - 15000000;
    // > 20000000;

    public void displayByPrice(Scanner scanner ){
        int choice;
        do {
            System.out.println("Mời bạn lựa chọn hiển thị");
            System.out.println("1. Từ 10,000,000 - 15,000,000.");
            System.out.println("2. Từ 15,000,000 - 20,000,000.");
            System.out.println("3. Lớn hơn 20,000,000.");
            System.out.println("4. Đặt hàng.");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    displayProduct2();
                    break;
                case 2:
                    displayProduct1();
                    break;
                case 3:
                    displayProduct3();
                    break;
                case 4:
                    addOrder();
                    break;
            }
        }while (choice != 0);
    }




    //-----------------------Users---------------------------

    public static boolean checkPhoneByChar(String phone){
        String regex = "^0[3-9]{1}[1-9]{1}\\d{7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
        return matcher.find();
    }

    public User addUser(Account account){
        User user = creatUser(account);
        System.out.println("Tạo mới người dùng thành công !!!");
        method_user.add(user);
        return user;
    }

    public User creatUser(Account account ){
        System.out.println("-------------------------");
        System.out.println("Nhập tên người dùng: ");
        String name = scanner.nextLine();
        String phone;
       do {
           System.out.println("Nhập số điện thoại liên hệ: ");
            phone =scanner.nextLine();
       }while (!checkPhoneByChar(phone) && !method_user.checkPhoneInList(phone));
        System.out.println("Nhập địa chỉ liên hệ: ");
        String address = scanner.nextLine();
        if (method_user.UserList.size() > 0){
            User.ID_User = method_user.UserList.get(method_user.getSize()-1).getId() + 1 ;
        }
        return new User(name,phone,address,account);
    }

    public void editUser(){
        System.out.println("-------------------------");
        System.out.println("Nhập ID người dùng cần thay đổi: ");
        int id = Integer.parseInt(scanner.nextLine());
        User user = method_user.getById(id);
        System.out.println("Nhập tên mới: ");
        String name = scanner.nextLine();
        user.setFullName(name);
        String phone;
        do {
            System.out.println("Nhập số điện thoại liên hệ: ");
            phone =scanner.nextLine();
        }while (!checkPhoneByChar(phone) && method_user.checkPhoneInList(phone));
        user.setPhoneNumber(phone);
        System.out.println("Nhập địa chỉ mới: ");
        String address = scanner.nextLine();
        user.setAddress(address);
        method_user.update(user);
    }

    public void deleteUserById(){
        System.out.println("-------------------------");
        System.out.println("Nhập ID người dùng bạn cần xóa");
        int id = Integer.parseInt(scanner.nextLine());
        Brand brand = method_brand.deleteById(id);
        if (brand != null){
            System.out.println("Xóa người dùng thành công !!!");
        }else {
            System.out.println("Xóa người dùng thất bại do không tìm thấy ID theo yêu cầu !!!");
        }
    }

    public void displayUserById(){
        System.out.println("-------------------------");
        System.out.println("Nhập ID người dùng cần hiển thị");
        int id = Integer.parseInt(scanner.nextLine());
        method_user.displayById(id);
    }

    public void displayAllUser(){
        method_user.displayAll();
    }

    // -------------------------Orders-------------------------
    public order addOrder(){
        order order = creatOrder();
        System.out.println(order.toString());
        System.out.println("----------------------------------");
        System.out.println("Bạn đã đặt hàng thành công !!! ");
        method_oder.add(order);
        return order;
    }

    // Kiểm tra số lượng hàng còn trong kho > 0 và số lượng mua phải nhỏ hơn số lương hàng trong kho mới đặt mua được;
    public boolean checkAmount(Product product, long count){
        return count <= product.getAmount() && product.getAmount() != 0;
    }
    public order creatOrder(){
        System.out.println("---------------------------");
        System.out.println("Nhập ID sản phẩm bạn muốn mua: ");
        int idProduct = Integer.parseInt(scanner.nextLine());
        Product product = method_product.getById(idProduct);
        long count;
        do {
            System.out.println("Nhập số lượng cần mua: ");
            count = Long.parseLong(scanner.nextLine());
            int amount = (int) (product.getAmount() - count);
            product.setAmount(amount);
        }while (!checkAmount(product,count));
        System.out.println("Nhập ID tài khoản: ");
        int id = Integer.parseInt(scanner.nextLine());
        User user = method_user.getById(id);
        long totalPrice = product.getPrice() * count;
        if (method_oder.orderList.size() > 0){
            order.ID_Order = method_account.accountList.get(method_oder.orderList.size() - 1).getId() + 1 ;
        }
        return new order(count,user,product,totalPrice);
    }

    public void editOrder(){
        System.out.println("-------------------------");
        System.out.println("Nhập ID cần thay đổi: ");
        int id = Integer.parseInt(scanner.nextLine());
        order order = method_oder.getById(id);
        System.out.println("Nhập số lượng mua hàng: ");
        long count = Long.parseLong(scanner.nextLine());
        order.setCount(count);
        System.out.println("Nhập ID sản phẩm bạn muốn mua: ");
        int idProduct = Integer.parseInt(scanner.nextLine());
        Product product = method_product.getById(idProduct);
        long totalPrice = count * product.getPrice();
        order.setTotalPrice(totalPrice);
    }

    public void deleteOrderById(){
        System.out.println("-------------------------");
        System.out.println("Nhập ID người dùng bạn cần xóa");
        int id = Integer.parseInt(scanner.nextLine());
        order order = method_oder.deleteById(id);
        if (order != null){
            System.out.println("Xóa đơn hàng thành công !!!");
        }else {
            System.out.println("Xóa đơn hàng thất bại do không tìm thấy ID theo yêu cầu !!!");
        }
    }

    public void displayAllOrder(){
        method_oder.displayAll();
    }

    public void displayOrderById(){
        System.out.println("-------------------------------");
        System.out.println("Nhập ID bạn cần hiển thị: ");
        int id = Integer.parseInt(scanner.nextLine());
        method_oder.displayById(id);
    }

    public static void main(String[] args) {
        Store_Manage manage  = new Store_Manage();
    }

}


