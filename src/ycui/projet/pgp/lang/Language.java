package ycui.projet.pgp.lang;

import ycui.projet.pgp.util.PrintFormat;

public abstract class Language implements LANG {
	protected LangType type = LANG.LangType.Lang_EN;
	private static final int space = 20; 
	
	public Language(){
		this.setType(type);
	}
	public Language(LangType lt){
		this.setType(lt);
	}
	public LangType getType() {
		return type;
	}
	public void setType(LangType type) {
		this.type = type;
	}

/*menu*/
	private String DEFAULTINFO;
	private String CHOICE;
	
	private String M00_00;
	private String M00_01;
	private String M00_02;
	private String M00_03;
	private String M00_04;
	
	private String M01_00_R01;
	private String M01_01_R01;
	private String M01_02_R01;
	private String M01_03_R01;
	private String M01_04_R01;
	private String M01_05_R01;
	private String M01_06_R01; 
	
	private String M01_00_R02;
	private String M01_01_R02;
	private String M01_02_R02;
	private String M01_03_R02;
	private String M01_04_R02;
	private String M01_05_R02;
	private String M01_06_R02;
	
	private String M02_00_R01;
	private String M02_01_R01;
	private String M02_02_R01;
	private String M02_03_R01;
	private String M02_04_R01;
	private String M02_05_R01;
	
