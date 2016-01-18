package ycui.projet.pgp.menu;

import ycui.projet.pgp.lang.*;
import ycui.projet.pgp.operate.*;
import ycui.projet.pgp.proxy.MessageProxy;
import ycui.projet.pgp.util.InputData;
import ycui.projet.pgp.util.PrintFormat;

public class Menu implements LANG {
	private InputData input = null;
	private PersonOperate po = null;
	private Language lang = null;
	private MessageProxy mp = null;

	public Menu(LangType type) {
		this.input = new InputData(); // check value
		this.lang = LanguageFactory.getLanguage(type);
		this.showMain();
	}

	// 主菜单
	public void showMain() {
		while (true) {
			this.po = new PersonOperate(lang.getType());
			System.out.println(formatMenus("M00_00"));
			System.out.println(PrintFormat.setFormatFull(STAR));
			System.out.println(formatMenus("M00_01"));
			System.out.println(formatMenus("M00_02"));
			System.out.println(formatMenus("M00_03"));
			System.out.println(formatMenus("M00_04"));
			System.out.println(formatMenus("M00_05"));
			System.out.println(PrintFormat.setFormatFull(STAR));
			// 选择操作
			switch (input.getInt(lang.translate("CHOICE"))) {
			case 1: {
				showWorker();
				break;
			}
			case 2: {
				showStudent();
				break;
			}
			case 3: {
				mp = po.findAll();
				System.out.println(mp);
				break;
			}
			case 4: {
				mp = po.deleteAll();
				System.out.println(mp);
				break;
			}
			case 5: {
				System.exit(1);
				break;
			}
			default: {
				System.out.println(lang.translate("WRONGCHOICE"));
				break;
			}
			}
		}
	}

	// 员工信息管理菜单
	public void showWorker() {
		while (true) {
			this.po = new WorkerOperate(lang.getType());
			System.out.println(formatMenus("M01_00_R01"));
			System.out.println(PrintFormat.setFormatFull(STAR));
			System.out.println(formatMenus("M01_01_R01"));
			System.out.println(formatMenus("M01_02_R01"));
			System.out.println(formatMenus("M01_03_R01"));
			System.out.println(formatMenus("M01_04_R01"));
			System.out.println(formatMenus("M01_05_R01"));
			System.out.println(formatMenus("M01_06_R01"));
			System.out.println(PrintFormat.setFormatFull(STAR));
			// 选择操作
			switch (input.getInt(lang.translate("CHOICE"))) {
			case 1: {
				mp = po.add();
				System.out.println(mp);
				break;
			}
			case 2: {
				mp = po.findAll();
				System.out.println(mp);
				break;
			}
			case 3: {
				showResearchWorker();
				break;
			}
			case 4: {
				mp = po.delete();
				System.out.println(mp);
				break;
			}
			case 5: {
				mp = po.update();
				System.out.println(mp);
				break;
			}
			case 6: {
				showMain();
				break;
			}
			default: {
				System.out.println(lang.translate("WRONGCHOICE"));
				break;
			}
			}
		}
	}

	// 学生信息管理菜单
	public void showStudent() {
		while (true) {
			this.po = new StudentOperate(lang.getType());
			System.out.println(formatMenus("M01_00_R02"));
			System.out.println(PrintFormat.setFormatFull(STAR));
			System.out.println(formatMenus("M01_01_R02"));
			System.out.println(formatMenus("M01_02_R02"));
			System.out.println(formatMenus("M01_03_R02"));
			System.out.println(formatMenus("M01_04_R02"));
			System.out.println(formatMenus("M01_05_R02"));
			System.out.println(formatMenus("M01_06_R02"));
			System.out.println(PrintFormat.setFormatFull(STAR));
			// 选择操作
			switch (input.getInt(lang.translate("CHOICE"))) {
			case 1: {
				mp = po.add();
				System.out.println(mp);
				break;
			}
			case 2: {
				mp = po.findAll();
				System.out.println(mp);
				break;
			}
			case 3: {
				showResearchStudent();
				break;
			}
			case 4: {
				mp = po.delete();
				System.out.println(mp);
				break;
			}
			case 5: {
				mp = po.update();
				System.out.println(mp);
				break;
			}
			case 6: {
				showMain();
				break;
			}
			default: {
				System.out.println(lang.translate("WRONGCHOICE"));
				break;
			}
			}
		}

	}

	// 查找员工信息菜单
	public void showResearchWorker() {
		while (true) {
			this.po = new WorkerOperate(lang.getType());
			System.out.println(formatMenus("M02_00_R01"));
			System.out.println(PrintFormat.setFormatFull(STAR));
			System.out.println(formatMenus("M02_01_R01"));
			System.out.println(formatMenus("M02_02_R01"));
			System.out.println(formatMenus("M02_03_R01"));
			System.out.println(formatMenus("M02_04_R01"));
			System.out.println(formatMenus("M02_05_R01"));
			System.out.println(PrintFormat.setFormatFull(STAR));
			// 选择操作
			switch (input.getInt(lang.translate("CHOICE"))) {
			case 1: {
				mp = po.findAll();
				System.out.println(mp);
				break;
			}
			case 2: {
				mp = po.findById();
				System.out.println(mp);
				break;
			}
			case 3: {
				mp = po.findByKey();
				System.out.println(mp);
				break;
			}
			case 4: {
				showWorker();
				break;
			}
			case 5: {
				showMain();
				break;
			}
			default: {
				System.out.println(lang.translate("WRONGCHOICE"));
				break;
			}
			}
		}
	}

	// 查找学生信息菜单
	public void showResearchStudent() {
		while (true) {
			this.po = new StudentOperate(lang.getType());
			System.out.println(formatMenus("M02_00_R02"));
			System.out.println(PrintFormat.setFormatFull(STAR));
			System.out.println(formatMenus("M02_01_R02"));
			System.out.println(formatMenus("M02_02_R02"));
			System.out.println(formatMenus("M02_03_R02"));
			System.out.println(formatMenus("M02_04_R02"));
			System.out.println(formatMenus("M02_05_R02"));
			System.out.println(PrintFormat.setFormatFull(STAR));
			// 选择操作
			switch (input.getInt(lang.translate("CHOICE"))) {
			case 1: {
				mp = po.findAll();
				System.out.println(mp);
				break;
			}
			case 2: {
				mp = po.findById();
				System.out.println(mp);
				break;
			}
			case 3: {
				mp = po.findByKey();
				System.out.println(mp);
				break;
			}
			case 4: {
				showStudent();
				break;
			}
			case 5: {
				showMain();
				break;
			}
			default: {
				System.out.println(lang.translate("WRONGCHOICE"));
				break;
			}
			}
		}
	}

	private String formatMenus(String key) {
		String sub = key.substring(0, 1);
		if (sub.equals("M") && key.substring(4, 6).equals("00")) {
			return PrintFormat
					.setFormatCenter(lang.translate(key));
		} else if (sub.equals("M") && !key.substring(4, 6).equals("00")) {
			if (lang.getType() == LangType.Lang_CH)
				return PrintFormat.setFormatAlign(30,
						lang.translate(key));
			else
				return PrintFormat.setFormatAlign(20,
						lang.translate(key));
		}
		return lang.translate(key);
	}
}
