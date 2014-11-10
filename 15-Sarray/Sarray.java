import java.util.*;

public class Sarray {
    int[] data;
    int   last;
    Random r;

    public Sarray(int i) {
        data = new int[i];
	r = new Random();
	for (int n = 0; n < data.length; n++) {
	    data[n] = r.nextInt(10);
	}
    }
    
    public boolean add(int i){
	
        // adds an item to the end of the list, grow if needed
        // returns true
    }

    public void  add(int index, int i){
        // adds item i  at index, shifting everything down as needed.
        // also grows as needed 
    }
    
    public int size() {
	int c = 0;
	for (int i = 0; i < data.length; i++) {
	    if (data[i] < 0 || data[i] > 0 || data[i] == 0) {
		c++;
	    } else {
		c = c;
	    }
	}
	return c;
        // returns the number of items in the list (not the array size)
    }
    /*
    public int get(int index) {
        // returns the item at location index of the lsit
    }

    public int set(int index, int i){
        // sets the item at location index to value i
        // returns the old value. 
    }

    public int remove(int index){
        // removes the item at index i
        // returns the old value
    }
}
    */
}
