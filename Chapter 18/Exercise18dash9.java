import java.util.Scanner;

public class Exercise18dash9 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the String to be reversed:");
		
		reverseDisplay(input.next());
		
	}
	
	public static void reverseDisplay(String value) {
		
		System.out.print(reverseDisplay(value, (value.length() -1)));	
	}
	
	public static String reverseDisplay(String value, int end) {
		
		String result = new String();
		
		if (end == 0) {
			//base case
			result += value.charAt(0);
			
			return result;
		} else {
			//adds the character at the position before asking for the next one
			result += value.charAt(end);
			
			result += reverseDisplay(value, (end - 1));
			
			return result;		
		}

	}

}
