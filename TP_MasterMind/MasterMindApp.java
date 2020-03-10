package java_ex3;

import java.awt.*;
import java.awt.event.*;

public class MasterMindApp implements WindowListener, ActionListener{
	private Frame f;
	private Panel p;
	private Button b;
	private TextField t1;
	private TextField t2;
	private int secret = 1111;
	private int secret1 = 0;
	private int secret2 = 0;
	private int secret3 = 0;
	private int secret4 = 0;
	private int bas1;
	private int bas2;
	private int bas3;
	private int bas4;
	private int score_positif = 0;
	private int score_negatif = 0;
	
	public MasterMindApp() {
		
		
		f = new Frame();
		p = new Panel();
		b = new Button("OK!");
		t1 = new TextField(30);
		t2 = new TextField(40);
		
		p.add(t1);
		p.add(b);
		p.add(t2);
		f.add(p);
		p.setBackground(Color.gray);
		b.addActionListener(this);
		f.addWindowListener(this);
		f.pack();
		f.setSize(400, 200);
		f.setResizable(false);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		MasterMindApp uygulama = new MasterMindApp();
		uygulama.secret = 1111;
		int hepsi_farkli = 0;
		
		while(hepsi_farkli == 0 || (uygulama.secret < 1432 || uygulama.secret > 9876)) {
			uygulama.secret = (int)(Math.random() * 10000);
			uygulama.secret1 = uygulama.secret / 1000;
			uygulama.secret2 = (uygulama.secret / 100) % 10;
			uygulama.secret3 = (uygulama.secret / 10) % 10;
			uygulama.secret4 = uygulama.secret % 10;
			
			if (uygulama.secret1 != uygulama.secret2 && uygulama.secret1 != uygulama.secret3) {
				if (uygulama.secret1 != uygulama.secret4 && uygulama.secret2 != uygulama.secret3) {
					if (uygulama.secret2 != uygulama.secret4 && uygulama.secret3 != uygulama.secret4) {
						hepsi_farkli = 1;
						System.out.println(uygulama.secret);
					}
				}
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		String s = t1.getText();
		try {
			int num = Integer.valueOf(s);
			bas1 = num / 1000;
			bas2 = (num / 100) % 10;
			bas3 = (num / 10) % 10;
			bas4 = num % 10;
			
			if (num < 1432 || num > 9876) {
				t2.setText("Lutfen 1432 ile 9876 arasi bir sayi giriniz.");
			}
			else if (bas1 == bas2 || bas1 == bas3 || bas1 == bas4 || bas2 == bas3 || bas2 == bas4 || bas3 == bas4) {
				t2.setText("Girdiginiz sayinin rakamlari farkli olmak zorunda.");
			}
			else {				
				if (bas1 == secret1) {
					score_positif++;
				}
				else if (bas1 == secret2 || bas1 == secret3 || bas1 == secret4) {
					score_negatif--;
				}
				
				if (bas2 == secret2) {
					score_positif++;
				}
				else if (bas2 == secret1 || bas2 == secret3 || bas2 == secret4) {
					score_negatif--;
				}
				
				if (bas3 == secret3) {
					score_positif++;
				}
				else if (bas3 == secret1 || bas3 == secret2 || bas3 == secret4) {
					score_negatif--;
				}

				if (bas4 == secret4) {
					score_positif++;
				}
				else if (bas4 == secret1 || bas4 == secret2 || bas4 == secret3) {
					score_negatif--;
				}
				
				if (score_positif == 4) {
					t2.setText("Tebrikler, sayiyi bildiniz :)");
				}
				else {
					String score_final = String.valueOf(score_positif) + " " + String.valueOf(score_negatif);
					t2.setText(score_final);
					score_positif = 0;
					score_negatif = 0;
				}
			}
			
		}
		catch (Exception exp) {
			t2.setText("Lutfen bir sayi giriniz...");
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
