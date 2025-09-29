package com.banksystem.application.db;
//导入模块
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
//数据库类
public class Database {
    private static Connection connection = null;
    //获取数据库连接
    public static Connection conn(){
        if (Objects.nonNull(connection)){
            return connection;
        }

        String url = "jdbc:mysql://localhost:3306/banksystem?useSSL=false&serverTimezone=UTC";
    try {
        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取数据库连接
        connection = DriverManager.getConnection(url, "root", "123456");
    }catch (SQLException e){
        e.printStackTrace();
    }catch (ClassNotFoundException e){
        e.printStackTrace();
    }
        return connection;
    }

    public static Connection getConn() {
        return conn();
    }
}
