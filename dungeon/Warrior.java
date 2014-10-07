// subclass of BaseChar

public class Warrior extends Basechar {
    private int healthboost = 5;
    private int health = 12345;
    public int getHealth() {
	return health + super.getHealth();
    }

}
