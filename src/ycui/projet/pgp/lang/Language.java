package ycui.projet.pgp.lang;



import java.util.Properties;


public abstract class Language implements LANG {
	private LangType type = null;
//	public Properties menus = null;
//	public Properties operate = null;
	private Properties property = null;

	public LangType getType() {
		return type;
	}
	protected void setType(LangType type) {
		this.type = type;
	}
	
	public String getProperty(String key){
		return this.property.getProperty(key);
	}
	protected void setProperty(Properties prop) {
		this.property = prop;
	}
}

