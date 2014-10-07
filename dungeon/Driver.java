public class Driver {
    public static void main(String[] args) {
	BaseChar c = new BaseChar();
	
	System.out.println(c.getHealth());

	Warrior w = new Warrior();

	System.out.println(w.getHealth());
    }
}
