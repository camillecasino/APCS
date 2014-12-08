import java.io.*;
import java.util.*;

public class Sarrayint {

    int[] data;
    int last;

    public String toString() {
	String f = "";
	for (int a = 0; a < data.length; a++) {
    	    f = f + data[a]+", ";
	}
	f = f + "\n";
	int count = -1;
	for (int a = 0; a < data.length; a++) {
	    if (data[a]!=0){
		count = a;
	    }
	}
	last = count;	
	f = f + "last: "+last;
	f = f + "\n";
	return f;
    }

    public Sarrayint() {
	data = new int[10];
    }

    public boolean add(int i) {
	if (last == data.length-1){
	    //create a new array with i as the last added element
	    int[] newArray = new int[data.length+1];
	    for (int a = 0; a < data.length; a++) {
		newArray[a]=data[a];
	    }
	    newArray[newArray.length - 1] = i;
	    data = newArray;
	    last++;
	} else {
	    data[last+1]=i;
	    last++;
	}
	
	return true;
    }


     // BUBBLE SORT
    public void bsort() {
	String n;
	String m;
	for (int i = 0; i < data.length - 1; i++) {
		if (data[i].compareTo(data[i + 1]) > 0) {
		    n = data[i];
		    m = data[i + 1];
		    data[i + 1] = n;
		    data[i] = m;
		}
	    
	}
    }

    // CODE TO FOR COMPARISON (JAVA'S BUILT-IN SORT METHOD)
    public void jsort() {
	Arrays.sort(data);
    }
    
    
    // MAIN METHOD

    public static void main(String[] args) {
	Sarrayint si = new Sarrayint();
	System.out.println(si);
	si.add(5);
	si.add(7);
	si.add(1);
	si.add(88);
	System.out.println(si);
    }
}
