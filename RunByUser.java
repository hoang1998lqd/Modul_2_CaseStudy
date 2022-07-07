import model.Account;
import model.User;
import service.Store_Manage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RunByUser {
    Store_Manage manage = new Store_Manage();
    Scanner scanner = new Scanner(System.in);
    Login login = new Login();

    public RunByUser() {
    }

    // Lỗi phần tính toán list order

    public void menuUser(String account) {
        try {
            int choice;
            do {
                User user = manage.getUserByAccount(account);
                System.out.println("Chào mừng bạn " + user.getFullName() + " đã tới cửa hàng <3");
                System.out.println("1. Hiển thị sản phẩm.");
                System.out.println("2. Đặt hàng.");
                System.out.println("3. Giỏ hàng.");
                System.out.println("4. Điền thông tin đơn hàng.");
                System.out.println("5. Thanh toán đơn hàng.");
                System.out.println("6. Thông tin đơn hàng.");
                System.out.println("7. Xác nhận đơn hàng.");
                System.out.println("8. Thông tin người dùng (Bill)");
                System.out.println("0. Đăng xuất...");
                System.out.println("Mời bạn nhập lựa chọn !!!");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        choiceProduct(account);
                        break;
                    case 2:
                        manage.addOrder(account);
                        break;
                    case 3:
                        cart(account);
                        break;
                    case 4:
                        choiceOrder(account);
                        break;
                    case 5:
                        bill(account);
                        break;
                    case 6:
                        infoBill(account);
                        break;
                    case 7:
                        manage.confirmOrder(account);
                        break;
                    case 8:
                        user(account);
                        break;
                    case 0:
                        login.login();
                        break;
                }
            } while (true);
        } catch (InputMismatchException e) {
            System.out.println("------------------------------------------");
            System.out.println("Bạn đã nhập sai dữ liệu. Vui lòng nhập lại...");
            menuUser(account);
        }
    }


    public void user(String account){
        int choice;
        do {
            System.out.println("---------- User ----------");
            System.out.println("1. Thông tin người dùng");
            System.out.println("2. Thay đổi thông tin người dùng");
            System.out.println("3. Thay đổi mật khẩu đăng nhập");
            System.out.println("0. Trở lại Menu");
            System.out.println("Mời bạn nhập lựa chọn !!!");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    manage.displayUserByAccount(account);
                    break;
                case 2:
                    manage.editUser();
                    break;
                case 3:
                    manage.editPassword(account);
                    break;
                case 0:
                    menuUser(account);
                    break;
            }
        } while (true);
    }
    public void choiceOrder(String account) {
        int choice;
        do {
            System.out.println("---------- Bills Product ----------");
            System.out.println("1. Đặt hàng");
            System.out.println("2. Đặt hộ");
            System.out.println("0. Trở lại Menu");
            System.out.println("Mời bạn nhập lựa chọn !!!");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    manage.addBill(account);
                    break;
                case 2:
                    manage.addBillBook(account);
                    break;
                case 0:
                    menuUser(account);
                    break;
            }
        } while (true);
    }

    private void choiceProduct(String account) {
        int choice;
        do {
            System.out.println("----------Product----------");
            System.out.println("1. Hiển thị tất cả sản phẩm");
            System.out.println("2. Hiển thị theo giá sản phẩm");
            System.out.println("3. Hiển thị theo thương hiệu");
            System.out.println("0. Trở lại Menu");
            System.out.println("Mời bạn nhập lựa chọn !!!");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    manage.displayAllProduct();
                    break;
                case 2:
                    manage.displayByPrice(scanner);
                    break;
                case 3:
                    manage.displayByBrad(scanner);
                    break;
                case 0:
                    menuUser(account);
                    break;
            }
        } while (true);

    }


    private void cart(String account) {
        int choice;
        do {
            System.out.println("---------- Cart ----------");
            System.out.println("1. Hiển thị giỏ hàng");
            System.out.println("2. Thanh toán");
            System.out.println("3. Xóa đơn hàng");
            System.out.println("4. Sửa đơn hàng");
            System.out.println("0. Trở lại Menu");
            System.out.println("Mời bạn nhập lựa chọn !!!");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    manage.displayOrderByAccount(account);
                    break;
                case 2:
                    bill(account);
                    break;
                case 3:
                    manage.deleteOrderById();
                    break;
                case 4:
                    manage.editOrder();
                    break;
                case 0:
                    menuUser(account);
                    break;
            }
        } while (true);

    }

    private void bill(String account) {
        int choice;
        do {
            System.out.println("---------- Bills ----------");
            System.out.println("1. Thanh toán theo hình thức COD");
            System.out.println("2. Thanh toán Online");
            System.out.println("3. Thanh toán Online theo hóa đơn");
            System.out.println("4. Hủy đơn hàng");
            System.out.println("0. Trở lại Menu");
            System.out.println("Mời bạn nhập lựa chọn !!!");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    manage.payCOD(account);
                    break;
                case 2:
                    manage.paymentBill(account);
                    break;
                case 3:
                    manage.paymentBillByID(account);
                    break;
                case 4:
                    manage.deleteBillById(account);
                    break;
                case 0:
                    menuUser(account);
                    break;
            }
        } while (true);
    }

    private void infoBill(String account) {
        int choice;
        do {
            System.out.println("---------- Bills ----------");
            System.out.println("1. Lịch sử giao dịch");
            System.out.println("2. Đơn hàng hiện tại");
            System.out.println("0. Trở lại Menu");
            System.out.println("Mời bạn nhập lựa chọn !!!");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    manage.displayBillByAccountPay(account);
                    break;
                case 2:
                    manage.displayBillByAccountNotPay(account);
                    break;
                case 0:
                    menuUser(account);
                    break;
            }
        } while (true);
    }
}