package TP06;

import java.awt.*;
import java.awt.event.*;

public class kurCevir implements WindowListener, ActionListener{
	private Frame f;
	private Panel p;
	private Button b1;
	private Button b2;
	private TextField t1;
	private TextField t2;
	private Label l1 = new Label("TL:");
	private Label l2 = new Label("$:");
	private double Dolar_to_TL = 6.17;
	private double TL_to_Dolar = 0.16;
	
	public kurCevir() {
		f = new Frame();
		p = new Panel();
		b1 = new Button("$'a cevir");
		b2 = new Button("TL'ye cevir");
		t1 = new TextField(35);
		t2 = new TextField(30);
		
		p.add(l1);
		p.add(t1);
		p.add(b1);
		
		p.add(l2);
		p.add(t2);
		p.add(b2);
		
		f.add(p);
		p.setBackground(Color.gray);
		b1.addActionListener(this);
		b2.addActionListener(this);
		f.addWindowListener(this);
		f.pack();
		f.setSize(400, 200);
		f.setResizable(false);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		kurCevir uygulama = new kurCevir();
	}
	
	public void actionPerformed(ActionEvent e) {
		String s_TL = t1.getText();
		String s_Dolar = t2.getText();
		String s = e.getActionCommand();
		
		if (s == "$'a cevir") {			
			try {
				double num1 = Double.valueOf(s_TL);
				num1 *= TL_to_Dolar;
				s_TL = String.valueOf(num1);
				t2.setText(s_TL);
			}
			catch (Exception exp) {
				t1.setText("Lutfen bir sayi giriniz.");
			}
		}
		
		else if (s == "TL'ye cevir") {			
			try {
				double num2 = Double.valueOf(s_Dolar);
				num2 *= Dolar_to_TL;
				s_Dolar = String.valueOf(num2);
				t1.setText(s_Dolar);
			}
			catch (Exception exp) {
				t2.setText("Lutfen bir sayi giriniz.");
			}
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
