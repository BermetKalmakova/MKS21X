import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Temp extends JFrame implements ActionListener{
    private Container pane;
    private JLabel j;
    private JTextField t;

    public Temp(){
	this.setTitle("Temp converter");
	this.setSize(400,300);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
	JButton b = new JButton("FtoC");
	b.addActionListener(this);
	b.setActionCommand("FtoC");
	JButton b2 = new JButton("CtoF");
	b2.addActionListener(this);
	b2.setActionCommand("CtoF");
	t = new JTextField(10);
	j = new JLabel("");
	pane.add(t);
	pane.add(b);
	pane.add(b2);
	pane.add(j);
    }

    public static double CtoF(double x){
	return (x*(9.0/5)) + 32;
    }

    public static double FtoC(double x){
	return (x-32) * (5.0/9);
    }

    public void actionPerformed(ActionEvent e){
	String event = e.getActionCommand();
	if(event.equals("FtoC")){
	    String s = t.getText();
	    s = "" + FtoC(Double.parseDouble(s));
	    j.setText(s);
	}
	if(event.equals("CtoF")){
	    String s = t.getText();
	    s = "" + CtoF(Double.parseDouble(s));
	    j.setText(s);
	}
    }
    public static void main(String[] args){
	Temp g = new Temp();
	g.setVisible(true);
    }
}
