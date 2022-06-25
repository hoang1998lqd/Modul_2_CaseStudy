package Method;

import All_Classes.Brand;
import All_Classes.CRUD;
import All_Classes.Product;

import java.util.ArrayList;
import java.util.List;

public class Method_Brand implements CRUD<Brand> {
    protected List<Brand> brandList;
    public Method_Brand(){
        brandList = new ArrayList<>();
    }
    @Override
    public Brand getById(int id) {
        for (Brand brand : brandList){
            if (id == brand.getId()){
                return brand;
            }
        }
        return null;
    }

    @Override
    public Brand add(Brand brand) {
        brandList.add(brand);
        return brand;
    }

    @Override
    public void update(Brand brand) {
        for (int i = 0; i < brandList.size(); i++) {
            if (brandList.get(i).getId() == brand.getId()){
                brandList.set(i,brand);
            }
        }
    }

    @Override
    public Brand deleteById(int id) {
        for (Brand brand : brandList) {
            if (brand.getId() == id) {
                brandList.remove(brand);
                return brand;
            }
        }
        return null;
    }

    @Override
    public void displayById(int id) {
        for (Brand brand : brandList){
            if (id == brand.getId()){
                System.out.println(brand);
            }
        }
    }

    @Override
    public void displayAll() {
        for (Brand brand : brandList){
            System.out.println(brand);
        }
    }
}
