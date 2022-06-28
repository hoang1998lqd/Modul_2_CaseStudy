import model.Brand;
import model.Product;
import service.Method_Brand;
import service.Method_Product;
import service.Store_Manage;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    Method_Brand method_brand = new Method_Brand();
    Method_Product method_product = new Method_Product();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Store_Manage store_manage = new Store_Manage();
        store_manage.addBrand();
        store_manage.displayAllBrand();
//        store_manage.addBrand();
//        store_manage.addBrand();
        store_manage.addProduct();
//        store_manage.addProduct();
//        store_manage.addProduct();
//        store_manage.addProduct();
        store_manage.displayAllProduct();
        test test = new test();


      }






    }
