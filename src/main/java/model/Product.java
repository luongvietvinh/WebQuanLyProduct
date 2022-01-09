package model;

public class Product {
    private int idproduct;
    private String img;
    private String nameproduct;
    private String depcription;
    private double price;
    private int idSize;
    private int idcategory ;
   private String size;
   private String nameCate;
    public Product(int idproduct, String img,
                   String nameproduct, String depcription, double price, int idSize, int idcategory) {
        this.idproduct = idproduct;
        this.img = img;
        this.nameproduct = nameproduct;
        this.depcription = depcription;
        this.price = price;
        this.idSize = idSize;
        this.idcategory = idcategory;
    }

    public Product(int idproduct, String img, String nameproduct, String depcription,
                   double price, String size, String nameCate) {
        this.idproduct = idproduct;
        this.img = img;
        this.nameproduct = nameproduct;
        this.depcription = depcription;
        this.price = price;
        this.size = size;
        this.nameCate = nameCate;
    }


    public int getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNameproduct() {
        return nameproduct;
    }

    public void setNameproduct(String nameproduct) {
        this.nameproduct = nameproduct;
    }

    public String getDepcription() {
        return depcription;
    }

    public void setDepcription(String depcription) {
        this.depcription = depcription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getIdSize() {
        return idSize;
    }

    public void setIdSize(int idSize) {
        this.idSize = idSize;
    }

    public int getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(int idcategory) {
        this.idcategory = idcategory;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getNameCate() {
        return nameCate;
    }

    public void setNameCate(String nameCate) {
        this.nameCate = nameCate;
    }
}
