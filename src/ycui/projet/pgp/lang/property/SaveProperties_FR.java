package ycui.projet.pgp.lang.property;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import ycui.projet.pgp.lang.LANG;

public class SaveProperties_FR implements LANG, FR {
	private Properties prop = new Properties();

	public Properties getProp() {
		return prop;
	}

	public SaveProperties_FR() {
		this.setProp();
	}

	// operate properties
	private void setProp() {
		this.prop.setProperty("CHOICE", INPUT + " le choix:");
		this.prop.setProperty("WRONGCHOICE","Veuillez saisir un choix correct!");
		
		this.prop.setProperty("M00_00", "Syst¨¨me" + D1 + " gestion" + D4 + INFO);
		this.prop.setProperty("M00_01", NUM01 + GEST + R01P);
		this.prop.setProperty("M00_02", NUM02 + GEST + R02P);
		this.prop.setProperty("M00_03", NUM03 + LKG + ALL + " personnes");
		this.prop.setProperty("M00_04", NUM04 + DLT + ALL + " personnes");
		this.prop.setProperty("M00_05", NUM05 + "Sortie");

		this.prop.setProperty("M01_00_R01", GEST + R01P);
		this.prop.setProperty("M01_01_R01", NUM01 + CRT + R01S);
		this.prop.setProperty("M01_02_R01", NUM02 + LKG + R01Q);
		this.prop.setProperty("M01_03_R01", NUM03 + RSC + L4 + INFO + R01P);
		this.prop.setProperty("M01_04_R01", NUM04 + DLT + R01S);
		this.prop.setProperty("M01_05_R01", NUM05 + UPD + L4 + INFO + R01B);
		this.prop.setProperty("M01_06_R01", NUM06 + BACK + A1 + HOME);

		this.prop.setProperty("M01_00_R02", GEST + R02P);
		this.prop.setProperty("M01_01_R02", NUM01 + CRT + R02S);
		this.prop.setProperty("M01_02_R02", NUM02 + LKG + R02Q);
		this.prop.setProperty("M01_03_R02", NUM03 + RSC + L4 + INFO + R02P);
		this.prop.setProperty("M01_04_R02", NUM04 + DLT + R02S);
		this.prop.setProperty("M01_05_R02", NUM05 + UPD + L4 + INFO + R02B);
		this.prop.setProperty("M01_06_R02", NUM06 + BACK + A1 + HOME);

		this.prop.setProperty("M02_00_R01", RSC + L4 + INFO + R01P);
		this.prop.setProperty("M02_01_R01", NUM01 + RSC + " tous");
		this.prop.setProperty("M02_02_R01", NUM02 + RSC + " par id");
		this.prop.setProperty("M02_03_R01", NUM03 + RSC + " par mot cl¨¦");
		this.prop.setProperty("M02_04_R01", NUM04 + BACK + A2 + PREV);
		this.prop.setProperty("M02_05_R01", NUM05 + BACK + A1 + HOME);

		this.prop.setProperty("M02_00_R02", RSC + L4 + INFO + R02P);
		this.prop.setProperty("M02_01_R02", NUM01 + RSC + " tous");
		this.prop.setProperty("M02_02_R02", NUM02 + RSC + " par id");
		this.prop.setProperty("M02_03_R02", NUM03 + RSC + " par mot cl¨¦");
		this.prop.setProperty("M02_04_R02", NUM04 + BACK + A2 + PREV);
		this.prop.setProperty("M02_05_R02", NUM05 + BACK + A1 + HOME);

		//Person
		this.prop.setProperty("PO_00_ID", ID+":");
		this.prop.setProperty("PO_00_NAME", NAME+":");
		this.prop.setProperty("PO_00_AGE", AGE+":");
		
		this.prop.setProperty("PO_03_KEY", KEY+":");
		this.prop.setProperty("PO_03_RESULT", RESULT);		
		this.prop.setProperty("PO_03_KO", LIST + EMPTY);
		this.prop.setProperty("PO_04_OK", OK+D1+DLTN+ALL);
		this.prop.setProperty("PO_04_KO", KO+D1+DLTN+ALL);
		
		//worker
		this.prop.setProperty("PO_00_R01_SALARY", SALARY+":");
		this.prop.setProperty("PO_01_R01_OK", OK+D4+CRTN+R01S+":");
		this.prop.setProperty("PO_01_R01_KO", KO+D4+CRTN+R01S+":");
		this.prop.setProperty("PO_02_R01_OK", OK+D1+UPDN+R01C+":");
		this.prop.setProperty("PO_02_R01_KO", KO+D1+UPDN+R01C+":");
		this.prop.setProperty("PO_03_R01_HEAD", ID + R01B + "\t" + NAME + "\t\t"
				+ AGE + "\t" + SALARY + "\n");
		this.prop.setProperty("PO_03_R01_KO", KO+D1+RSCN+R01C+":");
		this.prop.setProperty("PO_04_R01_OK", OK+D1+DLTN+R01C+":");
		this.prop.setProperty("PO_04_R01_KO", KO+D1+DLTN+R01C+":");
		
		//student
		this.prop.setProperty("PO_00_R02_SCORE", SCORE+":");
		this.prop.setProperty("PO_01_R02_OK", OK+D4+CRTN+R02S+":");
		this.prop.setProperty("PO_01_R02_KO", KO+D4+CRTN+R02S+":");		
		this.prop.setProperty("PO_02_R02_OK", OK+D1+UPDN+R02C+":");
		this.prop.setProperty("PO_02_R02_KO", KO+D1+UPDN+R02C+":");	
		this.prop.setProperty("PO_03_R02_HEAD", ID + R02B + "\t" + NAME + "\t\t"
				+ AGE + "\t" + SCORE + "\n");
		this.prop.setProperty("PO_03_R02_KO", KO+D1+RSCN+R01C+":");
		this.prop.setProperty("PO_04_R02_OK", OK+D1+DLTN+R02C+":");
		this.prop.setProperty("PO_04_R02_KO", KO+D1+DLTN+R02C+":");
	}

	public static void main(String args[]) {
		Properties p = new Properties();
		p = new SaveProperties_FR().getProp();
		try {
			p.storeToXML(new FileOutputStream("xml" + File.separator
					+ "fr_property.xml"), "francais");
			System.out.println("Succ¨¨s d'enregistrer");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
