package ycui.projet.pgp.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//�������ݲ�����
public class InputData {
	private BufferedReader buf = null;

	public InputData() {
		buf = new BufferedReader(new InputStreamReader(System.in));
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

	public int getInt(String prompt) {
		int i = 0;
		// ����������֣�Ӧ��һ����ʾ�������û��������
		// ����ʹ��������ʽ
		String str = null;
		boolean flag = false;
		while (!flag) {
			str = this.getString(prompt);
			if (str.matches("\\d+")) { // accepte qu'un nombre entier
				try {//
					i = Integer.parseInt(str);
					flag = true;
				} catch (NumberFormatException e) {
					System.err.println("Input error");
				}
			} else {
				System.err.println("Input error");
			}
		}
		return i;
	}

	public float getFloat(String prompt) {
		float f = 0.0f;
		String str = null;
		boolean flag = false;
		while (!flag) {
			str = this.getString(prompt);
			/*
			 * accepte un nombre d��cimal avec 2 chiffre apr��s virgule ou un
			 * nombre entier
			 */
			if (str.matches("\\d+.?\\d{1,2}|\\d+")) {
				try {
					f = Float.parseFloat(str);
					flag = true;
				} catch (NumberFormatException e) {
					System.err.println("Input error");
				}
			} else {
				System.err.println("Input error");
			}
		}
		return f;
	}
}
