package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import Bean.*;

public class Login_connect {


    public String login(String name,String password){
        Identity id=new Identity(name,password);
        Database_connect dConnect=new Database_connect();
        DatabaseUse dbUse=new DatabaseUse();


        String sql="select * from identity where name='"+name+"'&& password='"+password+"'";
        boolean flag=dConnect.createConnection(dbUse);

        String url="";
        if(flag){
            System.out.println("连接数据库成功！");
            dConnect.Find(sql);//使用上方sql语句查询数据库
            ResultSet reS=dbUse.getResultSet();
            try {
                if(reS.next()){
                    System.out.println("用户登录成功！");
                    url="next/success.jsp";
                }else {
                    System.out.println("用户登录失败！");
                    url="Fail.jsp";
                    return url;
                }
            } catch (SQLException e) {
                System.out.println("Login_connect.login(String name,String password)：错误");
                e.printStackTrace();
            }
        }
        dConnect.closeConnect();
        dConnect.closeReS();
        dConnect.closeStateM();
        return url;
    }

}
