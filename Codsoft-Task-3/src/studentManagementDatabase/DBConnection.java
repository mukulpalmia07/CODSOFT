package studentManagementDatabase;
import java.sql.*;
public class DBConnection {

	static Connection con;
	
	public static Connection createConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentData_details", "root", "root_pass_1234");
		}
        catch(Exception ex){
            ex.printStackTrace();
        }

        return con;
	}

}
