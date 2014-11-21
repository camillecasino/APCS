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

    public void addWordVD(String w,int row, int col){
	int r = row, c = col;
	boolean write = true;

	for(int i=0;i<w.length();i++){
	    if (c >= 29){
		write = false;
		break;
	    }
	    if (r >= 19){
		write = false;
		break;
	    }
	    if (!(board[r][c] == w.charAt(i) || board[r][c] == '.')){
		write = false;
	    }
	    r++;
	}
	r = row;
	if (write){
	    for (int i=0;i<w.length();i++){
		board[r][c] = w.charAt(i);
		r++;
	    }
	}
	
    }


    public void addWordVU(String w,int row, int col){
	String newWord = new StringBuffer(w).reverse().toString();
	w = newWord;

	int r = row, c = col;
	boolean write = true;

	for(int i=0;i<w.length();i++){
	    if (c >= 29){
		write = false;
		break;
	    }
	    if (r >= 19){
		write = false;
		break;
	    }
	    if (!(board[r][c] == w.charAt(i) || board[r][c] == '.')){
		write = false;
	    }
	    r++;
	}
	r = row;
	if (write){
	    for (int i=0;i<w.length();i++){
		board[r][c] = w.charAt(i);
		r++;
	    }
	}

    
    }
}
