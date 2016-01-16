package ycui.projet.pgp.lang;



import java.util.Properties;


public abstract class Language implements LANG {
	protected LangType type = null;
	public Properties menus = null;
	public Properties operate = null;

	public Language(LangType lt){
		this.setType(lt);
	}
	public LangType getType() {
		return type;
	}
	public void setType(LangType type) {
		this.type = type;
	}
	public String getProperty(String key){
		return this.operate.getProperty(key);
	}
}

