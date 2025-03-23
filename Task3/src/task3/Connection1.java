package task3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connection1 {

    Connection con;
    Statement statement;
    Connection1(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelManagement","root","Rahul@130");
            statement = con.createStatement();

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
