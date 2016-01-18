package ycui.projet.pgp.lang;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

 class Lang_EN extends Language{

	 private static final LangType type = LANG.LangType.Lang_EN;
	 private Properties enProperty = new Properties();

	 private Properties getEnProperty() {
			return enProperty;
		}
		private void setEnProperty() {
			try {
				this.enProperty.loadFromXML(new FileInputStream("xml"+File.separator+"en_property.xml"));
			} catch (InvalidPropertiesFormatException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public Lang_EN() {
			super.setType(type);
			setEnProperty();
			super.setProperty(getEnProperty());
		}
}
