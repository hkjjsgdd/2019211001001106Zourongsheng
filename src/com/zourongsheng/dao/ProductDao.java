package com.zourongsheng.dao;


import com.zourongsheng.model.Product;

import java.io.InputStream;
import java.sql.Connection;    
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements  IProductDao{
    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into Product(ProductName,ProductDescription,picture,price,CategoryID) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPicture()!=null) {
            //for sql server
            pt.setBinaryStream(3, product.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productId, Connection con) throws SQLException {
        PreparedStatement ps = null;
        String sql = "delete from Product where productId=?";
        ps=con.prepareStatement(sql);
        ps.setInt(1,productId);
        ps.executeUpdate();

        return 0;
    }

    @Override
    public int update(Product instance, Connection con) throws SQLException {
        PreparedStatement ps = null;
        String sql = "update Product set ProductId=?,ProductName=?,ProductDescription=?,pictire=?,price=?,CategoryId=? where id=?";
        ps=con.prepareStatement(sql);
        ps.setString(1,instance.getProductName());
        ps.setString(2,instance.getProductDescription());
        ps.setBinaryStream(3,instance.getPicture());
        ps.setDouble(4,instance.getPrice());
        ps.setInt(5,instance.getCategoryId());
        return ps.executeUpdate();

    }

    @Override
    public Product findById(Integer productId, Connection con) throws SQLException {
        String search = "select * from Product where productId=?";
        PreparedStatement ps = null;
        ps.setInt(1,productId);
        ResultSet rs = ps.executeQuery(search);
        Product product = new Product();
        if (rs.next()){
            product.setProductId(rs.getInt("ProductId"));

            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("CategoryId"));
        }

        return product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) throws SQLException {
        String search = "select * from Product where CategoryId=?";
        PreparedStatement st = con.prepareStatement(search);
        st.setInt(1,categoryId);
        ArrayList<Product> list= new ArrayList<Product>();
        ResultSet rs = st.executeQuery();
        Product product = null;
        if (rs.next()){
            product=new Product();
            product.setProductId(rs.getInt("ProductId"));

            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            list.add(product);
        }
        return list;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        String search = "select * from Product where minPrice=? and maxPrice=?";
        PreparedStatement st = con.prepareStatement(search);
        st.setDouble(1,minPrice);
        st.setDouble(2,maxPrice);
        ArrayList<Product> list= new ArrayList<Product>();
        ResultSet rs = st.executeQuery();
        Product product = null;
        if (rs.next()){
            product=new Product();
            product.setProductId(rs.getInt("ProductId"));

            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            list.add(product);
        }
        return list;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        String sql = "select * from Product";
        ArrayList<Product> list = new ArrayList<Product>();
        ResultSet rs =con.createStatement().executeQuery(sql);
        Product product = null;
        if (rs.next()){
            product=new Product();
            product.setProductId(rs.getInt("ProductId"));

            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            list.add(product);
        }
        return list;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        String search = "select * from Product where ProductName=?";
        PreparedStatement st = con.prepareStatement(search);
        st.setString(1,productName);
        ArrayList<Product> list= new ArrayList<Product>();
        ResultSet rs = st.executeQuery();
        Product product = null;
        if (rs.next()){
            product=new Product();
            product.setProductId(rs.getInt("ProductId"));

            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            list.add(product);
        }
        return list;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        String search = "select * from Product where ProductId=?";
        PreparedStatement st = con.prepareStatement(search);
        st.setInt(1,productId);
        ArrayList<Product> list= new ArrayList<Product>();
        ResultSet rs = st.executeQuery();
        Product product = null;
        if (rs.next()){
            product=new Product();
            product.setProductId(rs.getInt("ProductId"));

            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            list.add(product);
        }
        return list;
    }
}
