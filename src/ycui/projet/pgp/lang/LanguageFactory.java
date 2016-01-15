package ycui.projet.pgp.lang;

public class LanguageFactory implements LANG{
	public static Language getLanguage(LangType type){
		Language lang = null;
		try {
			lang = (Language) Class.forName("ycui.projet.pgp.lang."+type.name()).newInstance();
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			if(lang==null){
				lang = new Lang_FR();
			}
		}
		return lang;
	}
}
