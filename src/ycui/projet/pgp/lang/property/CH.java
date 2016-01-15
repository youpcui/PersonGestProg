package ycui.projet.pgp.lang.property;

public interface CH {
/*CH elements*/
	public static final String PLS = "多个";
	public static final String SIG = "一个";
	public static final String ALL = "所有";

/*role*/
	public static final String R01A = "员工";
	public static final String R01S = SIG+"员工";		
	public static final String R01P = PLS+"员工";
	public static final String R01T = ALL+"员工";
	
	
	public static final String R02A = "学生";
	public static final String R02S = SIG+"学生";
	public static final String R02P = PLS+"学生";
	public static final String R02T = ALL+"学生";
/*system*/	
	public static final String GEST = "管理";
	public static final String INFO = "信息";
	public static final String LKG = "显示";
	public static final String CRT = "添加";
	public static final String UPD = "修改";
	public static final String RSC = "查找";	
	public static final String DLT = "删除";
	public static final String BACK = "返回到";
	public static final String HOME = "主菜单";
	public static final String PREV = "上级菜单";
	public static final String RESULT = "操作结果";
	
	public static final String LIST = "列表";
	public static final String EMPTY = "空";
	

/*Exception*/
	public static final String EX1 = "";
}
