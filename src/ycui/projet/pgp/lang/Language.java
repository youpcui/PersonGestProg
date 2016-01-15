package ycui.projet.pgp.lang;

import java.util.Properties;


public abstract class Language implements LANG {
	protected LangType type = LANG.LangType.Lang_EN;
	public Properties menus = null;
	
	protected static final int space = 20; 
	
	public Language(){
		this.setType(type);
	}
	public Language(LangType lt){
		this.setType(lt);
	}
	public LangType getType() {
		return type;
	}
	public void setType(LangType type) {
		this.type = type;
	}
}

