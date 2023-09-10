package studentManagement;
import java.util.*;
import studentManagementDetails.Student;
import studentManagementDao.StudentDaoInterface;
import studentManagementDao.StudentDao;


public class Client {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StudentDaoInterface dao = new StudentDao();
        
        while(true){
        	
        	System.out.println("*************************************************");
            System.out.println("|\tStudent Management System\t\t|");
            System.out.println("*************************************************");
            System.out.println("| Select an option :\t\t\t\t|");
            System.out.println("|  1. Add a Student.\t\t\t\t|");
            System.out.println("|  2. Display all Students.\t\t\t|");
            System.out.println("|  3. Search a Student.\t\t\t\t|");
            System.out.println("|  4. Delete a Student.\t\t\t\t|");
            System.out.println("|  5. Update a Student.\t\t\t\t|");
            System.out.println("|  6. Exit App.\t\t\t\t\t|");
            System.out.println("*************************************************");
            
            System.out.print("Enter Option No. : ");
            int ch = sc.nextInt();
            
            switch (ch){
                
            	case 1:
            		sc.nextLine();
            		System.out.println("Add a Student");
                    System.out.println("Enter Student Name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter Student's College Name: ");
                    String clgName = sc.nextLine();
                    System.out.println("Enter Address: ");
                    String city = sc.nextLine();
                    System.out.println("Enter Percentage: ");
                    double percentage = sc.nextDouble();
                    Student st = new Student(name, clgName, city, percentage);
                    boolean ans = dao.insertStudent(st);
                    if(ans)
                        System.out.println("Record Inserted Successfully...");
                    else
                        System.out.println("Something Went Wrong, Please Try Again!!!");
                    break;
                
            	case 2:
                    
            		System.out.println("Display all Students");
                    dao.showAllStudent();
                    break;
                
            	case 3:
                    
            		System.out.println("Search a Student");
                    System.out.println("Enter Roll Number of the Student: ");
                    int roll = sc.nextInt();
                    boolean f = dao.showStudentById(roll);
                    if(!f)
                    	System.out.println("Student with this ID is not Available in our System!!!");
                    break;
                
            	case 4:
                    
            		System.out.println("Delete a Student");
                    System.out.println("Enter Roll Number to Delete: ");
                    int rollnum = sc.nextInt();
                    boolean ff = dao.delete(rollnum);
                    if(ff)
                        System.out.println("Record Deleted Successfully...");
                    else
                        System.out.println("Something Went Wrong!!!");
                    break;
                
            	case 5:
                    
            		System.out.println("Update a Student");
                    System.out.println("\n1.Update Name \n2.Update College");
                    System.out.println("Enter Your Choice: ");
                    int choice = sc.nextInt();
                    if(choice == 1){
                        System.out.println("Enter Roll Number: ");
                        int rnum = sc.nextInt();
                        System.out.println("Enter New Name: ");
                        String sname = sc.next();
                        Student std = new Student();
                        std.setName(sname);
                        boolean flag = dao.update(rnum, sname, choice, std);
                        if(flag)
                        	System.out.println("Name Updated Successfully...");
                        else
                        	System.out.println("Something Went Wrong!!!");
                    }
                    break;
                
            	case 6:
                    
            		System.out.println("Thank You for Using Student Management System");
                    System.exit(0);
                
            	default:
                    
            		System.out.println("Please Enter Valid Choice!!!");
            
            }
        }
	}
}