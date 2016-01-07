package ycui.projet.pgp.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//�������ݲ�����
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
		// ����������֣�Ӧ��һ����ʾ�������û��������
		//����ʹ��������ʽ
		String str =null;
		boolean flag = true;
		while(flag){
			str = this.getString();
			if(!(str.matches("\\d+"))){
				System.out.println("Il faudra saisir un nombre entier!");
			}else{
				//������ȷ
				i = Integer.parseInt(str);
				//�˳�ѭ��
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
				System.out.println("Il faudra saisir un nombre d��cimal(deux chiffre apr��s virgule)!");
			}else{
				//������ȷ
				f = Float.parseFloat(str);
				//�˳�ѭ��
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
