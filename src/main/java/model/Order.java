package model;

import java.sql.Date;

public class Order {
    private int idoder;
    private int idproduct;
    private  int idaccount;
    private Date checkout;
    private Date checkin;
    private double total;

    public Order(int idoder, int idproduct, int idaccount, Date checkout, Date checkin, double total) {
        this.idoder = idoder;
        this.idproduct = idproduct;
        this.idaccount = idaccount;
        this.checkout = checkout;
        this.checkin = checkin;
        this.total = total;
    }

    public Order(int idoder, int idproduct, int idaccount, double total) {
        this.idoder = idoder;
        this.idproduct = idproduct;
        this.idaccount = idaccount;

        this.total = total;
    }


    public int getIdoder() {
        return idoder;
    }

    public void setIdoder(int idoder) {
        this.idoder = idoder;
    }

    public int getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }

    public int getIdaccount() {
        return idaccount;
    }

    public void setIdaccount(int idaccount) {
        this.idaccount = idaccount;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
