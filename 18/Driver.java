public class Driver {
    public static void main(String[] args) {
	WordSearch w = new WordSearch();
	w.addWordH("hello", 3, 14);
	w.addWordH("look", 3, 8);
	System.out.println(w);
    }
}
