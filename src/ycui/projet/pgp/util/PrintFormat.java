package ycui.projet.pgp.util;

public class PrintFormat {
	public static String setFormatCenter(String source){
		String format = null; 
		int lenSource = 0; //数据源
		int space = 0; //空格数
		
		byte[] b = new byte[72]; //初始化输出列长度72
		for(int i=0;i<72;i++){
			b[i] = 32;
		}
		lenSource = source.getBytes().length; //数据源长度
		space = 70 - lenSource; //补足空格数，前后留1byte
		if(space>0){ //如果源字符数小于等于76
			byte[] temp = source.getBytes(); //存入临时byte数组
			for(int j=0; j<lenSource; j++){ //往输出列插入数据
				b[36-lenSource/2+j] = temp[j]; //从中间切分插入
			}
		}
		format = new String(b);
		return format;
	}
	
	public static String setFormatAlign(String model, String source){
		String format = null;
		int lenSource = 0; //数据源
		int space = 0; //空格数
		
		byte[] b = new byte[72]; //初始化输出列长度72
		for(int i=0;i<72;i++){
			b[i] = 32;
		}
		byte c[] = model.getBytes(); //从模板中读取
		while(c[space]==32){
			space++; //模板前补空白的数目
		}
		lenSource = source.getBytes().length; //数据源长度
		byte[] temp = source.getBytes(); //存入临时byte数组
		for(int j=0; j<lenSource; j++){ //往输出列插入数据
			b[space+j] = temp[j]; //比较模板从第一个不为零的字节处插入
		}
		format = new String(b);
		return format;
	}
	
	public static String setFormatAlign(int space, String source){
		String format = null;
		int lenSource = 0; //数据源

		byte[] b = new byte[72]; //初始化输出列长度72
		for(int i=0;i<72;i++){
			b[i] = 32;
		}
		lenSource = source.getBytes().length; //数据源长度
		if(space<0 || (space+lenSource>70)){
			space=0;
		}
		byte[] temp = source.getBytes(); //存入临时byte数组
		for(int j=0; j<lenSource; j++){ //往输出列插入数据
			b[space+j] = temp[j]; //比较模板从第一个不为零的字节处插入
		}
		format = new String(b);
		return format;
	}
	
	public static String setFormatFull(String str){
		String format = null;
		byte[] b = new byte[72]; //初始化输出列长度72
		for(int i=0;i<72;i++){
			b[i] = 32;
		}
		byte[] c = str.getBytes();//把字符转换为字节
		if(c.length>4){//如果字符过长
			c = new byte[1];
			c[0] = 32; //用空格填充
		}
		for(int j=0;j<72;j=j+c.length){//按字符所占字节数迭代
			for(int k=0;k<c.length;k++){
				b[j+k] = c[k];//把字符源插入序列
			}
		}
		format = new String(b);
		return format;
	}	
	public static void main(String args[]){
		String str = "è";
		String f = PrintFormat.setFormatFull(str);
		System.out.println(f);
	}
}
