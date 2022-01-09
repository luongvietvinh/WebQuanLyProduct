package controller;

import dao.AccountDao;
import dao.OrderDao;
import dao.ProductDao;
import model.Account;
import model.Product;
import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
ProductDao productDao = new ProductDao();
ProductService productService = new ProductService();
AccountDao accountDao = new AccountDao();
OrderDao orderDao = new OrderDao();

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
            case "searchdetail":
                String name = request.getParameter("nameProduct");
                Product product = productService.findProductByName(name);
                request.setAttribute("p", product);
                request.getRequestDispatcher("/product/productdetail.jsp").forward(request,response);

                break;

            default:
        showListProduct(request,response);
                break;
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
                break;
            case "edit":
                break;
            case "searchdetail":
                    break;
            case "search":
            showListProduct(request,response);
                break;
            case "login" :

        }
    }

    public void searchByName (HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("search");

        RequestDispatcher dispatcher = request.getRequestDispatcher("product/home.jsp");
        List<Product> productList = productDao.searchByName(name);;
        request.setAttribute("products", productList);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    public void searchByNamedetail (HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("search");

        RequestDispatcher dispatcher = request.getRequestDispatcher("product/product.jsp");
        List<Product> productList = productDao.searchByName(name);;
        request.setAttribute("products", productList);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


//    private void createproduct(HttpServletRequest request, HttpServletResponse response)  {
//
//        String full_name = request.getParameter("full_name");
//        String passwords = request.getParameter("passwords");
//        String email = request.getParameter("email");
//        String phone = request.getParameter("phone");
//        String address = request.getParameter("address");
//        String img = request.getParameter("img");
//        int id_role = Integer.parseInt(request.getParameter("id_role"));
//        .add(new Customer( full_name, passwords, email,phone,address,img,id_role));
//        try {
//            response.sendRedirect("/customer");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
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
//    public void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        customerservice.delete(id);
//        try {
//            response.sendRedirect("/customer");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public void getAllProduct (HttpServletRequest request, HttpServletResponse response) {
        String indexpage = request.getParameter("index");
        if (indexpage == null) {
            indexpage = "1";
        }
        int index = Integer.parseInt(indexpage);
        int count = productDao.totalProduct();
        int endpag = count/3;
        if (count % 3 != 0) {
            endpag ++;
        }
        List<Product> list = productDao.pagingProduct(index);
        request.setAttribute("products",list);
        request.setAttribute("endP" , endpag);
        try {
            request.getRequestDispatcher("/product/home.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }


    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response){
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/home.jsp");
        List<Product> productList = productDao.showListProduct();
        request.setAttribute("products", productList);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
//    public void loginCustomer(HttpServletRequest request, HttpServletResponse response){
//
//        String user_name = request.getParameter("user_name");
//        String passs_word = request.getParameter("passs_word");
//
//        Account account = a.checkLoginCustomer(user_name,passs_word);
//
//        if (customer == null) {
//            request.setAttribute("mess" , "sai tai khoan hoac mat khau");
//            try {
//                request.getRequestDispatcher("/view/login/account.jsp").forward(request,response);
//            } catch (ServletException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }else {
//            try {
//                System.out.println("login thanh cong");
//                response.sendRedirect("customer");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
