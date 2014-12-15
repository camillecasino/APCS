import javax.swing.*;
import java.awt.*;

public class gui1 extends JFrame {

    public gui1() {
	setTitle("My First Gui");
	setSize(400,600);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
	gui1 f = new gui1();
	f.setVisible(true);
    }
}
