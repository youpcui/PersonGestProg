package ycui.projet.pgp.main;

import ycui.projet.pgp.lang.LANG;
import ycui.projet.pgp.menu.*;
import ycui.projet.pgp.util.InputData;
import ycui.projet.pgp.util.PrintFormat;

public class Main implements LANG {
	public static void main(String[] args) {
		// new Menu();
		String star = PrintFormat.setFormatFull(STAR);
		String title = PrintFormat.setFormatCenter("System information");
		String english = PrintFormat.setFormatCenter(NUM01 + "ENGLISH");
		String french = PrintFormat.setFormatAlign(english,NUM02 + "FRANCAIS");
		String chinese = PrintFormat.setFormatAlign(english,NUM03 + "ÖÐÎÄ");
		String exit = PrintFormat.setFormatAlign(english,NUM00 + "EXIT");
		while (true) {
			System.out.println(title);
			System.out.println(star);
			System.out.println(english);
			System.out.println(french);
			System.out.println(chinese);
			System.out.println(exit);
			System.out.println(star);
			System.out.println("\n");

			switch (new InputData().getInt("Please select a language:")) {
			case 0: {
				System.exit(1);
				break;
			}
			case 1: {
				new Menu(LANG.LangType.Lang_EN);
				break;
			}
			case 2: {
				new Menu(LANG.LangType.Lang_FR);
				break;
			}
			case 3: {
				new Menu(LANG.LangType.Lang_CH);
				break;
			}
			default: {
				System.out.println("Please make a correct choice!");
				break;
			}
			}
		}

	}
}
