package ycui.projet.pgp.lang.property;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import ycui.projet.pgp.lang.LANG;

public class SaveProperties_EN implements LANG, EN {
	private Properties prop = new Properties();

	public Properties getProp() {
		return prop;
	}

	public SaveProperties_EN() {
		this.setProp();
	}

	// operate properties
	private void setProp() {
		this.prop.setProperty("CHOICE", CHOICE + COLON);
		this.prop.setProperty("WRONGCHOICE", CHOICE + SIG + " correct number!");

		this.prop.setProperty("M00_00", GEST + INFO + STM);
		this.prop.setProperty("M00_01", NUM01 + "The" + R01A + "s'" + STM);
		this.prop.setProperty("M00_02", NUM02 + "The" + R02A + "s'" + STM);
		this.prop.setProperty("M00_03", NUM03 + LKG + ALL + " persons");
		this.prop.setProperty("M00_04", NUM04 + DLT + ALL + " persons");
		this.prop.setProperty("M00_05", NUM05 + EXIT);

		this.prop.setProperty("M01_00_R01", R01P + STM);
		this.prop.setProperty("M01_01_R01", NUM01 + CRT + R01S);
		this.prop.setProperty("M01_02_R01", NUM02 + LKG + R01P);
		this.prop.setProperty("M01_03_R01", NUM03 + RSC + R01P);
		this.prop.setProperty("M01_04_R01", NUM04 + DLT + R01S);
		this.prop.setProperty("M01_05_R01", NUM05 + UPD + R01S);
		this.prop.setProperty("M01_06_R01", NUM06 + BACK + HOME);

		this.prop.setProperty("M01_00_R02", R02P + STM);
		this.prop.setProperty("M01_01_R02", NUM01 + CRT + R02S);
		this.prop.setProperty("M01_02_R02", NUM02 + LKG + R02P);
		this.prop.setProperty("M01_03_R02", NUM03 + RSC + R02P);
		this.prop.setProperty("M01_04_R02", NUM04 + DLT + R02S);
		this.prop.setProperty("M01_05_R02", NUM05 + UPD + R02S);
		this.prop.setProperty("M01_06_R02", NUM06 + BACK + HOME);

		this.prop.setProperty("M02_00_R01", RSC + R01P);
		this.prop.setProperty("M02_01_R01", NUM01 + RSC + ALL + R01A + PLS);
		this.prop.setProperty("M02_02_R01", NUM02 + RSC + WITH + " " + ID);
		this.prop.setProperty("M02_03_R01", NUM03 + RSC + WITH + " " + KEY);
		this.prop.setProperty("M02_04_R01", NUM04 + BACK + TO + PREV);
		this.prop.setProperty("M02_05_R01", NUM05 + BACK + HOME);

		this.prop.setProperty("M02_00_R02", RSC + R02P);
		this.prop.setProperty("M02_01_R02", NUM01 + RSC + ALL + R02A + PLS);
		this.prop.setProperty("M02_02_R02", NUM02 + RSC + WITH + ID);
		this.prop.setProperty("M02_03_R02", NUM03 + RSC + WITH + KEY);
		this.prop.setProperty("M02_04_R02", NUM04 + BACK + TO + PREV);
		this.prop.setProperty("M02_05_R02", NUM05 + BACK + HOME);

		// Person
		this.prop.setProperty("PO_00_ID", ID + COLON);
		this.prop.setProperty("PO_00_NAME", NAME + COLON);
		this.prop.setProperty("PO_00_AGE", AGE + COLON);

		this.prop.setProperty("PO_03_KEY", KEY + COLON);
		this.prop.setProperty("PO_03_RESULT", RESULT);
		this.prop.setProperty("PO_03_KO", THE + LIST + BE + EMPTY);
		this.prop.setProperty("PO_04_OK", OK + TO + DLTN + ALL);
		this.prop.setProperty("PO_04_KO", KO + TO + DLTN + ALL);

		// worker
		this.prop.setProperty("PO_00_R01_SALARY", SALARY + COLON);
		this.prop.setProperty("PO_01_R01_OK", OK + TO + CRTN + R01S + COLON);
		this.prop.setProperty("PO_01_R01_KO", KO + TO + CRTN + R01S + COLON);
		this.prop.setProperty("PO_02_R01_OK", OK + TO + UPDN + R01C + COLON);
		this.prop.setProperty("PO_02_R01_KO", KO + TO + UPDN + R01C + COLON);
		this.prop.setProperty("PO_03_R01_HEAD", ID + R01B + "\t" + NAME
				+ "\t\t" + AGE + "\t" + SALARY + "\n");
		this.prop.setProperty("PO_03_R01_KO", R01C + BE + NOT + RSCN + COLON);
		this.prop.setProperty("PO_04_R01_OK", OK + TO + DLTN + R01C + COLON);
		this.prop.setProperty("PO_04_R01_KO", KO + TO + DLTN + R01C + COLON);

		// student
		this.prop.setProperty("PO_00_R02_SCORE", SCORE + COLON);
		this.prop.setProperty("PO_01_R02_OK", OK + TO + CRTN + R02S + COLON);
		this.prop.setProperty("PO_01_R02_KO", KO + TO + CRTN + R02S + COLON);
		this.prop.setProperty("PO_02_R02_OK", OK + TO + UPDN + R02C + COLON);
		this.prop.setProperty("PO_02_R02_KO", KO + TO + UPDN + R02C + COLON);
		this.prop.setProperty("PO_03_R02_HEAD", ID + R02B + "\t" + NAME
				+ "\t\t" + AGE + "\t" + SCORE + "\n");
		this.prop.setProperty("PO_03_R02_KO", R01C + BE + NOT + RSCN + COLON);
		this.prop.setProperty("PO_04_R02_OK", OK + TO + DLTN + R02C + COLON);
	}

	public static void main(String args[]) {
		Properties p = new Properties();
		p = new SaveProperties_EN().getProp();
		try {
			p.storeToXML(new FileOutputStream("xml" + File.separator
					+ LangType.Lang_EN + ".xml"), "English");
			System.out.println("Succeed to save!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
