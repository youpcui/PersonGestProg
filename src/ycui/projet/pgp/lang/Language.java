package ycui.projet.pgp.lang;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class Language implements LANG{
	private LangType type = null;
	private Properties property = null;
	
	public Language(LangType type){
		changeLang(type);
	}
	public LangType getType(){
		return this.type;
	}
	public String translate(String key){
		return this.property.getProperty(key);
	}
	public void changeLang(LangType type){
		this.type = type;
		this.loadProperty(type);
	}
	private void loadProperty(LangType type) {
		this.property = new Properties();
		try {
			this.property.loadFromXML(new FileInputStream("xml"+File.separator+type+".xml"));
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

