import java.io.*;
import java.util.*;

public class Search {

    Comparable[] a;

    public Search(int i) {
	a = new Comparable[i];
	l = i;
    }

    public void add(Comparable c) {
	while (a[i] != null) {
	    i = i + 1;
	}
	if (i < a.length) {
	    a[i] = c;
	} else {
	    l = l + 10;
	    a = new Comparable[l];
	    // creates a new array if the first one isn't long enough
	    // to add another element to it
	}
    }
	    

    public Comparable bsearch(Comparable x) {
        int l = 0, h = a.length-1, m = 0;
        while (h >= l) {
            m = (l + h)/2;
            if (a[m] == x){
                return a[m];
            }
            if (x.compareTo(a[m]) < 0) {
                h = m - 1;
            }
            if (x.compareTo(a[m]) > 0) {
                l = m + 1;
            }
        }
        return null;
    }


}
