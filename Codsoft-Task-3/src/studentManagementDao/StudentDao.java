package studentManagementDao;
import studentManagementDatabase.DBConnection;
import studentManagementDetails.Student;
import java.sql.*;
public class StudentDao implements StudentDaoInterface {
	
	    public boolean insertStudent(Student s) {
	        boolean flag = false;
	        try{
	            Connection con = DBConnection.createConnection();
	            String query = "insert into studentData_details(sname,clgname,city,percentage) value(?,?,?,?)";
	            PreparedStatement pst = con.prepareStatement(query);
	            pst.setString(1,s.getName());
	            pst.setString(2,s.getClgName());
	            pst.setString(3,s.getCity());
	            pst.setDouble(4,s.getPercentage());
	            pst.executeUpdate(query);
	            flag = true;

	        }
	        catch (Exception ex){
	            ex.printStackTrace();
	        }
	        return flag;
	    }

	    
	    public boolean delete(int roll) {
	        boolean flag = false;
	        try{
	            Connection con = DBConnection.createConnection();
	            String query = "delete From studentData_details Where Roll Number= " + roll;
	            PreparedStatement pst = con.prepareStatement(query);
	            pst.executeUpdate(query);
	            flag = true;

	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }
	        return flag;
	    }

	   
	    public boolean update(int roll, String update, int ch, Student s) {
	        int choice = ch;
	        boolean flag = false;
	        try{
	            if(choice == 1){
	                Connection con = DBConnection.createConnection();
	                String query = "update studentData_details set sname=? where rollnum=?";
	                PreparedStatement ps = con.prepareStatement(query);
	                ps.setString(1,update);
	                ps.setInt(2,roll);
	                ps.executeUpdate(query);
	                flag = true;
	            }

	        }catch (Exception ex){
	            ex.printStackTrace();
	        }
	        return flag;
	    }

	    
	    public void showAllStudent() {
	        try{
	            Connection con = DBConnection.createConnection();
	            String query = "Select * From studentData_details";
	            Statement stmt = con.createStatement();
	            ResultSet rs = stmt.executeQuery(query);
	            while(rs.next()){
	                System.out.println("RollNumber: " + rs.getInt(1) + "\n" +
	                        "Name: " + rs.getString(2) + "\n" +
	                        "College Name: " + rs.getString(3) + "\n" +
	                        "City: " + rs.getString(4) + "\n" +
	                        "Percentage: " + rs.getDouble(5));
	                System.out.println("----------------------------------");

	            }

	        }
	        catch (Exception ex){
	            ex.printStackTrace();
	        }

	    }

	   
	    public boolean showStudentById(int roll) {
	        boolean flag = false;
	        try{

	            Connection con = DBConnection.createConnection();
	            String query = "select * from studentData_details where rollnum="+roll;
	            Statement stmt = con.createStatement();
	            ResultSet rs = stmt.executeQuery(query);
	            while(rs.next()){
	            	System.out.println("RollNumber: " + rs.getInt(1) + "\n" +
	                        "Name: " + rs.getString(2) + "\n" +
	                        "College Name: " + rs.getString(3) + "\n" +
	                        "City: " + rs.getString(4) + "\n" +
	                        "Percentage: " + rs.getDouble(5));
	                System.out.println("----------------------------------");
	                flag = true;

	            }

	        }
	        catch (Exception ex){
	            ex.printStackTrace();
	        }

	        return flag;
	    }
	}
