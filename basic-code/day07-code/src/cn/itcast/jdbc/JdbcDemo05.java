package cn.itcast.jdbc;

import cn.itcast.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDemo05 {
    public static void main(String[] args) {
        List<Goods> list = new JdbcDemo05().findAll1();
        for (Goods goods : list) {
            System.out.println(goods);
        }
        System.out.println(list.size());
    }

    public List<Goods> findAll1(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Goods> list = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from goods";
            rs = stmt.executeQuery(sql);
            list = new ArrayList<>();
            Goods good = null;
            while (rs.next()){
                int id1 = rs.getInt("id");
                String name = rs.getString("name");
                int cate_id = rs.getInt("cate_id");
                int brand_id = rs.getInt("brand_id");
                double price = rs.getDouble("price");
                byte is_show = rs.getByte("is_show");
                byte is_saleoff = rs.getByte("is_saleoff");

               good = new Goods();
               good.setId(id1);
               good.setName(name);
               good.setCate_id(cate_id);
               good.setBrand_id(brand_id);
               good.setPrice(price);
               good.setIs_show(is_show);
               good.setIs_saleoff(is_saleoff);
               list.add(good);
            }

        }  catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs,stmt,conn);
        }


        return list;
    }
}
