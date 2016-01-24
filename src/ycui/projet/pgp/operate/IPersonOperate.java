package ycui.projet.pgp.operate;

import ycui.projet.pgp.lang.LANG;
import ycui.projet.pgp.vo.MessageComm;

public interface IPersonOperate extends LANG{
	/**
	 * Ajouter les donn¨¦es.
	 */
	public MessageComm add();

	/**
	 * Modifier les donn¨¦es.
	 */
	public MessageComm update();

	/**
	 * Rechercher tous les donn¨¦es.
	 */
	public MessageComm findAll();

	/**
	 * Rechercher une donn¨¦e par id 
	 */
	public MessageComm findById();

	/**
	 * REchercher une donn¨¦e par mot cl¨¦
	 */
	public MessageComm findByKey();

	/**
	 * Supprimer une donn¨¦e
	 */
	public MessageComm delete();
}
