package Method;
import All_Classes.Brand;
import All_Classes.CRUD;
import All_Classes.ReadAndWrite;
import java.io.IOException;
import java.util.ArrayList;

public class Method_Brand implements CRUD<Brand>  {
    public ReadAndWrite<Brand> readAndWrite = new Brand_ReadAndWrite();


    public ArrayList<Brand> brandList = readAndWrite.readFile();


    public ArrayList<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(ArrayList<Brand> brandList) {
        this.brandList = brandList;
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
        try {
            readAndWrite.writeFile(brandList);
        }catch (IOException e){
            e.printStackTrace();
        }
        return brand;
    }

    @Override
    public void update(Brand brand) {
        for (int i = 0; i < brandList.size(); i++) {
            if (brandList.get(i).getId() == brand.getId()){
                brandList.set(i,brand);
            }
        }
        try {
            readAndWrite.writeFile(brandList);
        }catch (IOException e){
            e.printStackTrace();
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
        try {
            readAndWrite.writeFile(brandList);
        }catch (IOException e){
            e.printStackTrace();
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
