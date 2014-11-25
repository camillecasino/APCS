import java.io.*;
import java.util.*;

public class WordSearch {

    private char[][] board;
    private ArrayList<String> words;
    private Random rnd;
    
    /* constructors to set up the board */

    public WordSearch(int r, int c) {
	rnd = new Random();
	words = new ArrayList<String>();

	Scanner sc = null;

	try {
	    sc = new Scanner(new File("words.txt"));
	} catch (Exception e) {
	    System.out.println("Can't open wordlist");
	    System.exit(0);
	}
	    
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

    public void buildPuzzle(int numwords) {
	//	wordBank = new ArrayList<String>();
	for (int i = 0; i < numwords; i++) {
	//while (numwords > 0) {
	    int wordIndex = rnd.nextInt(words.size());
	    String word = words.get(wordIndex);
	    addWord(word);
	    //  if (addWord(word)) {
	    //	numwords--;
	    // }
	}
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


    // east (horizontal left-to-right)
    public void addWordE(String w,int row, int col){
	// set two integers to the row and column parameters
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
	   off the bottom.
	   (keep in mind this specific test is designed for the
	   horizontal write methods ONLY.)
	   
	   by setting write to false, it will halt the process of
	   writing the word. you can see this in the way that "write"
	   is implemented in the end of the method.
	 */
	if (r >= 21) {
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

	    for (int i = 0; i < w.length(); i++) {
		// determines if the word will run off the side
		// of the board
		if (c >= 45){
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
	    if (write) {
		// now we just run through every letter and add it.
		for (int i = 0; i < w.length(); i++) {
		    board[r][c] = w.charAt(i);
		    // we don't want to change r because all the
		    // letters of the word should be in the same
		    // row (hence the horizontal). we do, however,
		    // want to keep moving across the columns and
		    // putting letters in as we go.
		    c++;
		}
	    }
	}
    }

    // west (horizontal right-to-left)
    public void addWordW(String w, int row, int col) {
	/*
	  originally, this was quite literally a copy-paste
	  version of the addWordE method. I decided to just
	  implement it so that it would not take up as much
	  space. the only difference is the way the word is
	  printed on the board. since english is read
	  conventionally from left to right, one could say
	  that the word is printed "backwards."
	  this could probably be achieved by using c-- or
	  something of the type, but if we think about the
	  "backwards" word as the reversed version of the
	  "correct" or "forwards" word, we can use addWordE.
	  basically, we just have addWordE print out the
	  reversed version of our string.
	  ex: when addWordE takes "camille" as a parameter,
	  it will print out "camille" exactly. but when
	  addWordW takes "camille" as a parameter, it just
	  puts "ellimac" (the reversed version of "camille")
	  into addWordE, which doesn't see the difference and
	  is still essentially printing it out "forwards,"
	  since we are still advancing in each column.
	 */
	String newWord = new StringBuffer(w).reverse().toString();
	w = newWord;
	addWordE(w, row, col);
    }
    
    // South (vertical top-to-bottom)
    public void addWordS(String w,int row, int col) {
	int r = row, c = col;
	boolean write = true;

	/*
	  this time, we're checking to see if the word will write
	  in a column that's off the side of the board since the
	  word will be written vertically.
	 */
	if (c >= 45) {
	    write = false;
	} else {
	    for (int i = 0; i < w.length(); i++) {
		// checks if the word will write off the bottom of
		// the board
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
		for (int i = 0; i < w.length(); i++) {
		    board[r][c] = w.charAt(i);
		    // this is the main difference between the horizontal
		    // methods and the vertical methods: we need to keep
		    // all of the letters in the word in the same column,
		    // and shift down the rows to add the next letter.
		    // therefore, we use r++ instead.
		    r++;
		}
	    }
	}
    }

    // north (vertical bottom-to-top)
    public void addWordN(String w,int row, int col){
	String newWord = new StringBuffer(w).reverse().toString();
	w = newWord;
	addWordS(w, row, col);
    }

    // southeast (diagonal left-to-right, top-to-bottom)
    public void addWordSE(String w, int row, int col) {
	int r = row, c = col;
	boolean write = true;

	/*
	  in the previous methods, I took one of the tests out of
	  the for loop for the sake of time and overall efficiency.
	  I was justified to do this because in the horizontal and
	  vertical methods, the words only remained on one plane:
	  either left/right or up/down. for the horizontal write
	  methods, the value for r was the same for each letter.
	  for the vertial write methods, the value for c was the
	  same for each letter. however, in the diagonal methods,
	  this will change. because the words will be written in
	  diagonally, both the r and c values change for each
	  letter.
	 */
	for (int i = 0; i < w.length(); i++) {
	    // check if the word will run off the board by exceeding
	    // the number of columns that the board has
	    if (c >= 45){
		write = false;
		break;
   	    }
	    
	    // check if the word will run off the board by exceeding
	    // the number of rows that the board has
	    if (r >= 21){
		write = false;
		break;
	    }

	    if (!(board[r][c] == w.charAt(i) || board[r][c] == '.')){
		write = false;
	    }
	    // we have to manipulate both for diagonal. since the word
	    // will be going to the right and down, we add 1 to the row
	    // value and 1 to the column value.
	    r++;
	    c++;
	}
	
	// reset both integers
	r = row;
	c = col;
	if (write) {
	    for (int i = 0; i < w.length(); i++) {
		board[r][c] = w.charAt(i);
		//shift the next letter down by one row
		r++;
		
		// shift the next letter to the right by
		// one column
		c++;
	    }
	}
    }

    // northwest (diagonal right-to-left, bottom-to-top)
    public void addWordNW(String w, int row, int col) {
	String newWord = new StringBuffer(w).reverse().toString();
	w = newWord;
	/*
	  the reverse direction of southeast is northwest.
	  this works by adding 1 to r and 1 to c, except
	  this time, the word is backwards.
	  this makes it so that the beginning of the word
	  is the rightmost, bottommost letter. therefore,
	  the word is pointing northwest.
	 */
	addWordSE(w, row, col);

    }
    
    // northeast (diagonal left-to-right, bottom-to-top)
    public void addWordNE(String w, int row, int col) {
	int r = row, c = col;
	boolean write = true;

	/*
	  in this case, the tests are a little different. the
	  first letter of the word is towards the left and
	  bottom. just like the others, we need to make sure
	  that the word doesn't go off the edge/side of the
	  board. however, since we are using r--, we also have
	  to make sure that the word doesn't go off the edge
	  or the TOP of the board (aka r becoming less than 0,
	  which is the top row because of zero-based
	  indexing.)
	 */
	for (int i = 0; i < w.length(); i++) {
	    if (c >= 45){
		write = false;
		break;
	    }
	    if (r < 0 || r >= 21) {
		write = false;
		break;
	    }
	    if (!(board[r][c] == w.charAt(i) || board[r][c] == '.')){
		write = false;
	    }
	    // we subtract 1 from r in order to shift the next
	    // letter up by one row.
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
 
    // southwest (diagonal right-to-left, top-to-bottom)
    public void addWordSW(String w, int row, int col) {
	String newWord = new StringBuffer(w).reverse().toString();
	w = newWord;
	addWordNE(w, row, col);
    }

    public boolean addWord(String w) {
        // set up a new random generator
	Random rn = new Random();
	
	// these two will give random numbers, each within
	// the range that the # of rows and columns sets.
	int r = rn.nextInt(21);
	int c = rn.nextInt(45);
	
	// the next random number determines how the word will
	// be written, aka which orientation.
	int o = rn.nextInt(7);

	// we want to make the constructor try to put a word
	// in the board five times. however, we don't want to
	// make it do it five times - we want it to stop if
	// the word writes. the for loop will have this five-time
	// limit and also will return true if it follows through.
	for (int i = 0; i < 6; i++) {
	    if (o == 0) {
		addWordN(w, r, c);
	    } else if (o == 1) {
		addWordS(w, r, c);
	    } else if (o == 2) {
		addWordE(w, r, c);
	    } else if (o == 3) {
		addWordW(w, r, c);
	    } else if (o == 4) {
		addWordNE(w, r, c);
	    } else if (o == 5) {
		addWordNW(w, r, c);
	    } else if (o == 6) {
		addWordSE(w, r, c);
	    } else {
		addWordSW(w, r, c);
	    }
	}
	// this boolean will tell us if the word was
	// successfully written in because if the
	// character at the place we supposedly began
	// the word is still a '.', then the word
	// was not written.
	if (board[r][c] == '.') {
	    return false;
	} else {
	    return true;
	}
    }

    // this accessory method is just here to fill the board
    // with letters just as a regular word search looks.
    public void fillBoard() {
	Random rn = new Random();
	String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		// generate a random integer out of a set of 26
		int let = rn.nextInt(26);
		// this is basically the same way we filled the array
		// in the beginning, except instead of dots, it's
		// random letters/characters. the first statement
		// underneath this is just a check of whether the space
		// it's about to fill has a . or a letter from a
		// previously placed word in there. if there is, then
		// the method is told to just let that space be and move
		// on to the next one. otherwise, that space will be
		// assigned a random letter.
		if (board[i][j] == '.' || board[i][j] == s.charAt(let)) {
		    board[i][j] = s.charAt(let);
		} else {
		    board[i][j] = board[i][j];
		}
	    }
	}		
    }
    
    // end   
}

