package ycui.projet.pgp.lang;



import java.util.Properties;


public abstract class Language implements LANG{
	private LangType type = null;
	private Properties property = null;

	public LangType getType() {
		return type;
	}
	protected void setType(LangType type) {
		this.type = type;
	}
	protected String getProperty(String key){
		return this.property.getProperty(key);
	}
	protected void setProperty(Properties prop) {
		this.property = prop;
	}
	public String translate(String key){
		return getProperty(key);
	}
}

