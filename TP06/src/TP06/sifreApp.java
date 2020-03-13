package TP06;

import java.awt.*;
import java.awt.event.*;

public class sifreApp implements WindowListener, ActionListener{
	private Frame f;
	private Panel p;
	private Button b1;
	private Button b2;
	private TextArea ta1;
	private TextArea ta2;
	private String alfabe = new String();
	private String anahtar = new String();
	
	public sifreApp() {
		f = new Frame();
		p = new Panel();
		b1 = new Button("Sifrele");
		b2 = new Button("Sifreyi coz");
		ta1 = new TextArea(10, 30);
		ta2 = new TextArea(10, 30);
		
		p.add(ta1);
		p.add(b1);
		
		p.add(ta2);
		p.add(b2);
		
		f.add(p);
		p.setBackground(Color.gray);
		b1.addActionListener(this);
		b2.addActionListener(this);
		f.addWindowListener(this);
		f.pack();
		f.setSize(600, 400);
		f.setResizable(false);
		f.setVisible(true);
		
		int randint = 0;
		alfabe = "abcdefghijklmnopqrstuvwyz";
		System.out.println(alfabe);
		
		for (int d = 0; d < 25; d++) {
			randint = (int)(Math.random() * (25 - d));
			anahtar = anahtar + alfabe.substring(randint, randint + 1);
			alfabe = alfabe.substring(0, randint) + alfabe.substring(randint + 1);
		}

		alfabe = "abcdefghijklmnopqrstuvwyz";
		System.out.println(anahtar);
	}

	public static void main(String[] args) {
		sifreApp uygulama = new sifreApp();
	}
	
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		String metin = new String();
		String sifreli_metin = new String();
		char c_tmp;
		
		if (s == "Sifrele") {
			metin = ta1.getText();
			sifreli_metin = "";
			try {
				for (int d = 0; d < metin.length(); d++) {
					c_tmp = metin.charAt(d);
					c_tmp = anahtar.charAt(alfabe.indexOf(c_tmp));
					sifreli_metin = sifreli_metin + Character.toString(c_tmp);
				}
				
				ta2.setText(sifreli_metin);
			}
			catch(Exception e1){}
		}
		
		else if (s == "Sifreyi coz") {
			sifreli_metin = ta2.getText();
			metin = "";
			try {
				for (int d = 0; d < sifreli_metin.length(); d++) {
					c_tmp = sifreli_metin.charAt(d);
					c_tmp = alfabe.charAt(anahtar.indexOf(c_tmp));
					metin = metin + Character.toString(c_tmp);
				}
				
				ta1.setText(metin);
			}
			catch(Exception e1){}
		}
	}
	
	public void windowOpened(WindowEvent e) {}
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	public void windowClosed(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}

}