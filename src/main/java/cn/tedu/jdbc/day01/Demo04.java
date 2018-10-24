package cn.tedu.jdbc.day01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo04  {
    public static void main(String[] args)throws Exception{
        Connection conn = DBUtils.getConnetion();
        Statement st = conn.createStatement();
        String sql = "select id,name from robin_demo";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            System.out.println(id+","+name);
        }
        conn.close();
    }
}
