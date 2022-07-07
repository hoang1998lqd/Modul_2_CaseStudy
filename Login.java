import service.Store_Manage;

import java.util.Scanner;

public class Login {
      private final   Store_Manage manage = new Store_Manage();
      private final   Scanner scanner = new Scanner(System.in);



    protected void storeVIP() {
        int choice;
        do {
            System.out.println("---------- Store ----------");
            System.out.println("1. Đăng ký");
            System.out.println("2. Đăng nhập");
            System.out.println("0. Thoát");
            System.out.println("Mời bạn nhập lựa chọn !!!");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
            }
        } while (choice != 0);
    }
    public void register(){
        manage.addAccount();
    }

    public void login(){
        Store_Manage manage = new Store_Manage();
        Scanner scanner = new Scanner(System.in);
        RunByAdmin admin = new RunByAdmin();
        RunByUser user = new RunByUser();
        String account;
        String password;
        int count = 0;
        do {
            System.out.println("Tài khoản: ");
            account = scanner.nextLine();
            System.out.println("Mật khẩu: ");
            password = scanner.nextLine();
            if ( !manage.checkAccount(manage.method_account.accountList, account, password) && !manage.checkAdmin(account,password)){
                System.out.println("----------------------------------------------");
                System.out.println("Tài khoản hoặc mật khẩu không chính xác !!!");
                count ++;
            }
            if (manage.checkAccount(manage.method_account.accountList, account, password)) {
                user.menuUser(account);
                count = 1;
                break;
            } else if (manage.checkAdmin(account,password)){
                admin.menuAdmin();
                count = 1;
                break;
            }
        }while (count != 3 && !manage.checkAccount(manage.method_account.accountList, account, password) || (account.equals("admin") || password.equals("admin")));
        if (count == 3){
            System.out.println("----------------------------------------------");
            System.out.println("Bạn đã nhập sai 3 lần vui lòng thử lại sau !!!");
        }

    }
}


