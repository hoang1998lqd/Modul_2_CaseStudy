package service;

import model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Store_Manage {
    protected final Method_Account  method_account = new Method_Account();
        protected final Method_Brand method_brand = new Method_Brand();
    protected final Method_Product method_product = new Method_Product();
    protected final Method_User method_user = new Method_User();
    protected final Method_Oder method_oder = new Method_Oder();
    protected final HashMap<String,User> userHashMap = new HashMap<>();
    protected final Scanner scanner = new Scanner(System.in);


    //----------------------Account-----------------------------



    //Check Account theo yêu cầu.
    public static boolean checkAccountByChar(String account){
        String regex = "^[a-zA-Z]+[a-zA-Z\\d]\\w{6,30}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(account);
        if (matcher.find()){
            return true;
        }
        return false;
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
    }

    //-----------------------Users---------------------------

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
        System.out.println("Nhập số điện thoại liên hệ: ");
        long phone = Long.parseLong(scanner.nextLine());
        System.out.println("Nhập địa chỉ liên hệ: ");
        String address = scanner.nextLine();
        if (method_user.UserList.size() > 0){
            User.ID_User = method_user.UserList.get(method_user.getSize()).getId();
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
        System.out.println("Nhập số điện thoại mới: ");
        long phone = Long.parseLong(scanner.nextLine());
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



    // Chưa giải quyết được vấn đề lấy thông tin User từ lúc đăng nhập.........
    // Hiển thị thông tin account khi đăng nhập dưới quyền người dùng..........
    public order addOrder(){
        order order = creatOrder();
        System.out.println(order.toString());
        System.out.println("----------------------------------");
        System.out.println("Bạn đã đặt hàng thành công !!! ");
        method_oder.add(order);
        return order;
    }

    public order creatOrder(){
        System.out.println("---------------------------");
        System.out.println("Nhập số lượng cần mua: ");
        long count = Long.parseLong(scanner.nextLine());
        System.out.println("Nhập ID tài khoản: ");
        int id = Integer.parseInt(scanner.nextLine());
        User user = method_user.getById(id);
        System.out.println("Nhập ID sản phẩm bạn muốn mua: ");
        int idProduct = Integer.parseInt(scanner.nextLine());
        Product product = method_product.getById(idProduct);
        long totalPrice = product.getPrice() * count;
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
        manage.addAccount();
//        manage.addAccount();
        manage.displayAllUser();
    }

}


