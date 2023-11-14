import java.util.ArrayList;

public class GenericsFundamental {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
	    list.add(14);
	    list.add(24);
	    list.add(14);
	    list.add(42);
	    list.add(25);
	    
	    ArrayList<Integer> newList = removeDuplicates(list);
	    
	    System.out.print(newList);
	}
	
	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
		
		for (int e = 0; e < list.size(); e++) {
			
			for (int a = (e + 1); a < list.size(); a++) {
				
				if (list.get(e).equals(list.get(a))) {
					
					list.remove(a);
					a--;//to prevent skipping when element is removed
				} else {}		
			}
		}	
		return list;
	}
}