import model.*;
import service.Method_Brand;
import service.Method_Product;
import service.Store_Manage;
import java.text.SimpleDateFormat;
import java.util.*;


public class test {
    public static void main(String[] args) {
        String a = "laptop gaming g15";
        String b = "laptop gaming 45454aaaa";
        String c = "hoàng";
        String d = "latop doanh nhân xps";
        String e = "an";
        String f = "hoàng";
        String g = "iphone";

        ArrayList<String> strings = new ArrayList<>();
        strings.add(a);
        strings.add(b);
        strings.add(c);
        strings.add(d);
        strings.add(e);
        strings.add(f);
        strings.add(g);

        System.out.println(strings);
        System.out.println("------------------------");
        String h = "laptop";
        for (String s : strings){
            if (s.contains(h.toUpperCase())){
                System.out.println(s);
            }
        }
    }

    }



