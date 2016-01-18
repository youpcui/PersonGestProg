package ycui.projet.pgp.lang.property;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import ycui.projet.pgp.lang.LANG;

public class SaveProperties_CH implements LANG, CH {
	private Properties prop = new Properties();

	public Properties getProp() {
		return prop;
	}

	public SaveProperties_CH() {
		this.setChMenus();
	}

	/* menus properties */
	private void setChMenus() {
		this.prop.setProperty("CHOICE", "请选择：");
		this.prop.setProperty("WRONGCHOICE", "请输入正确的选择！");

		this.prop.setProperty("M00_00", INFO + GEST + STM);
		this.prop.setProperty("M00_01", NUM01 + R01A + GEST);
		this.prop.setProperty("M00_02", NUM02 + R02A + GEST);
		this.prop.setProperty("M00_03", NUM03 + LKG + ALL + PERSON + INFO);
		this.prop.setProperty("M00_04", NUM04 + DLT + ALL + PERSON + INFO);
		this.prop.setProperty("M00_05", NUM05 + EXIT+STM);

		this.prop.setProperty("M01_00_R01", R01A + GEST);
		this.prop.setProperty("M01_01_R01", NUM01 + CRT + R01S);
		this.prop.setProperty("M01_02_R01", NUM02 + LKG + R01T);
		this.prop.setProperty("M01_03_R01", NUM03 + RSC + R01A + INFO);
		this.prop.setProperty("M01_04_R01", NUM04 + DLT + R01S);
		this.prop.setProperty("M01_05_R01", NUM05 + UPD + R01S);
		this.prop.setProperty("M01_06_R01", NUM06 + BACK + HOME);

		this.prop.setProperty("M01_00_R02", R02A + GEST);
		this.prop.setProperty("M01_01_R02", NUM01 + CRT + R02S);
		this.prop.setProperty("M01_02_R02", NUM02 + LKG + R02T);
		this.prop.setProperty("M01_03_R02", NUM03 + RSC + R02A + INFO);
		this.prop.setProperty("M01_04_R02", NUM04 + DLT + R02S);
		this.prop.setProperty("M01_05_R02", NUM05 + UPD + R02S);
		this.prop.setProperty("M01_06_R02", NUM06 + BACK + HOME);

		this.prop.setProperty("M02_00_R01", RSC + R01A + INFO);
		this.prop.setProperty("M02_01_R01", NUM01 + RSC + R01T);
		this.prop.setProperty("M02_02_R01", NUM02 + WITH + ID + RSC + R01A);
		this.prop.setProperty("M02_03_R01", NUM03 + WITH + KEY + RSC + R01A);
		this.prop.setProperty("M02_04_R01", NUM04 + BACK + PREV);
		this.prop.setProperty("M02_05_R01", NUM05 + BACK + HOME);

		this.prop.setProperty("M02_00_R02", RSC + R02A + INFO);
		this.prop.setProperty("M02_01_R02", NUM01 + RSC + R02T);
		this.prop.setProperty("M02_02_R02", NUM02 + WITH + ID + RSC + R02A);
		this.prop.setProperty("M02_03_R02", NUM03 + WITH + KEY + RSC + R02A);
		this.prop.setProperty("M02_04_R02", NUM04 + BACK + PREV);
		this.prop.setProperty("M02_05_R02", NUM05 + BACK + HOME);

		// Person
		this.prop.setProperty("PO_00_ID", ID + COLON);
		this.prop.setProperty("PO_00_NAME", NAME + COLON);
		this.prop.setProperty("PO_00_AGE", AGE + COLON);

		this.prop.setProperty("PO_03_KEY", KEY + COLON);
		this.prop.setProperty("PO_03_RESULT", RSC + RESULT);
		this.prop.setProperty("PO_03_KO", RSC + LIST + EMPTY);
		this.prop.setProperty("PO_04_OK", DLT + ALL + PERSON + OK);
		this.prop.setProperty("PO_04_KO", DLT + ALL + PERSON + KO);

		// worker
		this.prop.setProperty("PO_00_R01_SALARY", SALARY + COLON);
		this.prop.setProperty("PO_01_R01_OK", OK + CRT + R01S + COLON);
		this.prop.setProperty("PO_01_R01_KO", CRT + R01S + KO + COLON);
		this.prop.setProperty("PO_02_R01_OK", OK + UPD + R01S + COLON);
		this.prop.setProperty("PO_02_R01_KO", UPD + R01A + KO + COLON);
		this.prop.setProperty("PO_03_R01_HEAD", R01A + ID + "\t" + NAME
				+ "\t\t" + AGE + "\t" + SALARY + "\n");
		this.prop.setProperty("PO_03_R01_KO", RSC + R01A + KO + COLON);
		this.prop.setProperty("PO_04_R01_OK", OK + DLT + R01S + COLON);
		this.prop.setProperty("PO_04_R01_KO", DLT + R01A + KO + COLON);

		// student
		this.prop.setProperty("PO_00_R02_SCORE", SCORE + COLON);
		this.prop.setProperty("PO_01_R02_OK", OK + CRT + R02S + COLON);
		this.prop.setProperty("PO_01_R02_KO", CRT + R02A + KO + COLON);
		this.prop.setProperty("PO_02_R02_OK", OK + UPD + R02S + COLON);
		this.prop.setProperty("PO_02_R02_KO", UPD + R02A + KO + COLON);
		this.prop.setProperty("PO_03_R02_HEAD", R02A + ID + "\t" + NAME
				+ "\t\t" + AGE + "\t" + SCORE + "\n");
		this.prop.setProperty("PO_03_R02_KO", RSC + R02A + KO + COLON);
		this.prop.setProperty("PO_04_R02_OK", OK + DLT + R02S + COLON);
		this.prop.setProperty("PO_04_R02_KO", DLT + R02A + KO + COLON);
	}

	public static void main(String args[]) {
		Properties p = new Properties();
		p = new SaveProperties_CH().getProp();
		try {
			p.storeToXML(new FileOutputStream("xml" + File.separator
					+ "ch_property.xml"), "中文");
			System.out.println("保存语言成功！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
