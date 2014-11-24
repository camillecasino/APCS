public class Driver {
    public static void main(String[] args) {
	WordSearch w = new WordSearch();
	w.addWord("camille");
	w.addWord("stuyvesant");
	w.addWord("apcompsci");
	w.addWord("zamansky");
	w.addWord("helloworld");
	System.out.println(w);
	w.fillBoard(21, 45);
	System.out.println(w);
    }
}
