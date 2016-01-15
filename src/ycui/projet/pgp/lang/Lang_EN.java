package ycui.projet.pgp.lang;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

 class Lang_EN extends Language{

	 private static final LangType type = LANG.LangType.Lang_EN;

		/* 菜单属性 */
		private Properties enMenus = new Properties();

		private Properties getEnMenus() {
			return enMenus;
		}
		private void setEnMenus() {
			try {
				this.enMenus.loadFromXML(new FileInputStream("xml"+File.pathSeparator+"en_menus.xml"));
			} catch (InvalidPropertiesFormatException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		/* 操作属性 */
		private Properties enOperate = new Properties(); 

		public Properties getEnOperate() {
			return enOperate;
		}
		
		private void setEnOperate() {
			try {
				this.enOperate.loadFromXML(new FileInputStream("xml"+File.pathSeparator+"en_operate.xml"));
			} catch (InvalidPropertiesFormatException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public Lang_EN() {
			super(type);
//			this.setEnMenus();
//			this.setEnOperate();
			super.menus = this.getEnMenus();
		}
}
