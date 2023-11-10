
import java.util.Random;

public class InputOutputFundamental {

	public static void main(String[] args) throws Exception {
		
		java.io.File file = new java.io.File("Exercise17_01.txt");
		
		writeNumbers(file);
	}
	
	public static void writeNumbers(java.io.File file) throws Exception {
		
		try (	
				java.io.PrintWriter output = new java.io.PrintWriter(file);
		) {

			for (int i = 0; i < 100; i++) {
				
				output.printf("%2d",new Random().nextInt(77));
				
				if (((i + 1) % 5) == 0) {
					
					output.println();
				} else {
					
					output.print(" ");
				}
			}
			
		}
	}
	
}