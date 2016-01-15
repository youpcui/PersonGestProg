package ycui.projet.pgp.lang;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

class Lang_FR extends Language {
	private static final LangType type = LANG.LangType.Lang_FR;

	/* menus properties */
	private Properties frMenus = new Properties();

	private Properties getFrMenus() {
		return frMenus;
	}
	private void setFrMenus() {
		try {
			this.frMenus.loadFromXML(new FileInputStream("xml"+File.pathSeparator+"fr_menus.xml"));
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* operate properties */
	private Properties frOperate = new Properties(); 

	public Properties getFrOperate() {
		return frOperate;
	}
	
	private void setFrOperate() {
		try {
			this.frOperate.loadFromXML(new FileInputStream("xml"+File.pathSeparator+"fr_operate.xml"));
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Lang_FR() {
		super(type);
		this.setFrMenus();
//		this.setFrOperate();
		super.menus = this.getFrMenus();
	}
}
