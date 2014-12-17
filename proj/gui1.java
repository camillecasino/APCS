import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class gui1 extends JFrame implements ActionListener {

    private Container pane;
    private JButton b1;
    private JButton b2;
    private JLabel l;
    private JTextArea t;
    private JPanel canvas;

    private class Canvas extends JPanel {
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.setColor(Color.red);
	    g.fillOval(30,30,30,30);
	}
    }
    /*
    private class Key implements KeyListener {
	public void KeyPressed(KeyEvent e) {}
	public void KeyReleased(KeyEvent e) {}
	public void KeyTyped(KeyEvent e) {}
    }
    */

    public void actionPerformed(ActionEvent e) {
	if (e.getSource() == b1) {
	    System.out.println("You clicked click me");
	    System.out.println("By the way, the text box has " + t.getText());
	} else if (e.getSource() == b2) {
	    System.out.println("Shutting down");
	    System.exit(0);
	}
    }
    
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
	b1.addActionListener(this);
	b2 = new JButton("exit");
	pane.add(b2);
	b2.addActionListener(this);
	t = new JTextArea("  ");
	t.setColumns(30);
	t.setRows(20);
	t.setBorder(BorderFactory.createLineBorder(Color.red,2));
	//t.addKeyListener(Key);
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
