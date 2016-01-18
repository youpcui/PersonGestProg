package ycui.projet.pgp.lang;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

class Lang_FR extends Language {
	private static final LangType type = LANG.LangType.Lang_FR;
	private Properties frProperty = new Properties();
	
	private Properties getFrProperty() {
		return frProperty;
	}
	private void setFrProperty() {
		try {
			this.frProperty.loadFromXML(new FileInputStream("xml"+File.separator+"fr_property.xml"));
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Lang_FR() {
		super.setType(type);
		setFrProperty();
		super.setProperty(getFrProperty());
		
		
	}
}
