package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import Bean.*;

public class Register_connect {
    DatabaseUse dbUse=new DatabaseUse();
    Database_connect dConnect=new Database_connect();


    public String Register(String name,String password){
        Identity reConnect=new Identity(name,password);
        String sql="select * from identity where name='"+name+"'";
        Connection conn= dbUse.getConn();
        if(conn==null){
            dConnect.createConnection(dbUse);
        }
        dConnect.Find(sql);
        ResultSet reS= dbUse.getResultSet();
        String url="";

        if(name!=""&&password!=""||name.contains(" ")){
            try {
                if(reS.next()){
                    url="register.jsp";
                    return url;
                }else {
                    String sqlReg="insert into identity values(NULL,'"+name+"','"+password+"')";
                    boolean flag=dConnect.Update(sqlReg);
                    if(flag){
                        url="login.jsp";
                    }else {
                        url="Fail.jsp";
                        return url;
                    }
                }
            } catch (SQLException e) {
                System.out.println("Register_connect.Register(String name,String password：)：错误");
                e.printStackTrace();
            }
        }else {
            url="inputNull";
            return url;
        }
        dConnect.closeReS();
        dConnect.closeConnect();
        dConnect.closeStateM();
        return url;
    }
}
