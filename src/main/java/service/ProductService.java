package service;


import dao.ProductDao;

import model.Product;

public class ProductService {

ProductDao productDao = new ProductDao();
    public  void add (Product product) {
        productDao.createProductDao(product);
        productDao.showListProduct();
    }

    public void delete (int id) {
        productDao.deleteProduct(id);
        productDao.showListProduct();
    }
    public Product findProductByName(String name){
        for (Product p:productDao.showListProduct()) {
            if(p.getNameproduct().equalsIgnoreCase(name)){
                return p;
            }
        }
        return null;
    }
}
