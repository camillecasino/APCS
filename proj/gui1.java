import javax.swing.*;
import java.awt.*;

public class gui1 extends JFrame {

    private Container pane;
    private JButton b1;
    private JButton b2;
    private JLabel l;
    private JTextArea t;
    private JPanel canvas;
    
    public gui1() {
	setTitle("My First Gui");
	setSize(600,600);
	setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = getContentPane();
	pane.setLayout(new FlowLayout());

	l = new JLabel("this is a label");
	pane.add(l);
	b1 = new JButton("Button");
	pane.add(b1);
	b2 = new JButton("exit");
	pane.add(b2);
	t = new JTextArea("  ");
	t.setColumns(30);
	t.setRows(20);
	t.setBorder(BorderFactory.createLineBorder(Color.red,2));
	pane.add(t);

	canvas = new JPanel();
	canvas.setPreferredSize(new Dimension(300,300));
	canvas.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
	pane.add(canvas);
    }
    
    public static void main(String[] args) {
	gui1 f = new gui1();
	f.setVisible(true);
    }
}
