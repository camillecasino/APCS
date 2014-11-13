import java.io.*;
import java.util.*;
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
