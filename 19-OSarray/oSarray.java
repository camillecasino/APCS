public class oSarray extends Sarray {

    String[] data;
    int last;

    public String toString() {
	return super.toString();
   
    }

    public oSarray() {
	data = new String[10];
    }

    //adds an item in the proper index based on the
    //order of the items already there and returns true
    public boolean add(String s) {
	//if the last element in the array precedes s...
	if (data[last].compareTo(s) <= 0 || data[last] == null) {
	    //create new array with s as the last element
	    super.add(s);
	} else {
	    for (int i = 0; i < last; i++) {
		if (data[i].compareTo(s) == 0 || data[i] == null) {
		    super.add(i, s);
		} else {
		    return true;
		}
		return true;
	    }
	}
	return true;
    }
    

    public static void main(String[] args) {
	oSarray os = new oSarray();
	System.out.println(os);
	os.add("hi");
	System.out.println(os);
    }
}
    
