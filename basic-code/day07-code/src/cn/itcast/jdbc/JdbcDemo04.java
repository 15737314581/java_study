package cn.itcast.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDemo04 {
    public static void main(String[] args) {
        List<Goods> list = new JdbcDemo04().findAll();
        for (Goods goods : list) {
            System.out.println(goods);
        }
        System.out.println(list.size());
    }

    public List<Goods> findAll(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Goods> list = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///jing_dong","root","root");
            stmt = conn.createStatement();
            String sql = "select * from goods";
            rs = stmt.executeQuery(sql);
            list = new ArrayList<>();
            Goods good = null;
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int cate_id = rs.getInt("cate_id");
                int brand_id = rs.getInt("brand_id");
                double price = rs.getDouble("price");
                byte is_show = rs.getByte("is_show");
                byte is_saleoff = rs.getByte("is_saleoff");

               good = new Goods();
               good.setId(id);
               good.setName(name);
               good.setCate_id(cate_id);
               good.setBrand_id(brand_id);
               good.setPrice(price);
               good.setIs_show(is_show);
               good.setIs_saleoff(is_saleoff);
               list.add(good);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


        return list;
    }
}
