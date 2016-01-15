package ycui.projet.pgp.lang.property;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import ycui.projet.pgp.lang.LANG;

public class SaveProperties_CH implements LANG,CH{
	private Properties prop = new Properties();
		
	public Properties getProp() {
		return prop;
	}
	
	public SaveProperties_CH(){
		this.setChMenus();
	}

	/* menus properties */
	private void setChMenus() {
		this.prop.setProperty("CHOICE", "请输入正确的选择！");
		this.prop.setProperty("WRONGCHOICE", "请选择：");

		this.prop.setProperty("M00_00", INFO+GEST+"系统");
		this.prop.setProperty("M00_01", NUM01+R01A+GEST);
		this.prop.setProperty("M00_02", NUM02+R02A+GEST);
		this.prop.setProperty("M00_03", NUM03+LKG+"所有人员"+INFO);
		this.prop.setProperty("M00_04", NUM04+"退出系统");

		this.prop.setProperty("M01_00_R01", R01A+GEST);
		this.prop.setProperty("M01_01_R01", NUM01+CRT+R01S);
		this.prop.setProperty("M01_02_R01", NUM02+LKG+R01T);
		this.prop.setProperty("M01_03_R01", NUM03+RSC+R01A+INFO);
		this.prop.setProperty("M01_04_R01", NUM04+DLT+R01S);
		this.prop.setProperty("M01_05_R01", NUM05+UPD+R01S);
		this.prop.setProperty("M01_06_R01", NUM06+BACK+HOME);

		this.prop.setProperty("M01_00_R02", R02A+GEST);
		this.prop.setProperty("M01_01_R02", NUM01+CRT+R02S);
		this.prop.setProperty("M01_02_R02", NUM02+LKG+R02T);
		this.prop.setProperty("M01_03_R02", NUM03+RSC+R02A+INFO);
		this.prop.setProperty("M01_04_R02", NUM04+DLT+R02S);
		this.prop.setProperty("M01_05_R02", NUM05+UPD+R02S);
		this.prop.setProperty("M01_06_R02", NUM06+BACK+HOME);
		
		this.prop.setProperty("M02_00_R01", RSC+R01A+INFO);
		this.prop.setProperty("M02_01_R01", NUM01+RSC+R01T);
		this.prop.setProperty("M02_02_R01", NUM02+"通过ID"+RSC+R01A);
		this.prop.setProperty("M02_03_R01", NUM03+"通过关键字"+RSC+R01A);
		this.prop.setProperty("M02_04_R01", NUM04+BACK+PREV);
		this.prop.setProperty("M02_05_R01", NUM05+BACK+HOME);

		this.prop.setProperty("M02_00_R02", RSC+R02A+INFO);
		this.prop.setProperty("M02_01_R02", NUM01+RSC+R02T);
		this.prop.setProperty("M02_02_R02", NUM02+"通过ID"+RSC+R02A);
		this.prop.setProperty("M02_03_R02", NUM03+"通过关键字"+RSC+R02A);
		this.prop.setProperty("M02_04_R02", NUM04+BACK+PREV);
		this.prop.setProperty("M02_05_R02", NUM05+BACK+HOME);
	}
	
	public static void main(String args[]){
		Properties p = new Properties();
		p = new SaveProperties_CH().getProp();
		try {
			p.storeToXML(new FileOutputStream("xml/ch_menus.xml"),"中文菜单");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
