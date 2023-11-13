import java.util.Scanner;

public class RecursionFundamental {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Today, we will be finding the Greatest Common Devisor " + 
				"of two integers.\nEnter the first integer: ");
		
		int a = input.nextInt();
		
		System.out.print("Enter the second integer: ");
		
		int b = input.nextInt();
		
		System.out.printf("The Greatest Common Divisor of %d and %d is %d.",
				a, b, geeSeeDee(a, b));
	}
	
	public static int geeSeeDee(int m, int n) {
		
		if ((m % n) == 0) {
			
			return n;
		} else {
			
			return geeSeeDee(n, (m % n));
		}
	}
}
