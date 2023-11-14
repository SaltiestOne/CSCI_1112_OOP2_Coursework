import java.util.ArrayList;

public class Exercise19dash9 {

	public static void main(String[] args) {

		 ArrayList<Integer> list = new ArrayList<Integer>();
		    list.add(14);
		    list.add(24);
		    list.add(4);
		    list.add(42);
		    list.add(5);
		    sort(list);
		    
		    System.out.print(list);
	}

	
	public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
		
		ArrayList<E> sorter = new ArrayList<E>();

		sorter.add(list.get(0));
		
		for (int e = 1; e < list.size(); e++) {

			if (list.get(e).compareTo(sorter.get((sorter.size() - 1))) < 0) {
				//if entry is smaller than final entry in list, adds to the end of the sorter
				sorter.add(list.get(e));
			} else {
			
				for (int a = 0; a < sorter.size(); a++) {
				//finds the first one that the entry is greater than and adds it at the index
					if (list.get(e).compareTo(sorter.get(a)) > 0) {
						
						sorter.add((a), list.get(e));
						break;
					} else {}
				}
			}
		}
		
		list.clear();
		
		for (int s = 0; s < sorter.size(); s++) {
	
			list.add(sorter.get(s));
		}
	}
}
