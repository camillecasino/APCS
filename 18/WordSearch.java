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

     public void addWordHF(String w,int row, int col){
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
	    c++;
	}
	c = col;
	if (write){
	    for (int i=0;i<w.length();i++){
		board[r][c] = w.charAt(i);
		c++;
	    }
	}
	
    }

    public void addWordHB(String w,int row, int col){
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
	    c++;
	}
	c = col;
	if (write){
	    for (int i=0;i<w.length();i++){
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

    public void addWordDRD(String w, int row, int col) {
	int r = row;
	int c = col;
	boolean write = true;

	for (int i = 0; i < w.length(); i++) {
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
	    c++;
	}
	
	r = row;
	c = col;
	if (write) {
	    for (int i = 0; i < w.length(); i++) {
		board[r][c] = w.charAt(i);
		r++;
		c++;
	    }
	}
    }

     public void addWordDLD(String w, int row, int col) {
	String newWord = new StringBuffer(w).reverse().toString();
	w = newWord;
	int r = row;
	int c = col;
	boolean write = true;

	for (int i = 0; i < w.length(); i++) {
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
	    c++;
	}
	
	r = row;
	c = col;
	if (write) {
	    for (int i = 0; i < w.length(); i++) {
		board[r][c] = w.charAt(i);
		r++;
		c++;
	    }
	}
    }

     public void addWordDUR(String w, int row, int col) {
	int r = row;
	int c = col;
	boolean write = true;

	for (int i = 0; i < w.length(); i++) {
	    if (c < 0){
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
	    r--;
	    c++;
	}
	
	r = row;
	c = col;
	if (write) {
	    for (int i = 0; i < w.length(); i++) {
		board[r][c] = w.charAt(i);
		r--;
		c++;
	    }
	}
    }
    
}

