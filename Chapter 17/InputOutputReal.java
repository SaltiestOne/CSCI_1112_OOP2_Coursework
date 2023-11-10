import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

public class InputOutputReal {

	public static void main(String[] args) {

		try {
			
			File file = new File("Exercise17_03.dat");
		
			java.io.FileOutputStream output = new java.io.FileOutputStream(file);
			
			for (int i = 0; i < 100; i++) {
				
				output.write(new Random().nextInt(77));
				
				output.write(00100000);
				
				/*if (((i + 1) % 5) == 0) {
					
					output.write(00100000);
				} else {
					
					output.write(00100000);
				}*/
				/*this section adds spaces or lines to create lines of 5 ints each. 
				 dunno how to do this in binary, or if it's even necessary.*/
			}
			
			System.out.print(fileSum(file));
		
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		catch (IOException e) {
			
			System.out.print("I/O exception");
		}
	}
	
	public static int fileSum(java.io.File file) throws IOException {
		
		java.io.FileInputStream input = new java.io.FileInputStream(file);
		
		int value = 0;
		
		int sum = 0;
		
		while ((value = input.read()) != -1) {
			
				sum += value;
		}
	
		return sum;
		
	}
}
