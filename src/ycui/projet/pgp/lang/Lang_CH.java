package ycui.projet.pgp.lang;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

 class Lang_CH extends Language{

	 private static final LangType type = LANG.LangType.Lang_CH;

		/* 菜单属性 */
		private Properties ChMenus = new Properties();

		private Properties getChMenus() {
			return ChMenus;
		}
		private void setChMenus() {
			try {
				this.ChMenus.loadFromXML(new FileInputStream("xml"+File.pathSeparator+"ch_menus.xml"));
			} catch (InvalidPropertiesFormatException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		/* 操作属性 */
		private Properties chOperate = new Properties(); 

		public Properties getChOperate() {
			return chOperate;
		}
		
		private void setChOperate() {
			try {
				this.chOperate.loadFromXML(new FileInputStream("xml"+File.pathSeparator+"ch_operate.xml"));
			} catch (InvalidPropertiesFormatException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public Lang_CH() {
			super(type);
			this.setChMenus();
//			this.setChOperate();
			super.menus = this.getChMenus();
		}
}
