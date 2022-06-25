package Method;

import All_Classes.Brand;
import All_Classes.CRUD;
import All_Classes.Product;

import java.util.ArrayList;
import java.util.List;

public class Method_Product implements CRUD<Product> {
    protected List<Product> productList ;
    public Method_Product(){
        productList = new ArrayList<>();
    }
    @Override
    public Product getById(int id) {
        for (Product product : productList){
            if (id == product.getId()){
                return product;
            }
        }
        return null;
    }

    @Override
    public Product add(Product product) {
        productList.add(product);
        return product;
    }

    @Override
    public void update(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == product.getId()){
                productList.set(i,product);
            }
        }
    }

    @Override
    public Product deleteById(int id) {
        for (Product product : productList){
            if (id == product.getId()){
                productList.remove(product);
                return product;
            }
        }
        return null;
    }

    @Override
    public void displayById(int id) {
        for (Product product : productList){
            if (id == product.getId()){
                System.out.println(product);
            }
        }
    }

    @Override
    public void displayAll() {
        for (Product product : productList){
            System.out.println(product);
        }
    }
}
