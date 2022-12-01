package DAO;
import Bean.*;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_connect {
    DatabaseUse database_use;
    Connection connect;
    Statement stateM;
    ResultSet reS;

    public boolean createConnection(DatabaseUse database_use){
        this.database_use=database_use;
        boolean flag=false;

         try {
            Class.forName(database_use.getDriver());//加载驱动
            connect = DriverManager.getConnection(database_use.getUrl(), database_use.getDbUser(), database_use.getDbPassword());
            database_use.setConnection(connect);
            flag = true;
            System.out.println("加载驱动成功");
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("createConnection(Database_connect database_connect):SQLException错误");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("createConnection(Database_connect database_connect):ClassNotFoundException错误");
        }
        return flag;
    }


    public boolean Update(String sql){
        boolean flag=false;
        try {
            stateM=connect.createStatement();
            stateM.executeUpdate(sql);
            database_use.setStatement(stateM);
            flag=true;
            System.out.println(sql+"数据库已更新！");
        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("Database_connect.Update(String sql):SQLException错误");
        }
        return flag;
    }


    public void Find(String sql){
        try {
            stateM=connect.createStatement();
            reS=stateM.executeQuery(sql);
            database_use.setResultSet(reS);
            System.out.println("查询操作成功！");
        } catch (SQLException e) {
            System.out.println("Database_connect.Find(String sql)错误！");
            System.out.println(e.toString());
            }
    }


    public void closeReS(){
        try {
            reS.close();
            System.out.println("reS已关闭！");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void closeStateM(){
        try {
            stateM.close();
            System.out.println("stateM已关闭！");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void closeConnect(){
        try {
            connect.close();
            System.out.println("Connect已关闭！");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
