package Bean;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
public class DatabaseUse {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url="jdbc:mysql://localhost:3306/shujuku";
    private String dbUser="root";
    private String dbPassword="mysqlsb200288";
    private Connection connection=null;//数据库连接对象
    private Statement statement=null;//数据库声明对象
    private ResultSet resultSet=null;//数据库结果集对象

    public String getDriver(){
        return driver;
    }
    public void setDriver(String driver) {
        this.driver=driver;
    }
    public String getUrl(){
        return url;
    }
    public void setUrl(String url){
        this.url=url;
    }
    public String getDbUser(){
        return dbUser;
    }
    public void setDbUser(String dbUser){
        this.dbUser=dbUser;
    }
    public String getDbPassword(){
        return dbPassword;
    }
    public void setDbPassword(String dbPassword){
        this.dbPassword=dbPassword;
    }


    public Connection getConn(){
        return connection;
    }
    public void setConnection(Connection connection){
        this.connection=connection;
        System.out.println("connection赋值成功！");
    }
    public Statement getStatement(){
        return statement;
    }
    public void setStatement(Statement statement){
        this.statement=statement;
        System.out.println("statement赋值成功！");
    }
    public ResultSet getResultSet(){
        return resultSet;
    }
    public void setResultSet(ResultSet resultSet){
        this.resultSet=resultSet;
        System.out.println("resultSet赋值成功！");
    }
}
