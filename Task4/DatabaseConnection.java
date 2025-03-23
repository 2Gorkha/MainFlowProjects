

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class DatabaseConnection {
    public static final String URL = "jdbc:mysql://localhost:3306/mainflow";
    public static final String USER = "root";
    public static final String Password = "Rahul@130";

    public static Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mainflow","root","Rahul@130");
            System.out.println("Connection is Done");
        }catch(ClassNotFoundException | SQLException e){
            System.err.println("Connection Error :"+ e.getMessage());

        }
        return con;

    }


    public static void main(String[] args) {
        getConnection();


        // TODO code application logic here
    }

}
