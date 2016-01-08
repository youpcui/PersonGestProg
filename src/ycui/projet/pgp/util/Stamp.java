package ycui.projet.pgp.util;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

//取得时间戳的类
public class Stamp {
	private Calendar calendar = null;
	private String type = null;
	
	public Stamp(){
		this.calendar = new GregorianCalendar();
	}
	public Stamp(String type){
		this();
		this.type = type;
	}
	
	/**obtenir le temps actuel*/
	public String getTimeStamp(){
		StringBuffer buf = new StringBuffer();
		if(this.type != null){
			buf.append(type);
		}
		buf.append(this.addZero(calendar.get(Calendar.YEAR),4));
		buf.append(this.addZero(calendar.get(Calendar.MONTH)+1,2));
		buf.append(this.addZero(calendar.get(Calendar.DAY_OF_MONTH),2));
		buf.append(this.addZero(calendar.get(Calendar.HOUR_OF_DAY),2));
		buf.append(this.addZero(calendar.get(Calendar.MINUTE),2));
		buf.append(this.addZero(calendar.get(Calendar.SECOND),2));
		buf.append(this.addZero(calendar.get(Calendar.MILLISECOND),3)); 
		return buf.toString();
	}
	
	/**obtenir le temps avec 3 chiffre aléatoires*/
	public String getTimeStampRandom(){
		StringBuffer buf = new StringBuffer();
		Random r = new Random();
		buf.append(this.getTimeStamp());
		buf.append(r.nextInt(10));
		buf.append(r.nextInt(10));
		buf.append(r.nextInt(10));
		return buf.toString();
	}
	
	private String addZero(int str, int len){
		String tmp = str + "";
		while(tmp.length() < len){
			tmp = "0" + tmp;
		}
		return tmp;
	}
}
