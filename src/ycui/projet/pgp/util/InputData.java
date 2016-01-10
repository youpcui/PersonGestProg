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
	
	public String getString(String prompt) {
		System.out.print(prompt);
		String str = null;
		try {
			str = buf.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public int getInt(String prompt){
		int i = 0;
		// ����������֣�Ӧ��һ����ʾ�������û��������
		//����ʹ��������ʽ
		String str = null;
		boolean flag = true;
		while(flag){
			str = this.getString(prompt);
			/*accepte qu'un nombre entier*/
			if(!(str.matches("\\d+"))){
				System.err.println("Il faudra saisir un nombre entier!");
			}else{
				//������ȷ
				i = Integer.parseInt(str);
				//�˳�ѭ��
				flag = false;
			}
		}
		return i;
	}

	public float getFloat(String prompt){
		float f = 0.0f;
		String str = null;
		boolean flag = true;
		while(flag){
			str = this.getString(prompt);
			/*accepte un nombre d��cimal avec 2 chiffre apr��s virgule ou un nombre entier*/
			if(!(str.matches("\\d+.?\\d{1,2}|\\d+"))){ 
				System.err.println("Il faudra saisir un nombre d��cimal(deux chiffre apr��s virgule)!");
			}else{
				//������ȷ
				f = Float.parseFloat(str);
				//�˳�ѭ��
				flag = false;
			}
		}
		return f;
	}
}
