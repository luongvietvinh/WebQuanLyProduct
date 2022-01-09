package dao;

import model.Account;
import model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    ConnectionJDBC connectionJDBC = new ConnectionJDBC();
    public void createOrderDao(Order order) {
        String saveproduct = "INSERT INTO oder (idproduct,idaccount,total) VALUES (?,?,?,)";
        try{
            PreparedStatement preparedStatement = connectionJDBC.getConnection().prepareStatement(saveproduct);
            preparedStatement.setInt(1, order.getIdproduct());
            preparedStatement.setInt(2, order.getIdaccount());
            preparedStatement.setDouble(3, order.getTotal());
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Order> showListOder() {
        String show = "select oder.* , role .nameRole from account join role on account.idoder = role.idoder";
        List<Order> orderList = new ArrayList<>();

        try (Connection connection = connectionJDBC.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(show)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idoder = rs.getInt("idoder");
                int idproduct = rs.getInt("idproduct");
                int idaccount = rs.getInt("idaccount");
                double total = rs.getDouble("total");
                orderList.add(new Order(idoder,idproduct,idaccount,total));
            }
            return orderList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Order> searchByName(String findname) {
        String getall = "select account.* , role .nameRole from account join role on account.idoder = role.idoder where account.username like '%" + findname +"%'";


        List<Order> orderList = new ArrayList<>();

        try (Connection connection = connectionJDBC.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(getall)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idoder = rs.getInt("idoder");
                int idproduct = rs.getInt("idproduct");
                int idaccount = rs.getInt("idaccount");
                double total = rs.getDouble("total");
                orderList.add(new Order(idoder,idproduct,idaccount,total));
            }
            return orderList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }



    public void deleteAccount(int id) {
        String deleteSQL = "DELETE  from oder where id=?";
        try {
            PreparedStatement preparedStatement = connectionJDBC.getConnection().prepareStatement(deleteSQL);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
