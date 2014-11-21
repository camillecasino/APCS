public class Driver {
    public static void main(String[] args) {
	Sarray c = new Sarray(10);
	System.out.println("Here's the array: " + c.toString());
	System.out.println("The size is " + c.size());
	System.out.println("Grab the element at index three: " + c.get(3));
	System.out.println("Print out of bounds error: " + c.set(11, 100));
    }
}
