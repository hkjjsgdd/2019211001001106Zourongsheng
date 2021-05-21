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

@WebServlet(name = "ProductDetailsServlet",value = "/productDetails")
public class ProductDetailsServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<Category> categoryList = Category.findAllCategory(con);
            request.setAttribute("categoryList",categoryList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
        if (request.getParameter("id")!=null) {
            int productId = Integer.parseInt(request.getParameter("id"));
            ProductDao productDao = new ProductDao();
            Product product = null;
            product = productDao.findById(productId,con);
            request.setAttribute("p",product);
        }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        //forward
        String path = "/WEB-INF/views/productDetails.jsp";
        request.getRequestDispatcher(path).forward(request,response);

        }
    }

