import java.io.*;
import java.util.*;

class Interval implements Comparable {

    private int low,high;
    private static Random r = new Random();				
    private static int numIntervals = 0;
		
    public Interval(int l, int h){
	low = l;
	high = h;
	numIntervals = numIntervals + 1;
    }
		
    public Interval() {
	int l = r.nextInt(100);
	int h = l + 1 + r.nextInt(100);
	low = l;
	high = h;
	numIntervals = numIntervals + 1;
    }

    public String toString() {
	//String s = "Interval: "+numIntervals+": "+ "["+low+","+high+"]";
	String s = "["+low+","+high+"]";

	return s;
    }

    public static void printstuff() {
	System.out.println("Stuff");
    }

    public int compareTo(Object other) {
	// cast other to the appropriate type
	// and store in a local variable
	Interval o = (Interval)other;
	
	if (this.low == o.low) {
	    return this.high - o.high;
	} else {
	    return this.low - o.low;
	}
    }


    /* 
       Interface: a specification that lists methods

       interface <name> {
           method 1 signature;
	   method 2 signature;
       }

       method sig: public or private type
       name (params);

       a class that implements an interface must define ALL
       the methods in the interface.
       you can only extend one class but you can implement
       multiple interfaces.
       interface Comparable {
           public int compareTo(object other);
       }
     */
    
    public static void main(String[] args) {

	Interval ival = new Interval();
	/*
	ival.printstuff(); // normal calling off of an instance
	printstuff(); // since printStuff is static we can call it without an instance
	Interval.printstuff(); // we can also call it right off a class
	*/
	Interval[] a = new Interval[10];
	for (int i = 0; i < a.length; i++) {
	    a[i] = new Interval();
	}
	System.out.println(Arrays.toString(a));
	Arrays.sort(a);
	System.out.println(Arrays.toString(a));
	
    }
}
