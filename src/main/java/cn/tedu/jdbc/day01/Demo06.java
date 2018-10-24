package cn.tedu.jdbc.day01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo06 {
    public static void main(String[] srgs){
        Connection conn = null;
        try{
            conn = DBUtils.getConnetion();
            Statement st =  conn.createStatement();
            String sql = "select * from robin_demo";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println(id+","+name);
            }
            //默认会在conn.close关闭。当程序中有多个ResultSet时，为减少数据库压力，应及时释放
            rs.close();//释放查询结果
            st.close();//释放语句对象

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
    }
}
