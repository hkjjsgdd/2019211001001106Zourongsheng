package com.zourongsheng.controller;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.zourongsheng.dao.OrderDao;
import com.zourongsheng.model.Item;
import com.zourongsheng.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "OrderDetailsServlet",value = "/orderDetails")
public class OrderDetailsServlet extends HttpServlet {
    Connection con = null;
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");

    }
    public void destroy(){
        super.destroy();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId= request.getParameter("orderId")!=null?
                Integer.parseInt(request.getParameter("orderId")):0;
        Item item = new Item();
        OrderDao dao = new OrderDao();
        List<Item> items = dao.findItemsByOrderId(con,orderId);
        //Log.info(items.toString())
        request.setAttribute("itemList",items);
        String path= "orderDetails.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }
}
