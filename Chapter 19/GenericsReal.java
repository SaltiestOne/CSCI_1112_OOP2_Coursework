
public class GenericsReal {

	public static void main(String[] args) {
		
		Integer[] numbers = {1, 2, 3};
	    System.out.println(max(numbers));
	    
	    String[] words = {"red", "green", "blue"};
	    System.out.println(max(words));
	    
	    Sircle[] sircles = {new Sircle(3), new Sircle(2.9), new Sircle(5.9)};
	    System.out.println(max(sircles));
	  }
	
	public static <E extends Comparable<E>> E max(E[] list) {

		int index = 0;
		
		for (int e = 0; e < list.length; e++) {
			
			if (list[e].compareTo(list[index]) > 0) {
				
				index = e;
			} else {}
		}
		return list[index];
	}
}
//renamed because of coflicts with other objects
class Sircle implements Comparable<Sircle> {
    double radius;
    
    public Sircle(double radius) {
      this.radius = radius;
    }
    
    @Override
    public int compareTo(Sircle c) {
      if (radius < c.radius) 
        return -1;
      else if (radius == c.radius)
        return 0;
      else
        return 1;
    }
    
    @Override
    public String toString() {
      return "Circle radius: " + radius;
    }
  }