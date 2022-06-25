package Method;

import All_Classes.Brand;
import All_Classes.ReadAndWrite;
import All_Classes.account;

import java.io.*;
import java.util.ArrayList;

public class Account_ReadAndWrite implements ReadAndWrite<account> {
    @Override
    public ArrayList<account> readFile() {
        File file = new File("D:\\Project\\Modul_2\\CaseStudy_Modul_2\\src\\Data\\Account.txt");
        try{
            if (!file.exists()){
                file.createNewFile();
            }
            ObjectInputStream read = new ObjectInputStream(new FileInputStream(file));
            ArrayList<account> accounts = (ArrayList<account>) read.readObject();
            read.close();
            return accounts;
        }catch (Exception e){
            e.getMessage();
        }
        return new ArrayList<>();
    }

    @Override
    public void writeFile(ArrayList<account> list) throws IOException {
        File file = new File("D:\\Project\\Modul_2\\CaseStudy_Modul_2\\src\\Data\\Account.txt");

        try {
            if (!file.exists()){
                file.createNewFile();
            }
            ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(file));
            write.writeObject(list);
            write.close();
        }
        catch (FileNotFoundException IOException){
            IOException.printStackTrace();
        }
        catch (IOException  e){
            e.getMessage();
        }
    }
}
