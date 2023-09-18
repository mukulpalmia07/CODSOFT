package atmSystem;
import java.util.*;
public class AtmMain {
	public static void main(String[] args) {
        
		AtmOperation op = new AtmOperation();
        int atmnumber = 1234;
        int atmpin = 123;
        Scanner in = new Scanner(System.in);
        
        System.out.println("<<<<<< Welcome to the ATM >>>>>>");
        System.out.println("Enter Atm Number : ");
        int atmNumber = in.nextInt();
        System.out.println("Enter Pin: ");
        int pin = in.nextInt();
        
        if((atmnumber == atmNumber) && (atmpin == pin)){
            
        	while(true){
            	
                System.out.println("1. View Available Balance");
                System.out.println("2. Withdraw Amount");
                System.out.println("3. Deposit Amount");
                System.out.println("4. View Account Statement");
                System.out.println("5. Exit");
                
                int ch = in.nextInt();
                
                if(ch == 1) op.viewBalance();
                
                else if(ch == 2){
                    System.out.println("Enter Amount to Withdraw: ");
                    double withdrawAmount=in.nextDouble();
                    op.withdrawAmount(withdrawAmount);
                }
                
                else if(ch == 3){
                    System.out.println("Enter Amount to Deposit: ");
                    double depositAmount = in.nextDouble();
                    op.depositAmount(depositAmount);
                    
                }
                else if(ch==4){
                    op.viewMiniStatement();

                }
                else if(ch==5){
                    System.out.println("Collect Your ATM Card. \nThank you for using ATM Machine.");
                    System.exit(0);
                }
                else
                {
                    System.out.println("Please Enter Correct Choice !!");
                }
            }
        }
        else{
            System.out.println("Incorrect ATM Number or Pin !!");
            System.exit(0);
        }
        in.close();
    }
}
