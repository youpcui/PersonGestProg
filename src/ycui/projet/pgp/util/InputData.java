package ycui.projet.pgp.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//输入数据操作类
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
		// 如果不是数字，应有一个提示。告诉用户输入错误
		// 可以使用正则表达式
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
			 * accepte un nombre décimal avec 2 chiffre après virgule ou un
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
