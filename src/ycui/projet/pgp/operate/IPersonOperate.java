package ycui.projet.pgp.operate;

import ycui.projet.pgp.lang.LANG;
import ycui.projet.pgp.proxy.MessageProxy;

public interface IPersonOperate extends LANG{
	public static final String RESULTHEAD = "\n------------------------R¨¦sultat------------------------\n";
	public static final String RESULTEND = "--------------------------------------------------------\n";

	/**
	 * Ajouter les donn¨¦es.
	 */
	public void add();

	/**
	 * Modifier les donn¨¦es.
	 */
	public void update();

	/**
	 * Rechercher tous les donn¨¦es.
	 */
	public MessageProxy findAll();

	/**
	 * Rechercher une donn¨¦e par id 
	 */
	public void findById();

	/**
	 * REchercher une donn¨¦e par mot cl¨¦
	 */
	public void findByKey();

	/**
	 * Supprimer une donn¨¦e
	 */
	public void delete();
}
