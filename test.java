import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        String regex = "^0[3-9]{1}[1-9]{1}\\d{7}$";
        Scanner scanner = new Scanner(System.in);
          String a = scanner.nextLine();
          Pattern pattern = Pattern.compile(regex);
          Matcher matcher = pattern.matcher(a);
          if (matcher.find()){
              System.out.println("Ok");
          }else {
              System.out.println("Sai rồi !!!");
          }
      }
}
