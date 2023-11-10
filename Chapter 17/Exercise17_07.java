/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rmazorow
 */
import java.io.*;

public class Exercise17_07 {
    public static void main(String[] args) throws FileNotFoundException {
        Loan loan1 = new Loan();
        Loan loan2 = new Loan(1.8, 10, 10000);
        int total = 0;
        File file = new File("Excercise17_07.dat");
        
        try (
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
        ) {
            output.writeObject(loan1);
            output.writeObject(loan2);
            
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));

            while (true) {
            	//this the programming equilavent of the "immortal until killed" trope
            	total += (((Loan)(input.readObject())).getLoanAmount());
            }
        }
            
        catch (IOException ex) {
            System.out.printf("Total loan amount: %d",total);
        } 
         
        catch (ClassNotFoundException e) {
        	
        	
        }
    }
}
