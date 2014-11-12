import java.io.*;
import java.util.*;


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
