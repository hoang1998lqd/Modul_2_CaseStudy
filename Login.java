import service.Store_Manage;

import java.util.Scanner;

public class Login {
    Store_Manage manage = new Store_Manage();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Login login = new Login();
        login.login();
    }
        public void login(){
            String account;
            String password;
            int count = 0;
            do {
                System.out.println("Tài khoản: ");
                account = scanner.nextLine();
                System.out.println("Mật khẩu: ");
                password = scanner.nextLine();
                if ( !manage.checkAccount(manage.method_account.accountList, account, password) && !manage.checkAdmin(account,password)){
                    System.out.println("Tài khoản hoặc mật khẩu không chính xác !!!");
                    count ++;
                }
                if (manage.checkAccount(manage.method_account.accountList, account, password)) {
                    System.out.println("Đây là dòng lệnh được thực thi dưới quyền người dùng");
                    count = 1;
                    break;
                } else if (manage.checkAdmin(account,password)){
                    System.out.println("Đây là dòng lệnh được thực thi dưới quyền Admin !!!");
                    count = 1;
                    break;
                }
            }while (count != 3 && !manage.checkAccount(manage.method_account.accountList, account, password) || (account.equals("admin") || password.equals("admin")));
            if (count == 3){
                System.out.println("Bạn đã nhập sai 3 lần vui lòng thử lại sau !!!");
        }

        }
}


