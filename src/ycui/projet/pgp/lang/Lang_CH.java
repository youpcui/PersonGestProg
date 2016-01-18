package ycui.projet.pgp.lang;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

 class Lang_CH extends Language{

	 private static final LangType type = LANG.LangType.Lang_CH;
	 private Properties chProperty = new Properties();
		
		private Properties getChProperty() {
			return chProperty;
		}
		private void setChProperty() {
			try {
				this.chProperty.loadFromXML(new FileInputStream("xml"+File.separator+"ch_property.xml"));
			} catch (InvalidPropertiesFormatException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public Lang_CH() {
			super.setType(type);
			setChProperty();
			super.setProperty(getChProperty());
		}
}
