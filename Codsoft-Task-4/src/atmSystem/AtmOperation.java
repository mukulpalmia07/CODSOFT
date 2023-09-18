package atmSystem;

import java.util.*;

public class AtmOperation {
	ATM obj = new ATM();
	Map<Double, String> map = new HashMap<>();
	
	public void viewBalance() {
		System.out.println("Available Balance is : " + obj.getBalance());
	}

    public void withdrawAmount(double withdrawAmount) {
        if(withdrawAmount % 500 == 0) {
            if (withdrawAmount <= obj.getBalance()) {
                map.put(withdrawAmount, " Amount Withdrawn");
                System.out.println("Collect the Cash " + withdrawAmount);
                obj.setBalance(obj.getBalance() - withdrawAmount);
                viewBalance();
            } else {
                System.out.println("Insufficient Balance !!");
            }
        }
        else {
            System.out.println("Please Enter the Amount in Multipal of 500");
        }

    }

    public void depositAmount(double depositAmount) {
        map.put(depositAmount," Amount Deposited");
        System.out.println(depositAmount + " Deposited Successfully !!");
        obj.setBalance(obj.getBalance() + depositAmount);
        viewBalance();

    }

    public void viewMiniStatement() {
        for(Map.Entry<Double,String> m : map.entrySet()){
            System.out.println(m.getKey() + "" + m.getValue());
        }
    }
}