public class Driver {
    public static void main(String[] args) {
	WordSearch w = new WordSearch();
	w.addWord("CAMILLE");
	w.addWord("STUYVESANT");
	w.addWord("APCOMPSCI");
	w.addWord("ZAMANSKY");
	w.addWord("HELLOWORLD");
	w.addWord("ULTIMATE");
	w.addWord("FRISBEE");
	w.addWord("COMPUTER");
	w.addWord("HOORAY");
	w.addWord("VOLLEYBALL");
	w.addWord("OUTSIDE");
	w.addWord("MIDDLE");
	w.addWord("WEAKSIDE");
	System.out.println(w);
	w.fillBoard();
	System.out.println(w);
    }
}
