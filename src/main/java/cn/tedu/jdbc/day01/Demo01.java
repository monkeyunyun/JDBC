package cn.tedu.jdbc.day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo01 {
    public static void main(String[] args) throws Exception {
        Class.forName("oracle.jdbc.OracleDriver");
        System.out.println("OK!");

        Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:orclcdb",
                "system",
                "123456"
        );
        System.out.println(conn.getClass());
        Statement st = conn.createStatement();
        String sql = "create table robin_demo"
                +"(id number(5),"
                +"name varchar(50))";
        boolean b = st.execute(sql);
//          返回：true表示有结果集
//                false没有结果集
//                创建失败抛异常
        System.out.println(b);
        conn.close();

    }
}
