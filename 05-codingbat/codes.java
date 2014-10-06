public class StringStuff {

    public String nonStart (String a, String b) {
	return a.substring(1) + b.substring (1);
    }

    public int diff21(int n) {
	if (n < 21) {
	    return Math.abs(n - 21);
	}
	return Math.abs((21 - n) * 2);
    }





//lab problems; worked with kevin mejia

//working
    public boolean nearHundred(int n) {
        return (Math.abs(n - 100) <= 10)) || (Math.abs(n - 200) <= 10);
}

//working
    public boolean mixStart(String str) {
	 if (str.length() < 3)
	    return false;
	String str2 = str.substring(1, 3);
	return(str2.equals("ix"));
}

    public int teaParty(int tea, int candy) {
        if ((tea>=(2 * candy) || candy>=(2 *tea)) && ((tea >= 5)  && (candy >=5)))  {
	    return 2  ;
	}
        if ((tea >= 5)  && (candy >=5)) {
	    return 1;
	}   else { 
	    return 0;
	}
     
    }
    public boolean lastDigit(int a, int b, int c) {
        return (a % 10 == b % 10) || (a % 10 == c % 10) || (b % 10 == c % 10);
    }

}
