public class WordSearch {

    private char[][] board;
    
    /* constructors to set up the board */

    public WordSearch(int r, int c) {
	board = new char[r][c];
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		board[i][j] = '.';
	    }
	}
    }
    public WordSearch() {
	this(21, 45);
    }

    /* the lovely toString(), as usual */

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
    



    /*
     to avoid confusion with the reverse horizontal and the majority of
     the diagonal methods and such, each method is named after the
     direction that the word "points" to, with the first letter of the
     word supposedly starting in the center of the imaginary compass.
    */


    /* word placement methods */


    //east (horizontal left-to-right)
    public void addWordE(String w,int row, int col){
	int r = row, c = col;
	/*
	  the boolean "write" is what determines whether or not we
	  can follow through with writing the word in.

	  it starts as true, meaning we will begin under the assumption
	  that we can write the word into the board.
	*/
	boolean write = true;


	/* 
	   this test just checks if the word will run off the bottom
	   of the board. originally, greg and I had it inside the
	   for loop, but I decided that it would waste time to check
	   it every time we looped through, as the horizontal words
	   stay in the same row throughout all their letters anyway.
	   of course, we shouldn't even waste our time following
	   through with the other tests if we can already determine
	   if the word can't be written by checking if it will run
	   off the bottom. (keep in mind this specific test is
	   designed for the horizontal write methods ONLY.)
	   
	   by setting write to false, it will halt the process of
	   writing the word. you can see this in the way that "write"
	   is implemented in the end of the method.
	 */

	if (r >= 19){
		write = false;
	} else {

	    /*
	      now that we've determined that the word will stay
	      on the board in terms of the correct row (aka not
	      out-of-bounds), we can test everything else.

	      these other tests are designed to stop the method
	      from writing in the word if we can't put it in the
	      board.
	      
	      once again, they can do this by
	      setting the boolean "write" to false.
	    */

	    for(int i=0;i<w.length();i++){
		// determines if the word will run off the side
		// of the board
		if (c >= 29){
		    write = false;
		    break;
		}

		// determines if the next letter in the word will
		// clash with a character already placed there,
		// or if the board space doesn't have a '.' in it
		if (!(board[r][c] == w.charAt(i) || board[r][c] == '.')){
		    write = false;
		}

		/* 
		   this continues the test for each letter
		   of the word. we need c++ because we can't
		   just check the beginning of the word -
		   this method writes words horizontally, so
		   each letter will be written into the next
		   column. this means that there is a chance
		   we'll get a word writing off the side of
		   the board, aka past the number of columns
		   that the board has.
		*/
		c++;
	    }

	    /*
	      we have to reset c to be equal to the original
	      parameter given, because we essentially maxed
	      it out to the value of the letter at the end
	      of the word to check if it would write off the
	      edge of the board.
	    */
	    c = col;

	    // here's where we implement "write."
	    // if string w passed all of the tests, then "write"
	    // should be untouched, considering the fact that we
	    // set it as true in the very beginning.
	    if (write){
		//now we just run through every letter and add it.
		for (int i = 0; i < w.length(); i++) {
		    board[r][c] = w.charAt(i);
		    c++;
		}
	    }
	}
    }

    //west (horizontal right-to-left)
    public void addWordW(String w, int row, int col) {
	/*
	  originally, this was quite literally a copy-paste
	  version of the addWordE method. I decided to just
	  implement it so that it would not take up as much
	  space. the only difference is that we need to
	  reverse the string, so it prints "backwards."
	  basically, we just have addWordE print out the
	  reversed version of our string.
	  ex: when addWordE takes "camille" as a parameter,
	  it will print out "camille" exactly. but when addWordW
	  takes "camille" as a parameter, it just puts
	  "ellimac" into addWordE, which doesn't see the difference
	  and is still essentially printing it out "forwards,"
	  since we are still advancing in each column.
	 */
	String newWord = new StringBuffer(w).reverse().toString();
	w = newWord;
	addWordE(w, row, col);
    }
    
    //South (vertical top-to-bottom)
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

     public void addWordDUNW(String w, int row, int col) {
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
    

     public void addWordDUNE(String w, int row, int col) {
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

