import java.io.*;
import java.util.*;
<<<<<<< HEAD


public class Driver {
    public static void main(String[] args) {

	ArrayList<String> al;
	al = new ArrayList<String>();
	Random r = new Random();
	for (int i = 0; i < 20; i++) {
	    al.add(r.nextInt(5));
	}
	for (int n = 0; n < al.size(); n++) {
	    int d = al[n];
=======
public class Driver {
    public static void main(String[] args) {

	ArrayList<Integer> ai;
	ai=new ArrayList<Integer>();
	Random r = new Random();
	for (int i = 0; i < 20; i++) {
	    ai.add(r.nextInt(5));
	}
	
	System.out.println(ai);
    
	for (int n = 0; n < ai.size() - 1; n++) {
	    int p = ai.get(n);
	    for (int m = n; m < ai.size(); m++) {
		if (ai.get(m + 1) == p) {
		    ai.remove(m + 1);
		}
	    }
	}
	System.out.println(ai);


    }
    
}
>>>>>>> ab97a2ab4c002554196b9998e21158cc76d018cb
