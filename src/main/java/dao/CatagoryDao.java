package dao;

import model.Account;
import model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CatagoryDao {

    ConnectionJDBC connectionJDBC = new ConnectionJDBC();


    public void createAccountDao(Account account) {
        String saveproduct = "INSERT INTO category (username,passwords,email,phone,address) VALUES (?,?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connectionJDBC.getConnection().prepareStatement(saveproduct);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPasswords());
            preparedStatement.setString(3, account.getEmail());
            preparedStatement.setString(4, account.getPhone());
            preparedStatement.setString(5, account.getAddress());
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Category> showListCategory() {
        String show = "select category.* from category";
        List<Category> categoryList = new ArrayList<>();

        try (Connection connection = connectionJDBC.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(show)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idaccount");
                String username = rs.getString("nameCate");
                categoryList.add(new Category(id,username));
            }
            return categoryList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Account> searchByName(String findname) {
        String getall = "select account.* , role .nameRole from account join role on account.idrole = role.idrole where account.username like '%" + findname +"%'";


        try {
            Statement statement = connectionJDBC.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(getall);
            List<Account> accountList = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("idaccount");
                String username = rs.getString("username");
                String passwords = rs.getString("passwords");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                int idrole = rs.getInt("idrole");
                accountList.add(new Account(id,username,passwords,email,phone,address,idrole));
            }
            return accountList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }



    public void deleteAccount(int id) {
        String deleteSQL = "DELETE  from account where id=?";
        try {
            PreparedStatement preparedStatement = connectionJDBC.getConnection().prepareStatement(deleteSQL);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
