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
	private final String PLS = "���";
	private final String SIG = "һ��";
	private final String ALL = "����";

/*role*/
	private final String R01A = "Ա��";
	private final String R01S = SIG+"Ա��";		
	private final String R01P = PLS+"Ա��";
	private final String R01T = ALL+"Ա��";
	
	
	private final String R02A = "ѧ��";
	private final String R02S = SIG+"ѧ��";
	private final String R02P = PLS+"ѧ��";
	private final String R02T = ALL+"ѧ��";
/*system*/	
	private final String GEST = "����";
	private final String INFO = "��Ϣ";
	private final String LKG = "��ʾ";
	private final String CRT = "���";
	private final String UPD = "�޸�";
	private final String RSC = "����";	
	private final String DLT = "ɾ��";
	private final String BACK = "���ص�";
	private final String HOME = "���˵�";
	private final String PREV = "�ϼ��˵�";
	private final String RESULT = "�������";
	

	
	private final String DEFAULTINFO = "��������ȷ��ѡ��";
	private final String CHOICE = "\n��ѡ��";
	private final String LIST = "�б�";
	private final String EMPTY = "��";
	
/*menu*/
	private final String M00_00 = INFO+GEST+"ϵͳ";
	private final String M00_01 = NUM01+R01A+GEST;
	private final String M00_02 = NUM02+R02A+GEST;
	private final String M00_03 = NUM03+LKG+"������Ա"+INFO;
	private final String M00_04 = NUM04+"�˳�ϵͳ";
	
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
	private final String M02_02_R01 = NUM02+"ͨ��ID"+RSC+R01A;
	private final String M02_03_R01 = NUM03+"ͨ���ؼ���"+RSC+R01A;
	private final String M02_04_R01 = NUM04+BACK+PREV;
	private final String M02_05_R01 = NUM05+BACK+HOME;
	
	private final String M02_00_R02 = RSC+R02A+INFO;
	private final String M02_01_R02 = NUM01+RSC+R02T;
	private final String M02_02_R02 = NUM02+"ͨ��ID"+RSC+R02A;
	private final String M02_03_R02 = NUM03+"ͨ���ؼ���"+RSC+R02A;
	private final String M02_04_R02 = NUM04+BACK+PREV;
	private final String M02_05_R02 = NUM05+BACK+HOME;

/*Exception*/
	private final String EX1 = "";
}
