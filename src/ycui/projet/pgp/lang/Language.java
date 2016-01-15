package ycui.projet.pgp.lang;



import java.util.Properties;


public abstract class Language implements LANG {
	protected LangType type = LANG.LangType.Lang_EN;
	public Properties menus = null;
	public Properties operate = null;
	
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
	
	public void Formatter(Properties prop){

	}
	
	public static void main(String args[]){

	}
	
}

