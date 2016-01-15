package ycui.projet.pgp.lang;

 class Lang_CH extends Language{

	private static final LangType type = LANG.LangType.Lang_CH;
	public Lang_CH(){
		super(type);		
		super.setDEFAULTINFO(this.DEFAULTINFO);
		super.setCHOICE(this.CHOICE);
		super.setM00_00(this.M00_00);
		super.setM00_01(this.M00_01); 
		super.setM00_02(this.M00_02);
		super.setM00_03(this.M00_03);
		super.setM00_04(this.M00_04);
		super.setM01_00_R01(this.M01_00_R01);
		super.setM01_01_R01(this.M01_01_R01); 
		super.setM01_02_R01(this.M01_02_R01);
		super.setM01_03_R01(this.M01_03_R01);
		super.setM01_04_R01(this.M01_04_R01); 
		super.setM01_05_R01(this.M01_05_R01); 
		super.setM01_06_R01(this.M01_06_R01);
		super.setM01_00_R02(this.M01_00_R02); 
		super.setM01_01_R02(this.M01_01_R02); 
		super.setM01_02_R02(this.M01_02_R02);
		super.setM01_03_R02(this.M01_03_R02); 
		super.setM01_04_R02(this.M01_04_R02);
		super.setM01_05_R02(this.M01_05_R02);
		super.setM01_06_R02(this.M01_06_R02);
		super.setM02_00_R01(this.M02_00_R01);
		super.setM02_01_R01(this.M02_01_R01);
		super.setM02_02_R01(this.M02_02_R01); 
		super.setM02_03_R01(this.M02_03_R01);
		super.setM02_04_R01(this.M02_04_R01); 
		super.setM02_05_R01(this.M02_05_R01); 
		super.setM02_00_R02(this.M02_00_R02);
		super.setM02_01_R02(this.M02_01_R02);
		super.setM02_02_R02(this.M02_02_R02);
		super.setM02_03_R02(this.M02_03_R02);
		super.setM02_04_R02(this.M02_04_R02);
		super.setM02_05_R02(this.M02_05_R02);
	}
	
/*CH elements*/
	private final String PLS = "多个";
	private final String SIG = "一个";
	private final String ALL = "所有";

/*role*/
	private final String R01A = "员工";
	private final String R01S = SIG+"员工";		
	private final String R01P = PLS+"员工";
	private final String R01T = ALL+"员工";
	
	
	private final String R02A = "学生";
	private final String R02S = SIG+"学生";
	private final String R02P = PLS+"学生";
	private final String R02T = ALL+"学生";
/*system*/	
	private final String GEST = "管理";
	private final String INFO = "信息";
	private final String LKG = "显示";
	private final String CRT = "添加";
	private final String UPD = "修改";
	private final String RSC = "查找";	
	private final String DLT = "删除";
	private final String BACK = "返回到";
	private final String HOME = "主菜单";
	private final String PREV = "上级菜单";
	private final String RESULT = "操作结果";
	

	
	private final String DEFAULTINFO = "请输入正确的选择！";
	private final String CHOICE = "\n请选择：";
	private final String LIST = "列表";
	private final String EMPTY = "空";
	
/*menu*/
	private final String M00_00 = INFO+GEST+"系统";
	private final String M00_01 = NUM01+R01A+GEST;
	private final String M00_02 = NUM02+R02A+GEST;
	private final String M00_03 = NUM03+LKG+"所有人员"+INFO;
	private final String M00_04 = NUM04+"退出系统";
	
	private final String M01_00_R01 = R01A+GEST;
	private final String M01_01_R01 = NUM01+CRT+R01S;
	private final String M01_02_R01 = NUM02+LKG+R01T;
	private final String M01_03_R01 = NUM03+RSC+R01A+INFO;
	private final String M01_04_R01 = NUM04+DLT+R01S;
	private final String M01_05_R01 = NUM05+UPD+R01S;
	private final String M01_06_R01 = NUM06+BACK+HOME; 
	
	private final String M01_00_R02 = R02A+GEST;
	private final String M01_01_R02 = NUM01+CRT+R02S;
	private final String M01_02_R02 = NUM02+LKG+R02T;
	private final String M01_03_R02 = NUM03+RSC+R02A+INFO;
	private final String M01_04_R02 = NUM04+DLT+R02S;
	private final String M01_05_R02 = NUM05+UPD+R02S;
	private final String M01_06_R02 = NUM06+BACK+HOME;  
	
	private final String M02_00_R01 = RSC+R01A+INFO;
	private final String M02_01_R01 = NUM01+RSC+R01T;
	private final String M02_02_R01 = NUM02+"通过ID"+RSC+R01A;
	private final String M02_03_R01 = NUM03+"通过关键字"+RSC+R01A;
	private final String M02_04_R01 = NUM04+BACK+PREV;
	private final String M02_05_R01 = NUM05+BACK+HOME;
	
	private final String M02_00_R02 = RSC+R02A+INFO;
	private final String M02_01_R02 = NUM01+RSC+R02T;
	private final String M02_02_R02 = NUM02+"通过ID"+RSC+R02A;
	private final String M02_03_R02 = NUM03+"通过关键字"+RSC+R02A;
	private final String M02_04_R02 = NUM04+BACK+PREV;
	private final String M02_05_R02 = NUM05+BACK+HOME;

/*Exception*/
	private final String EX1 = "";
}
