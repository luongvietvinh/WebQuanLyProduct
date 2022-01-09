package model;

public class Size {
    private int idsize;
    private String size;

    public Size(int idsize, String size) {
        this.idsize = idsize;
        this.size = size;
    }

    public int getIdsize() {
        return idsize;
    }

    public void setIdsize(int idsize) {
        this.idsize = idsize;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
