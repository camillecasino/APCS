// superclass of Warrior and Mage

public class Basechar {
    private int health = 20;
    private String name;
    
    public String toString() {
	return this.getName();
    }

    public void attack(Basechar other) {
	//System.out.println(this.getName() + " is attacking " + other.getName());
	System.out.println(this + " is attacking " + other);
    }

    public void setName(String name) {
	this.name = name;
    }

    //this. refers to the instance of the class you are using

    public String getName() {
	return name;
    }

    public int getHealth() {
	return health;
    }

    public void baseSetHealth(int i) {
	health = i;
    }
}

