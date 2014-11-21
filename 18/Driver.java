public class Driver {
    public static void main(String[] args) {
	WordSearch w = new WordSearch();
	w.addWordHF("hello", 3, 1);
	w.addWordHB("look", 9, 8);
	w.addWordVD("camille", 2, 7);
	w.addWordDUR("apcompsci", 18, 2);
	System.out.println(w);
    }
}
