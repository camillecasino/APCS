public class WordSearch {

    private char[][] board;

    public WordSearch(int r, int c) {
	board = new char[r][c];
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		board[i][j] = '.';
	    }
	}
    }
    public WordSearch() {
	this(20,15);
    }

    public String toString() {
	String s = "";
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		s = s + board[i][j];
	    }
	    s = s + "\n";
	}
	return s;
    }

    public void addWordH(String w,int row, int col){
        boolean write = (col <= 15);
	int r = row, c = col;
	for (int i=0;i<w.length();i++){
	    if (!(board[r][c] == '.' || board[r][c] == w.charAt(i))) {
		write = false;
	    }
	    c++;
	    if (c >= col) {
		write = false;
	    }
	}
	c = col;
	if (write) {
	    for (int i = 0; i < w.length(); i++) {
		board[r][c] = w.charAt(i);
		c++;
	    }
	}
    }

    
}
