public class Sarray {
    
    //worked with Leon on Friday
    String[] data; // should be object[]
    int last; //last index of the list

    public String toString(){
	String f = ""; 
	for (int a = 0; a < data.length; a++) {
    	    f = f + data[a]+", ";
	}
	f = f + "\n";
	int count = -1;
	for (int a = 0; a < data.length; a++) {
	    if (data[a]!=null){
		count = a;
	    }
	}
	last = count;	
	f = f + "last: "+last;
	f = f + "\n";
	return f;
    }

    public Sarray() {
	data = new String[10];
    }

    //adds an item to the end of the list, grow if needed, returns true
    public boolean add(String s) {
	if (last == data.length-1){
	    //create a new array with i as the last added element
	    String[] newArray = new String[data.length+1];
	    for (int a = 0; a < data.length; a++) {
		newArray[a]=data[a];
	    }
	    newArray[newArray.length - 1] = s;
	    data = newArray;
	    last++;
	} else {
	    data[last+1]=s;
	    last++;
	}
	return true;
    }

    //adds item s at index, shifting everything down as needed
    //also grows as needed
    public void add(int index, String s) {
    	// inserts at location index - shift everything else down
    	String[] newArray;
	if (index < data.length) {
	    newArray = new String[data.length+1];
	    for (int a = 0; a < newArray.length; a++) {
		if (a < index) {
		    newArray[a] = data[a];
		}
		if (a == index) {
		    newArray[a] = s;
		}
		if (a > index) {
		    newArray[a] = data[a - 1];
		}
	    }
	} else {
	    newArray = new String[index+1];
	    for (int a = 0; a < data.length; a++) {
		newArray[a] = data[a];
	    }
	    newArray[index] = s;
	}
    	data = newArray;
    }

    //return the number of items in the list (different from array size!!)
    public int size(){
    	int count = 0;
    	for (int a=0;a<data.length;a++){
    	    if (data[a] != null){
    		count++;
    	    } else {
		count = count;
	    }
    	}
    	return count;
    }

    //returns the item at location index of the list
    public String get (int index) {
    	return data[index];
    }
    
    // sets the item at locaiton index to string s
    //returns the old value
    public String set (int index, String s) {
    	if (index > data.length){
    	    throw new ArrayIndexOutOfBoundsException();
	}
    	String f = data[index];
    	data[index] = s;
    	return f;
    }
        
    //removes the item at index index
    //returns the old value 
    public String remove(int index){
    	String f = data[index];
        String[] newArray = new String[data.length-1];
    	int a = 0;
    	for (a = a; a < index; a++) {
	    newArray[a] = data[a];
	}
    	for (a = a; a < newArray.length; a++) {
	    newArray[a] = data[a + 1];
	}
    	data = newArray;
    	return f;
    }

    // INSERTION SORT CODE

    public void isort() {
	String n;
	for (int j = 0; j < data.length; j++) {
	    n = data[j];
	    int i;
	    for (i = last; i > 0 && n.compareTo(data[i - 1]) < 0; i++) {
		data[i] = data[i - 1];
	    }
	    data[i] = n;
	}
    }

    public void ssort() {
	String n;
	for (int i = data.length - 1; i > 0; i--) {
	    String max = data[i];
	    for (int j = 0; j < data.length - i; j++) {
		if (data[j].compareTo(data[i]) > 0) {
		    max = data[j];
		}
	    }
	    data[i] = max;
	}
    }
     
    public static void main(String[] args) {
	Sarray s = new Sarray();
	System.out.println(s);
	s.add("c");
	s.add("a");
	s.add("m");
	s.add("i");
	s.add("l");
	s.add("L");
	s.add("e");
	s.add("stuy");
	s.add("volleyball");
	s.add("ultimate");
	s.ssort();
	System.out.println(s);
    }
    
}
