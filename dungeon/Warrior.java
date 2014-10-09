// subclass of BaseChar

public class Warrior extends Basechar {
    private int healthboost = 5;
    public Warrior(String n) {
	// calls the super classes zero param constructor
	// even if you don't write this,
	// the super constructor will always be called
	// as the first line of a subclass' constructor
	super();
	setName(n);
    }
    
    public void attack(Basechar other) {
	System.out.println(this.getName() + " is super attacking " + other.getName());
    }
    private int health = 12345;
    public int getHealth() {
	return health + super.getHealth();
    }

}
