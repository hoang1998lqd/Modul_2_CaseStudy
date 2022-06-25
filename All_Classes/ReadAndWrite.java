package All_Classes;

import java.io.IOException;
import java.util.ArrayList;

public interface ReadAndWrite<E> {
    ArrayList<E> readFile();
    void writeFile(ArrayList<E> list) throws IOException;
}
