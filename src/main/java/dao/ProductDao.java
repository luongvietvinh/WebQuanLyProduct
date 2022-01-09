package dao;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    ConnectionJDBC connectionJDBC = new ConnectionJDBC();

    public void createProductDao(Product product) {
        String saveproduct = "INSERT INTO product (img,nameproduct,depcription,price,idSize,idcategory) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connectionJDBC.getConnection().prepareStatement(saveproduct);
            preparedStatement.setString(1, product.getImg());
            preparedStatement.setString(2, product.getNameproduct());
            preparedStatement.setString(3, product.getDepcription());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setInt(5, product.getIdSize());
            preparedStatement.setInt(6, product.getIdcategory());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<Product> showListProduct() {
        String show = "select product.* , category.nameCate,size.size from product join category on product.idcategory = category.idcategory join size on product.idsize = size.idsize";
        List<Product> productList = new ArrayList<>();

        try (Connection connection = connectionJDBC.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(show)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idproduct = rs.getInt("idproduct");
                String img = rs.getString("img");
                String nameproduct = rs.getString("nameproduct");
                String depcription = rs.getString("depcription");
                double price = rs.getDouble("price");
                String size = rs.getString("size");
                String nameCate = rs.getString("nameCate");
                productList.add(new Product(idproduct, img, nameproduct, depcription, price, size, nameCate));
            }
            return productList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Product> searchByName(String findname) {
        String getall = "select product.* , category.nameCate,size.size from product join category on product.idcategory = category.idcategory join size on product.idsize = size.idsize where product.nameproduct like '%" + findname + "%'";


        try {
            Statement statement = connectionJDBC.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(getall);
            List<Product> productList = new ArrayList<>();
            while (rs.next()) {
                int idproduct = rs.getInt("idproduct");
                String img = rs.getString("img");
                String nameproduct = rs.getString("nameproduct");
                String depcription = rs.getString("depcription");
                double price = rs.getDouble("price");
                String size = rs.getString("size");
                String nameCate = rs.getString("nameCate");
                productList.add(new Product(idproduct, img, nameproduct, depcription, price, size, nameCate));
            }
            return productList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Product> pagingProduct(int index) {
        List<Product> productList = new ArrayList<>();
        String query = "select * from product \n" +
                "order by idproduct\n" +
                "offset ? rows fetch next 3 rows only;";

        Connection connection = connectionJDBC.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, (index - 1) * 3);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                productList.add(new Product( rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getString(6),
                        rs.getString(7)
                ));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    //
    public int totalProduct() {
        String query = "select count(*) from product;";

        Connection connection = connectionJDBC.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public void deleteProduct(int id) {
        String deleteSQL = "DELETE  from product where id=?";
        try {
            PreparedStatement preparedStatement = connectionJDBC.getConnection().prepareStatement(deleteSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
