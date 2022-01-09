package controller;

import dao.AccountDao;
import model.Account;
import service.AccountService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
@WebServlet ("/account")
public class AccountServelet extends HttpServlet {
AccountDao accountDao = new AccountDao();
AccountService accountService = new AccountService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";

        }
        switch (action) {
            case "create":
//                List<Role> roleList = roledao.showRole();
//                request.setAttribute("roles" , roleList);
//                request.getRequestDispatcher("/view/customer/createCustomer.jsp").forward(request, response);
                break;
            case "edit":
//                roleList = roledao.showRole();
//                request.setAttribute("roles" , roleList);
//                request.getRequestDispatcher("/view/customer/editCustomer.jsp").forward(request, response);
                break;
            case "delete":

                break;
            default:
                showListProduct(request,response);
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createAccount(request,response);
                break;
            case "edit":

                break;
            case "search":
                searchByName(request,response);
                break;
            case "login" :
                loginAccount(request,response);
                break;
        }
    }

    public void searchByName (HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("search");

        RequestDispatcher dispatcher = request.getRequestDispatcher("product/product-page.jsp");
        List<Account> accountList = accountDao.searchByName(name);;
        request.setAttribute("accounts", accountList);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void createAccount(HttpServletRequest request, HttpServletResponse response)  {

        String username = request.getParameter("username");
        String passwords = request.getParameter("passwords");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        accountService.add(new Account(username,passwords,email,phone,address));
        try {
            response.sendRedirect("http://localhost:8080/LOGIN/account.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//
//    public void editCustomer(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        int id_role = Integer.parseInt(request.getParameter("id_role"));
//        String full_name = request.getParameter("full_name");
//        String passwords = request.getParameter("passwords");
//        String email = request.getParameter("email");
//        String phone = request.getParameter("phone");
//        String address = request.getParameter("address");
//        String img = request.getParameter("img");
//        Customer customer = new Customer(id, id_role, full_name, passwords, email,phone,address,img);
//        customerservice.edit(id,customer);
//
//        try {
//            response.sendRedirect("/customer");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
    public void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        accountService.delete(id);
        try {
            response.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response){
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/product-page.jsp");
        List<Account> accountList = accountDao.showListAccount();
        request.setAttribute("accounts", accountList);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    public void loginAccount(HttpServletRequest request, HttpServletResponse response){

        String user_name = request.getParameter("user_name");
        String passs_word = request.getParameter("passs_word");

        Account account = accountService.checkLoginAccount(user_name,passs_word);

        if (account == null) {
            request.setAttribute("mess" , "sai tai khoan hoac mat khau");
            try {
                request.getRequestDispatcher("/LOGIN/account.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else {
            try {
                HttpSession session = request.getSession();
                session.setAttribute("acc" , account);
                response.sendRedirect("/product");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
