package cn.tedu.jdbc.day01;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {

    static String driver;
    static String url;
    static String username;
    static String password;

    static{
        try{
            Properties cfg = new Properties();
            InputStream in = DBUtils.class.getClassLoader().getResourceAsStream("db.properties");
            cfg.load(in);
            System.out.println(cfg);
            //初始化
            driver = cfg.getProperty("jdbc.driver");
            url = cfg.getProperty("jdbc.url");
            username = cfg.getProperty("jdbc.username");
            password = cfg.getProperty("jdbc.password");
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
    /**
     * 封装数据库连接过程
     * 简化数据库连接
     * @return
     */
    public static Connection getConnetion(){
        try{
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,username,password);
            return conn;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 关闭数据库连接
     * @param conn
     */
    public static void close(Connection conn){
        try{
            if(conn!=null) {
                conn.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
