package ycui.projet.pgp.lang;

 class Lang_FR extends Language{

	private static final LangType type = LANG.LangType.Lang_FR;
	public Lang_FR(){
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
	
/*FR elements*/
	private final String L1 = " le";
	private final String L2 = " la";
	private final String L3 = " les";
	private final String L4 = " l'";
	
	private final String D1 = " de";
	private final String D2 = " du";
	private final String D3 = " des";
	private final String D4 = " d'";
	
	private final String A1 = " ¨¤";
	private final String A2 = " au";
	private final String A3 = " aux";

	private final String FEM = "(e)";
	private final String PLS = "(s)";
	private final String SIG = " un"+FEM;

/*role*/
	private final String R01A = " employ¨¦"+FEM;//employ¨¦(e)
	private final String R01B = D4+R01A;//d'employ¨¦(e)
	private final String R01S = SIG+R01A;//un(e) employ¨¦(e)
	private final String R01P = D3+R01A+PLS;//des employ¨¦(e)(s)
	private final String R01Q = L3+R01A+PLS;//les employ¨¦(e)(s)
	
	private final String R02A = " ¨¦tudiant"+FEM;//¨¦tudiant(e)
	private final String R02B = D4+R02A;//d'¨¦tudiant(e)
	private final String R02S = SIG+R02A;//un(e) ¨¦tudiant(e)
	private final String R02P = D3+R02A+PLS;//des ¨¦tudiant(e)(s)
	private final String R02Q = L3+R02A+PLS;//les ¨¦tudiant(e)(s)

/*system*/	
	private final String GEST = "Gestion";
	private final String INFO = " information";
	private final String LKG = "Afficher";
	private final String CRT = "Ajouter";
	private final String UPD = "Modifier";
	private final String RSC = "Rechercher";	
	private final String DLT = "Supprimer";
	private final String LKGN = "Affichage";
	private final String CRTN = "Ajoute";
	private final String UPDN = "Modification";
	private final String RSCN = "Recherche";	
	private final String DLTN = "Suppression";
	private final String BACK = "Retour";
	private final String HOME = " l'acceuil";
	private final String PREV = " pr¨¦c¨¦dant";
	private final String RESULT = "R¨¦sltat";

	

	
	private final String DEFAULTINFO = "Veuillez saisir un choix correct!";
	private final String CHOICE = "\nChoisir le num¨¦ro:";
	private final String LIST = "La liste ";
	private final String EMPTY = " est vide.";
	
/*menu*/
	private final String M00_00 = "Syst¨¨me"+D1+" gestion"+D4+INFO;
	private final String M00_01 = NUM01+GEST+R01P;
	private final String M00_02 = NUM02+GEST+R02P;
	private final String M00_03 = NUM03+LKG+" tous personnes";
	private final String M00_04 = NUM04+"Sortie";
	
	private final String M01_00_R01 = GEST+R01P;
	private final String M01_01_R01 = NUM01+CRT+R01S;
	private final String M01_02_R01 = NUM02+LKG+R01Q;
	private final String M01_03_R01 = NUM03+RSC+L4+INFO+R01P;
	private final String M01_04_R01 = NUM04+DLT+R01S;
	private final String M01_05_R01 = NUM05+UPD+L4+INFO+R01B;
	private final String M01_06_R01 = NUM06+BACK+A1+HOME; 
	
	private final String M01_00_R02 = GEST+R02P;
	private final String M01_01_R02 = NUM01+CRT+R02S;
	private final String M01_02_R02 = NUM02+LKG+R02Q;
	private final String M01_03_R02 = NUM03+RSC+L4+INFO+R02P;
	private final String M01_04_R02 = NUM04+DLT+R02S;
	private final String M01_05_R02 = NUM05+UPD+L4+INFO+R02B;
	private final String M01_06_R02 = NUM06+BACK+A1+HOME; 
	
	private final String M02_00_R01 = RSC+L4+INFO+R01P;
	private final String M02_01_R01 = NUM01+RSC+" tous";
	private final String M02_02_R01 = NUM02+RSC+" par id";
	private final String M02_03_R01 = NUM03+RSC+" par mot cl¨¦";
	private final String M02_04_R01 = NUM04+BACK+A2+PREV;
	private final String M02_05_R01 = NUM05+BACK+A1+HOME;
	
	private final String M02_00_R02 = RSC+L4+INFO+R02P;
	private final String M02_01_R02 = NUM01+RSC+" tous";
	private final String M02_02_R02 = NUM02+RSC+" par id";
	private final String M02_03_R02 = NUM03+RSC+" par mot cl¨¦";
	private final String M02_04_R02 = NUM04+BACK+A2+PREV;
	private final String M02_05_R02 = NUM05+BACK+A1+HOME;

/*Exception*/
	private final String EX1 = "";
}
