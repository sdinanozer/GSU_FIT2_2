package TP06;

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class RomanNum {
	
	
	public static void main(String[] args) {
		int sayi_in = 0;
		int exit = 0;
		
		while (exit != 1) {
			try {
				Scanner user_in = new Scanner(System.in);
				sayi_in = user_in.nextInt();			
				if (sayi_in >= 1 && sayi_in <= 3999) {
					System.out.println("Sayiniz: " + sayi_in); 
					System.out.println("Roma rakami ile: " + romanNum(sayi_in));
					System.out.println("Cikmak icin 0 (sifir) girin.");
				}
				else {
					System.out.println("Lutfen 1 ile 3999 arasi bir sayi giriniz.");
				}
			}
			catch(Exception e) {
				System.out.println("Lutfen bir sayi giriniz.");
			}
			
		}
		
	}
	
	public static String romanNum(int sayi) {
		String roman = new String();
		
		int binler = sayi / 1000;
		int yuzler = (sayi / 100) % 10;
		int onlar = (sayi / 10) % 10;
		int birler = sayi % 10;
		
		//Binler bas.
		for (int d = 0; d < binler; d++) {
			roman = roman + "M";
		}
		
		//Yuzler bas.
		if (yuzler == 9) {
			roman = roman + "CM";
			yuzler -= 9;
		}
		else if (yuzler >= 5) {
			roman = roman + "D";
			yuzler -= 5;
		}
		else if (yuzler == 4) {
			roman = roman + "CD";
			yuzler -= 4;
		}
		
		for (int d = 0; d < yuzler; d++) {
			roman = roman + "C";
		}
		
		//Onlar bas.
		if (onlar == 9) {
			roman = roman + "XC";
			onlar -= 9;
		}
		else if (onlar >= 5) {
			roman = roman + "L";
			onlar -= 5;
		}
		else if (onlar == 4) {
			roman = roman + "XL";
			onlar -= 4;
		}
		
		for (int d = 0; d < onlar; d++) {
			roman = roman + "X";
		}
		
		//Birler bas.
		if (birler == 9) {
			roman = roman + "IX";
			birler -= 9;
		}
		else if (birler >= 5) {
			roman = roman + "V";
			birler -= 5;
		}
		else if (birler == 4) {
			roman = roman + "IV";
			birler -= 4;
		}
		
		for (int d = 0; d < birler; d++) {
			roman = roman + "I";
		}
		
		return roman;
	}
	
}