package ycui.projet.pgp.operate;

import ycui.projet.pgp.lang.LANG;
import ycui.projet.pgp.proxy.MessageProxy;

public interface IPersonOperate extends LANG{
	/**
	 * Ajouter les donn¨¦es.
	 */
	public MessageProxy add();

	/**
	 * Modifier les donn¨¦es.
	 */
	public MessageProxy update();

	/**
	 * Rechercher tous les donn¨¦es.
	 */
	public MessageProxy findAll();

	/**
	 * Rechercher une donn¨¦e par id 
	 */
	public MessageProxy findById();

	/**
	 * REchercher une donn¨¦e par mot cl¨¦
	 */
	public MessageProxy findByKey();

	/**
	 * Supprimer une donn¨¦e
	 */
	public MessageProxy delete();
}
