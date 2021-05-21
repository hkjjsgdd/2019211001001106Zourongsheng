package com.zourongsheng.controller;

import com.zourongsheng.dao.ProductDao;
import com.zourongsheng.model.Category;
import com.zourongsheng.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ShopServlet",value = "/shop")
public class ShopServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // select all category into request

        try {
            List<Category> categoryList = Category.findAllCategory(con);
            request.setAttribute("categoryList",categoryList);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // select all product into request
        ProductDao productDao=new ProductDao();
        try {
            if (request.getParameter("categoryId")==null){
                List<Product> productList = productDao.findAll(con);
                request.setAttribute("productList",productList);
            }else {
                int catId = Integer.parseInt(request.getParameter("categoryId"));
                List<Product> productList = productDao.findByCategoryId(catId,con);
                request.setAttribute("productList",productList);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        String path = "/WEB-INF/views/shop.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }
}
