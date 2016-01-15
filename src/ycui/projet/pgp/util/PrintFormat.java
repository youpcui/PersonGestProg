package ycui.projet.pgp.util;

public class PrintFormat {
	private static final int line = 80;
	public static String setFormatCenter(String source){
		String format = null; 
		int lenSource = 0; //����Դ
		int space = 0; //�ո���
		
		byte[] b = new byte[line]; //��ʼ������г���line
		for(int i=0;i<line;i++){
			b[i] = 32;
		}
		lenSource = source.getBytes().length; //����Դ����
		space = line-2 - lenSource; //����ո�����ǰ����1byte
		if(space>0){ //���Դ�ַ���С�ڵ���line
			byte[] temp = source.getBytes(); //������ʱbyte����
			for(int j=0; j<lenSource; j++){ //������в�������
				b[line/2-lenSource/2+j] = temp[j]; //���м��зֲ���
			}
		}
		format = new String(b);
		return format;
	}
	
	public static String setFormatCenter(String source, int full){
		String format = null; 
		int lenSource = 0; //����Դ
		int space = 0; //�ո���
		
		byte[] b = new byte[line]; //��ʼ������г���line
		for(int i=0;i<line;i++){
			b[i] = (full<32||full>126)?32:(byte) full;
		}
		lenSource = source.getBytes().length; //����Դ����
		space = line-2 - lenSource; //����ո�����ǰ����1byte
		if(space>0){ //���Դ�ַ���С�ڵ���line-2
			byte[] temp = source.getBytes(); //������ʱbyte����
			for(int j=0; j<lenSource; j++){ //������в�������
				b[line/2-lenSource/2+j] = temp[j]; //���м��зֲ���
			}
		}
		format = new String(b);
		return format;
	}
	
	public static String setFormatAlign(String model, String source){
		String format = null;
		int lenSource = 0; //����Դ
		int space = 0; //�ո���
		
		byte[] b = new byte[line]; //��ʼ������г���line
		for(int i=0;i<line;i++){
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

		byte[] b = new byte[line]; //��ʼ������г���line
		for(int i=0;i<line;i++){
			b[i] = 32;
		}
		lenSource = source.getBytes().length; //����Դ����
		if(space<0 || (space+lenSource>line-2)){
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
		byte[] b = new byte[line]; //��ʼ������г���line
		for(int i=0;i<line;i++){
			b[i] = 32;
		}
		byte[] c = str.getBytes();//���ַ�ת��Ϊ�ֽ�
		if(c.length>2){//����ַ�����2λ
			c = new byte[1];
			c[0] = 32; //�ÿո����
		}
		for(int j=0;j<line;j=j+c.length){//���ַ���ռ�ֽ�������
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
