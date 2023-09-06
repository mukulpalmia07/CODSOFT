package wordCounter;
import java.util.*;
import java.io.FileReader;
import java.io.IOException;

public class CountWords {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		

        System.out.println("<<<<<<<<<<<<<<<<< WORD COUNTER >>>>>>>>>>>>>>>>>");
        System.out.println("************************************************");
        System.out.println("Select Option For Your Word Counter");
        System.out.println("1. INPUT YOUR TEXT \n2. INPUT YOUR FILE \n3. EXIT");
        System.out.println("************************************************");
        int num = sc.nextInt();
        
        switch (num) {        	
      
        	case 1:
        		userInput();
                break;
        	case 2: 
        		inputFile(sc);
                break;
        	case 3:
        		 System.out.println("Exiting..");
        		 break;
        	default:
        		System.out.println("Wrong Choice..");
        
        }
        
        
        sc.close();
    }
	
	private static void userInput() {
		
    	String string = inputText();
    	String[] splitWords = string.split("\\W+");
    	helper(splitWords);
    	
	}
	
	private static void inputFile(Scanner sc)  {
		
		String str1 = "";
        String filePath = inputText();
        StringBuilder str = new StringBuilder();
        try (Scanner string = new Scanner(new FileReader(filePath))){
            while (string.hasNextLine()) str.append(string.nextLine());
        } catch (IOException excp) { System.out.println("ERROR !!!  Try Uploading Another File" + excp.getMessage()); }
        str1 = str.toString();
        String[] splitWords = str1.split("\\W+");
        helper(splitWords);
        
    }

    private static void helper(String[] splitWords) {
    	int count = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String str : splitWords) {
            if (!str.isEmpty()) {
                str = str.toLowerCase().trim();
                if (map.containsKey(str)) {
                    map.put(str, map.get(str) + 1);
                } else {
                    map.put(str, 1);
                }
                count++;
            }
        }
        System.out.println("Number of Words in Your Text: " + count);
        System.out.println("Number of Unique Words in Your Text: " + map.size());
        System.out.println("Frequency of Each Words in Your Text: " + map.toString());
    }

    private static String inputText() {
    	Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Text or Your File Path: ");
        return sc.nextLine();
    }
}