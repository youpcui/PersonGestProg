package ycui.projet.pgp.operate;

import ycui.projet.pgp.dao.PersonDAO;
import ycui.projet.pgp.util.InputData;

public abstract class PersonOperate {
	protected PersonDAO dao = null;
	protected InputData input = null;
	
	public PersonOperate(){

	}
	/**
	 * Ajouter les donn¨¦es.
	 */
	public abstract void add();

	/**
	 * Modifier les donn¨¦es.
	 */
	public abstract void update();

	/**
	 * Rechercher tous les donn¨¦es.
	 */
	public abstract void findAll();

	/**
	 * Rechercher une donn¨¦e par id 
	 */
	public abstract void findById();

	/**
	 * REchercher une donn¨¦e par mot cl¨¦
	 */
	public abstract void findByKey();

	/**
	 * Supprimer une donn¨¦e
	 */
	public abstract void delete();

	/**
	 * Supprimer tous les donn¨¦es
	 */
	public abstract void deleteAll();
}
