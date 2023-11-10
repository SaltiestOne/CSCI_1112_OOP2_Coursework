import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Exercise17dash14 {
	
	public static void main(String[] args) throws IOException {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter name of file to be encrypted: ");
		
		File pitcher = new File(input.next());
	
		if (pitcher.exists()) {
	
			try (RandomAccessFile kile = new RandomAccessFile(pitcher, "rw");) {
					
			System.out.print("Enter file name for new, encrypted file: ");
			
			RandomAccessFile catcher = new RandomAccessFile(new File(input.next()), "rw");
			
			byte ball = 0;
			
			
			for (int i = 0; i < kile.length(); i++) {
				
				kile.seek(i);
				
				ball = (kile.readByte());
				
				ball += 5;
				
				catcher.write(ball);

			}
			
			System.out.print("Your file has been encrypted.");

			} 
	
		
		} else {

			System.out.print("File not found!");
		}
		
	}

}
