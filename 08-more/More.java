public class More {
    
    public String line(String c, int n) {
	String s = "";
	for (int i = 0; i < n; i++) {
	    s = s + c;
	}
	return s;
    }

    public String frame(int r, int c) {
	int mr = 0;
	String s = "";
	s = s + line("*", c) + "\n";
	while (mr < r - 2) {
	    s = s + "*" + line(" ", c - 2) + "*" +  "\n";
	    mr++;
	}
	s = s + line("*", c);
	return s;
    }
}
	  
	
