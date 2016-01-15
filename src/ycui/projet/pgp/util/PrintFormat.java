package ycui.projet.pgp.util;

public class PrintFormat {
	public static String setFormatCenter(String source){
		String format = null; 
		int lenSource = 0; //����Դ
		int space = 0; //�ո���
		
		byte[] b = new byte[72]; //��ʼ������г���72
		for(int i=0;i<72;i++){
			b[i] = 32;
		}
		lenSource = source.getBytes().length; //����Դ����
		space = 70 - lenSource; //����ո�����ǰ����1byte
		if(space>0){ //���Դ�ַ���С�ڵ���76
			byte[] temp = source.getBytes(); //������ʱbyte����
			for(int j=0; j<lenSource; j++){ //������в�������
				b[36-lenSource/2+j] = temp[j]; //���м��зֲ���
			}
		}
		format = new String(b);
		return format;
	}
	
	public static String setFormatAlign(String model, String source){
		String format = null;
		int lenSource = 0; //����Դ
		int space = 0; //�ո���
		
		byte[] b = new byte[72]; //��ʼ������г���72
		for(int i=0;i<72;i++){
			b[i] = 32;
		}
		byte c[] = model.getBytes(); //��ģ���ж�ȡ
		while(c[space]==32){
			space++; //ģ��ǰ���հ׵���Ŀ
		}
		lenSource = source.getBytes().length; //����Դ����
		byte[] temp = source.getBytes(); //������ʱbyte����
		for(int j=0; j<lenSource; j++){ //������в�������
			b[space+j] = temp[j]; //�Ƚ�ģ��ӵ�һ����Ϊ����ֽڴ�����
		}
		format = new String(b);
		return format;
	}
	
	public static String setFormatAlign(int space, String source){
		String format = null;
		int lenSource = 0; //����Դ

		byte[] b = new byte[72]; //��ʼ������г���72
		for(int i=0;i<72;i++){
			b[i] = 32;
		}
		lenSource = source.getBytes().length; //����Դ����
		if(space<0 || (space+lenSource>70)){
			space=0;
		}
		byte[] temp = source.getBytes(); //������ʱbyte����
		for(int j=0; j<lenSource; j++){ //������в�������
			b[space+j] = temp[j]; //�Ƚ�ģ��ӵ�һ����Ϊ����ֽڴ�����
		}
		format = new String(b);
		return format;
	}
	
	public static String setFormatFull(String str){
		String format = null;
		byte[] b = new byte[72]; //��ʼ������г���72
		for(int i=0;i<72;i++){
			b[i] = 32;
		}
		byte[] c = str.getBytes();//���ַ�ת��Ϊ�ֽ�
		if(c.length>4){//����ַ�����
			c = new byte[1];
			c[0] = 32; //�ÿո����
		}
		for(int j=0;j<72;j=j+c.length){//���ַ���ռ�ֽ�������
			for(int k=0;k<c.length;k++){
				b[j+k] = c[k];//���ַ�Դ��������
			}
		}
		format = new String(b);
		return format;
	}	
	public static void main(String args[]){
		String str = "��";
		String f = PrintFormat.setFormatFull(str);
		System.out.println(f);
	}
}
