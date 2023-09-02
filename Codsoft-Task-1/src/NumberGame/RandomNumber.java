package NumberGame;
import java.util.Scanner;
import java.util.*;

public class RandomNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		int num;
	    
		// GAME INTERFACE
		
	    System.out.println("<<<<<<<<<<<<<<<<<<<<<<< GUESS THE NUMBER GAME >>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("----------------------------- Main menu ---------------------------- \n");
        System.out.println("\nInstructions:");
        System.out.println("1. The computer will pick a secret random number.");
        System.out.println("2. You have to guess what number it is.");
        System.out.println("3. If your guess is too high or too low, It will give you a hint.");
        System.out.println("4. See how much you score ! \n");
        System.out.println("-------------------------------------------------------------------- \n");
        
        
        System.out.print("Press 1 to continue. \n");
        
        num = sc.nextInt();
        
        switch (num) {
			case 1:
				play(random, sc);
				break;
			default:
				System.out.println("Wrong option !!! Try Again.. \n");
	} 
	       
	}
	
	private static String feedback(int genNum, int userNum) {
		
        if (userNum > genNum) {
            if (userNum - genNum < 5) {
                return "Too Close ! Choose a lesser number. \n";
            } else {
                return "Number is too High. \n";
            }
        } else {
            if (genNum - userNum < 5) {
                return "Too Close ! Choose a higher number. \n";

            } else {
                return "Number is too low. \n";
            }
        }
    }
	
	private static void play(Random random, Scanner sc) {
		
        System.out.println("Select a Your Playing Level : \n");
        System.out.println("1. Hard(0-1000) \n2. Easy(0-50) \n3. Default(0-100)");
        int attempts = 0;
        int level = sc.nextInt();

        // GENERATING THE RANDOM NUMBER
        
        int generatedNumber = random.nextInt(100);        
        if (level == 1) {
            generatedNumber = random.nextInt(1000);
            attempts = 20;
            System.out.println("You Have Selected Hard \n");
        } else if (level == 2) {
            generatedNumber = random.nextInt(50);
            attempts = 10;
            System.out.println("You Have Selected Easy \n");
        } else {
        	attempts = 15;
            System.out.println("You Have Selected Default \n");
        }
        
        System.out.println("Computer Has Selected Its Random Number. \nNow Its Your Turn to Guess The Number.");

        System.out.print("You Have " + (attempts) + " Attempts To Win The Game.\n");
        
        while (attempts >= 0) {
            // IF YOU HAVE LEFT WITH NO ATTEMPTS
            if (attempts == 0) {
                System.out.println("You Failed to guess the number.");
                break;
            }

            // GUESSING THE NUMBER
            System.out.print("\nGuess The Number: ");
            int n = sc.nextInt();

            if (generatedNumber == n && level == 1) {
                System.out.println("Correct! The number is : " + n + ". \nYou guessed in " + (21 - attempts) + " attempts. \n");
                break;
            } else if (generatedNumber == n && level == 2) {
                System.out.println("Correct! The number is : " + n + ". \nYou guessed in " + (11 - attempts) + " attempts. \n");
                break;
            } else if (generatedNumber == n) {
                System.out.println("Correct! The number is : " + n + ". \nYou guessed in " + (16 - attempts) + " attempts. \n");
                break;
            } else {
                // DISPLAYING THE FEEDBACK ACCORDING TO THE GUESSED NUMBER
                System.out.println(feedback(generatedNumber, n));
                attempts--;
            }

        }
        
        System.out.println("Do you Want to Play Again ? \n1. Confirm \n2. Quit");
        if (sc.nextInt() == 1) {
            play(random, sc);
        } else System.out.println("Exiting the Game. Bye Bye ! \n");
    }
}

	