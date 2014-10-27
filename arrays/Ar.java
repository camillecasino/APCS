import java.util.*;

public class Ar {
    private int[] a;
    private Random rnd;
    public Ar(int n) {
	rnd = new random();
	a = new int[n];
    }

    public Ar() {
	this(100);
    }
   
    public String toString() {
	String s;
	for (int i = 0; i < a.length; i++) {
	    s = s + a[i]+ ", ";
	return s;
    }
   
    public static void main(String[] args) {
	Ar as = new Ar();
	System.out.println(as);
    }
    }
}
