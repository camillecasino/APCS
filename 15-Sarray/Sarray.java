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
	last = 0;
    }

    public void lengthen() {
	if (last >= data.length) {
	    int[] ans = new int[data.length + 10];
	    for (int i = 0; i < data.length; i++) {
		ans[i] = data[i];
	    }
	    data = ans;
	}
    }
    
    public boolean add(int i){
	lengthen();
	data[data.length - 1] = i;
	last = last + 1;
	return true;
        // adds an item to the end of the list, grow if needed
        // returns true
    }

    public void  add(int index, int i){
	lengthen();
	for (int n = lastIndex; n > 0; n--) {
	    if (n > index) {
		data[n] = data[n - 1];
	    } else if (i == index) {
		data[n] = i;
		last = last + 1;
        // adds item i  at index, shifting everything down as needed.
        // also grows as needed
	    }
	}
    }
    
    public int size() {
	return last;
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