	private String M02_00_R02;
	private String M02_01_R02;
	private String M02_02_R02;
	private String M02_03_R02;
	private String M02_04_R02;
	private String M02_05_R02;

/*setter*/
	protected void setDEFAULTINFO(String dEFAULTINFO) {
		DEFAULTINFO = dEFAULTINFO;
	}
	protected void setCHOICE(String cHOICE) {
		CHOICE = cHOICE;
	}
	protected void setM00_00(String m00_00) {
		M00_00 = m00_00;
	}
	protected void setM00_01(String m00_01) {
		M00_01 = m00_01;
	}
	protected void setM00_02(String m00_02) {
		M00_02 = m00_02;
	}
	protected void setM00_03(String m00_03) {
		M00_03 = m00_03;
	}
	protected void setM00_04(String m00_04) {
		M00_04 = m00_04;
	}
	protected void setM01_00_R01(String m01_00_R01) {
		M01_00_R01 = m01_00_R01;
	}
	protected void setM01_01_R01(String m01_01_R01) {
		M01_01_R01 = m01_01_R01;
	}
	protected void setM01_02_R01(String m01_02_R01) {
		M01_02_R01 = m01_02_R01;
	}
	protected void setM01_03_R01(String m01_03_R01) {
		M01_03_R01 = m01_03_R01;
	}
	protected void setM01_04_R01(String m01_04_R01) {
		M01_04_R01 = m01_04_R01;
	}
	protected void setM01_05_R01(String m01_05_R01) {
		M01_05_R01 = m01_05_R01;
	}
	protected void setM01_06_R01(String m01_06_R01) {
		M01_06_R01 = m01_06_R01;
	}
	protected void setM01_00_R02(String m01_00_R02) {
		M01_00_R02 = m01_00_R02;
	}
	protected void setM01_01_R02(String m01_01_R02) {
		M01_01_R02 = m01_01_R02;
	}
	protected void setM01_02_R02(String m01_02_R02) {
		M01_02_R02 = m01_02_R02;
	}
	protected void setM01_03_R02(String m01_03_R02) {
		M01_03_R02 = m01_03_R02;
	}
	protected void setM01_04_R02(String m01_04_R02) {
		M01_04_R02 = m01_04_R02;
	}
	protected void setM01_05_R02(String m01_05_R02) {
		M01_05_R02 = m01_05_R02;
	}
	protected void setM01_06_R02(String m01_06_R02) {
		M01_06_R02 = m01_06_R02;
	}
	protected void setM02_00_R01(String m02_00_R01) {
		M02_00_R01 = m02_00_R01;
	}
	protected void setM02_01_R01(String m02_01_R01) {
		M02_01_R01 = m02_01_R01;
	}
	protected void setM02_02_R01(String m02_02_R01) {
		M02_02_R01 = m02_02_R01;
	}
	protected void setM02_03_R01(String m02_03_R01) {
		M02_03_R01 = m02_03_R01;
	}
	protected void setM02_04_R01(String m02_04_R01) {
		M02_04_R01 = m02_04_R01;
	}
	protected void setM02_05_R01(String m02_05_R01) {
		M02_05_R01 = m02_05_R01;
	}
	protected void setM02_00_R02(String m02_00_R02) {
		M02_00_R02 = m02_00_R02;
	}
	protected void setM02_01_R02(String m02_01_R02) {
		M02_01_R02 = m02_01_R02;
	}
	protected void setM02_02_R02(String m02_02_R02) {
		M02_02_R02 = m02_02_R02;
	}
	protected void setM02_03_R02(String m02_03_R02) {
		M02_03_R02 = m02_03_R02;
	}
	protected void setM02_04_R02(String m02_04_R02) {
		M02_04_R02 = m02_04_R02;
	}
	protected void setM02_05_R02(String m02_05_R02) {
		M02_05_R02 = m02_05_R02;
	}

/*getter*/	
	public String getDEFAULTINFO() {
		return DEFAULTINFO;
	}
	public String getCHOICE() {
		return CHOICE;
	}
	public String getM00_00() {
		return PrintFormat.setFormatCenter(M00_00);
	}
	public String getM00_01() {
		return PrintFormat.setFormatAlign(space,M00_01);
	}
	public String getM00_02() {
		return PrintFormat.setFormatAlign(space,M00_02);
	}
	public String getM00_03() {
		return PrintFormat.setFormatAlign(space,M00_03);
	}
	public String getM00_04() {
		return PrintFormat.setFormatAlign(space,M00_04);
	}
	public String getM01_00_R01() {
		return PrintFormat.setFormatCenter(M01_00_R01);
	}
	public String getM01_01_R01() {
		return PrintFormat.setFormatAlign(space,M01_01_R01);
	}
	public String getM01_02_R01() {
		return PrintFormat.setFormatAlign(space,M01_02_R01);
	}
	public String getM01_03_R01() {
		return PrintFormat.setFormatAlign(space,M01_03_R01);
	}
	public String getM01_04_R01() {
		return PrintFormat.setFormatAlign(space,M01_04_R01);
	}
	public String getM01_05_R01() {
		return PrintFormat.setFormatAlign(space,M01_05_R01);
	}
	public String getM01_06_R01() {
		return PrintFormat.setFormatAlign(space,M01_06_R01);
	}
	public String getM01_00_R02() {
		return PrintFormat.setFormatCenter(M01_00_R02);
	}
	public String getM01_01_R02() {
		return PrintFormat.setFormatAlign(space,M01_01_R02);
	}
	public String getM01_02_R02() {
		return PrintFormat.setFormatAlign(space,M01_02_R02);
	}
	public String getM01_03_R02() {
		return PrintFormat.setFormatAlign(space,M01_03_R02);
	}
	public String getM01_04_R02() {
		return PrintFormat.setFormatAlign(space,M01_04_R02);
	}
	public String getM01_05_R02() {
		return PrintFormat.setFormatAlign(space,M01_05_R02);
	}
	public String getM01_06_R02() {
		return PrintFormat.setFormatAlign(space,M01_06_R02);
	}
	public String getM02_00_R01() {
		return PrintFormat.setFormatCenter(M02_00_R01);
	}
	public String getM02_01_R01() {
		return PrintFormat.setFormatAlign(space,M02_01_R01);
	}
	public String getM02_02_R01() {
		return PrintFormat.setFormatAlign(space,M02_02_R01);
	}
	public String getM02_03_R01() {
		return PrintFormat.setFormatAlign(space,M02_03_R01);
	}
	public String getM02_04_R01() {
		return PrintFormat.setFormatAlign(space,M02_04_R01);
	}
	public String getM02_05_R01() {
		return PrintFormat.setFormatAlign(space,M02_05_R01);
	}
	public String getM02_00_R02() {
		return PrintFormat.setFormatCenter(M02_00_R02);
	}
	public String getM02_01_R02() {
		return PrintFormat.setFormatAlign(space,M02_01_R02);
	}
	public String getM02_02_R02() {
		return PrintFormat.setFormatAlign(space,M02_02_R02);
	}
	public String getM02_03_R02() {
		return PrintFormat.setFormatAlign(space,M02_03_R02);
	}
	public String getM02_04_R02() {
		return PrintFormat.setFormatAlign(space,M02_04_R02);
	}
	public String getM02_05_R02() {
		return PrintFormat.setFormatAlign(space,M02_05_R02);
	}
}

