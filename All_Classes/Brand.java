package All_Classes;

public class Brand {
    protected static int ID_BRAND = 1;
    protected int id;
    protected String nameBrand;

    public Brand() {
    }

    public Brand(int id, String nameBrand) {
        this.id = ID_BRAND++;
        this.nameBrand = nameBrand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBrand() {
        return nameBrand;
    }

    public void setNameBrand(String nameBrand) {
        this.nameBrand = nameBrand;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", nameBrand='" + nameBrand + '\'' +
                '}';
    }
}
