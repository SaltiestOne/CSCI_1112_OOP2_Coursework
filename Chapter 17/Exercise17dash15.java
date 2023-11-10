import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Exercise17dash15 {
	
	public static void main(String[] args) throws IOException {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter name of file to be unencrypted: ");
		
		File catcher = new File(input.next());
	
		if (catcher.exists()) {
	
			try (RandomAccessFile kile = new RandomAccessFile(catcher, "rw");) {
					
			System.out.print("Enter file name for new, unencrypted file: ");
			
			RandomAccessFile pitcher = new RandomAccessFile(new File(input.next()), "rw");
			
			byte ball = 0;
			
			for (int i = 0; i < kile.length(); i++) {
				
				kile.seek(i);
				
				ball = (kile.readByte());
				
				ball -= 5;
				
				pitcher.write(ball);

			}
			
			System.out.print("Your file has been unencrypted.");

			} 
	
		
		} else {

			System.out.print("File not found!");
		}
		
	}
}
