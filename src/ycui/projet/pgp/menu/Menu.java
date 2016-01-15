package ycui.projet.pgp.menu;

import ycui.projet.pgp.lang.*;
import ycui.projet.pgp.operate.*;
import ycui.projet.pgp.util.InputData;
import ycui.projet.pgp.util.PrintFormat;

public class Menu implements LANG{
	private InputData input = null;
	private PersonOperate po = null;
	private Language lang = null;
	
	public Menu(LangType type) {
		this.input = new InputData(); // check value
		this.lang = LanguageFactory.getLanguage(type);
		this.showMain();
	}

	
	// 主菜单
	public void showMain() {
		while(true){
			this.po = new PersonOperate(); 
			System.out.println(lang.getM00_00());
			System.out.println(PrintFormat.setFormatFull(STAR));
			System.out.println(lang.getM00_01());
			System.out.println(lang.getM00_02());
			System.out.println(lang.getM00_03());
			System.out.println(lang.getM00_04());
			System.out.println(PrintFormat.setFormatFull(STAR));
			//选择操作
			switch(input.getInt(lang.getCHOICE())){
				case 1: {
					showWorker();
					break;
				}
				case 2: {
					showStudent();
					break;
				}
				case 3: {
					po.findAll();
					break;
				}
				case 4: {
					System.exit(1);
					break;
				}
				default: {
					System.out.println(lang.getDEFAULTINFO());
					break;
				}
			}
		}
	}

	// 员工信息管理菜单
	public void showWorker() {
		while(true){
			this.po = new WorkerOperate();
			System.out.println(lang.getM01_00_R01());
			System.out.println(PrintFormat.setFormatFull(STAR));
			System.out.println(lang.getM01_01_R01());
			System.out.println(lang.getM01_02_R01());
			System.out.println(lang.getM01_03_R01());
			System.out.println(lang.getM01_04_R01());
			System.out.println(lang.getM01_05_R01());
			System.out.println(lang.getM01_06_R01());
			System.out.println(PrintFormat.setFormatFull(STAR));
			//选择操作
			switch(input.getInt(lang.getCHOICE())){
				case 1: {
					po.add();
					break;
				}
				case 2: {
					po.findAll();
					break;
				}
				case 3: {
					showResearchWorker();
					break;
				}
				case 4: {
					po.delete();
					break;
				}
				case 5: {
					po.update();
					break;
				}
				case 6: {
					showMain();
					break;
				}
				default: {
					System.out.println(lang.getDEFAULTINFO());
					break;
				}
			}
		}
	}

	// 学生信息管理菜单
	public void showStudent() {
		while(true){
			this.po = new StudentOperate();
			System.out.println(lang.getM01_00_R02());
			System.out.println(PrintFormat.setFormatFull(STAR));
			System.out.println(lang.getM01_01_R02());
			System.out.println(lang.getM01_02_R02());
			System.out.println(lang.getM01_03_R02());
			System.out.println(lang.getM01_04_R02());
			System.out.println(lang.getM01_05_R02());
			System.out.println(lang.getM01_06_R02());
			System.out.println(PrintFormat.setFormatFull(STAR));
			//选择操作
			switch(input.getInt(lang.getCHOICE())){
				case 1: {
					po.add();
					break;
				}
				case 2: {
					po.findAll();
					break;
				}
				case 3: {
					showResearchStudent();
					break;
				}
				case 4: {
					po.delete();
					break;
				}
				case 5: {
					po.update();
					break;
				}
				case 6: {
					showMain();
					break;
				}
				default: {
					System.out.println(lang.getDEFAULTINFO());
					break;
				}
			}
		}

	}
	
	// 查找员工信息菜单
	public void showResearchWorker() {
		while(true){
			this.po = new WorkerOperate();
			System.out.println(lang.getM02_00_R01());
			System.out.println(PrintFormat.setFormatFull(STAR));
			System.out.println(lang.getM02_01_R01());
			System.out.println(lang.getM02_02_R01());
			System.out.println(lang.getM02_03_R01());
			System.out.println(lang.getM02_04_R01());
			System.out.println(lang.getM02_05_R01());
			System.out.println(PrintFormat.setFormatFull(STAR));
			//选择操作
			switch(input.getInt(lang.getCHOICE())){
				case 1: {
					po.findAll();
					break;
				}
				case 2: {
					po.findById();
					break;
				}
				case 3: {
					po.findByKey();
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
					System.out.println(lang.getDEFAULTINFO());
					break;
				}
			}
		}
	}
	
	// 查找学生信息菜单
		public void showResearchStudent() {
			while(true){
				this.po = new StudentOperate();
				System.out.println(lang.getM02_00_R02());
				System.out.println(PrintFormat.setFormatFull(STAR));
				System.out.println(lang.getM02_01_R02());
				System.out.println(lang.getM02_02_R02());
				System.out.println(lang.getM02_03_R02());
				System.out.println(lang.getM02_04_R02());
				System.out.println(lang.getM02_05_R02());
				System.out.println(PrintFormat.setFormatFull(STAR));
				//选择操作
				switch(input.getInt(lang.getCHOICE())){
					case 1: {
						po.findAll();
						break;
					}
					case 2: {
						po.findById();
						break;
					}
					case 3: {
						po.findByKey();
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
						System.out.println(lang.getDEFAULTINFO());
						break;
					}
				}
			}
		}
}
