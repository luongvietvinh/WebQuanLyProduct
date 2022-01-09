package model;

public class Category {
    private int idcategory;
    private String nameCate;

    public Category(int idcategory, String nameCate) {
        this.idcategory = idcategory;
        this.nameCate = nameCate;
    }

    public int getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(int idcategory) {
        this.idcategory = idcategory;
    }

    public String getNameCate() {
        return nameCate;
    }

    public void setNameCate(String nameCate) {
        this.nameCate = nameCate;
    }
}
