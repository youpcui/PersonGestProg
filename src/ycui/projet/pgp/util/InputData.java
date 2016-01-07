package ycui.projet.pgp.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//输入数据操作类
public class InputData {
	private BufferedReader buf = null;
	
	public InputData(){
		buf = new BufferedReader(
				new InputStreamReader(System.in));
	}
	
	public String getString() {
		String str = null;
		try {
			str = buf.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public int getInt(){
		int i = 0;
		// 如果不是数字，应有一个提示。告诉用户输入错误
		//可以使用正则表达式
		String str =null;
		boolean flag = true;
		while(flag){
			str = this.getString();
			if(!(str.matches("\\d+"))){
				System.out.println("Il faudra saisir un nombre entier!");
			}else{
				//数字正确
				i = Integer.parseInt(str);
				//退出循环
				flag = false;
			}
		}
		return i;
	}

	public float getFloat(){
		float f = 0.0f;
		String str = null;
		boolean flag = true;
		while(flag){
			str = this.getString();
			if(!(str.matches("\\d+.?\\d{1,2}"))){
				System.out.println("Il faudra saisir un nombre décimal(deux chiffre après virgule)!");
			}else{
				//数字正确
				f = Float.parseFloat(str);
				//退出循环
				flag = false;
			}
		}
		return f;
	}
	public static void main(String args[]){
		
		InputData in = new InputData();
		//String str = in.getString();
		float f = in.getFloat();
		System.out.println("-->"+f);
	}
}
