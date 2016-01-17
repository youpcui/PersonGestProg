package ycui.projet.pgp.lang.property;

public interface FR{
	
	/* FR elements */
	public static final String L1 = " le";
	public static final String L2 = " la";
	public static final String L3 = " les";
	public static final String L4 = " l'";

	public static final String D1 = " de";
	public static final String D2 = " du";
	public static final String D3 = " des";
	public static final String D4 = " d'";

	public static final String A1 = " ¨¤";
	public static final String A2 = " au";
	public static final String A3 = " aux";

	public static final String FEM = "(e)";
	public static final String PLS = "(s)";
	public static final String SIG = " un" + FEM;
	
	public static final String NOT = " pas";
	public static final String BE = " est";
	public static final String BES = " sont";
	public static final String ALL = " tous";
	

	/* role */
	public static final String R01A = " employ¨¦" + FEM;// employ¨¦(e)
	public static final String R01B = D4 + R01A;// d'employ¨¦(e)
	public static final String R01C = L4 + R01A;// l'employ¨¦(e)
	public static final String R01S = SIG + R01A;// un(e) employ¨¦(e)
	public static final String R01P = D3 + R01A + PLS;// des employ¨¦(e)(s)
	public static final String R01Q = L3 + R01A + PLS;// les employ¨¦(e)(s)

	public static final String R02A = " ¨¦tudiant" + FEM;// ¨¦tudiant(e)
	public static final String R02B = D4 + R02A;// d'¨¦tudiant(e)
	public static final String R02C = L4 + R02A;// l'employ¨¦(e)
	public static final String R02S = SIG + R02A;// un(e) ¨¦tudiant(e)
	public static final String R02P = D3 + R02A + PLS;// des ¨¦tudiant(e)(s)
	public static final String R02Q = L3 + R02A + PLS;// les ¨¦tudiant(e)(s)

	/* system */
	public static final String GEST = "Gestion";
	public static final String INFO = " information";
	public static final String INPUT = "Saisir";
	public static final String LKG = "Afficher";
	public static final String CRT = "Ajouter";
	public static final String UPD = "Modifier";
	public static final String RSC = "Rechercher";
	public static final String DLT = "Supprimer";
	public static final String LKGN = "Affichage";
	public static final String CRTN = " ajoute";
	public static final String UPDN = " modification";
	public static final String RSCN = " recherche";
	public static final String DLTN = " suppression";
	public static final String BACK = "Retour";
	public static final String HOME = " l'acceuil";
	public static final String PREV = " pr¨¦c¨¦dant";
	
	public static final String OK= "Succ¨¨s";
	public static final String KO= "Echec";
	


	/*operate*/
	public static final String ID = "ID";
	public static final String NAME = "NOM";
	public static final String AGE = "AGE";
	public static final String SALARY = "SALAIRE";
	public static final String SCORE = "NOTES";
	
	public static final String RESULT = "R¨¦sultat";
	public static final String LIST = "La liste";
	public static final String EMPTY = " est vide.";
	

}
