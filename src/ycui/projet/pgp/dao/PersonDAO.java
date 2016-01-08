package ycui.projet.pgp.dao;

import java.util.Set;

import ycui.projet.pgp.exception.DAOException;
import ycui.projet.pgp.vo.Person;


//定义具体的数据操作方法
public interface PersonDAO {
	/**
	 * Insérer une donnée.
	 * 
	 * @author YCUI
	 * 
	 * @param person 
	 * 			Opération d'un objet.
	 * @return 
	 * 			true: insertion réussi; false: insertion échoué.
	 * @throws DAOException 
	 */
	public boolean doCreate(Person person) throws DAOException;
	
	/**
	 * Modifier une donnée.
	 * 
	 * @author YCUI
	 * 
	 * @param person 
	 * 			Opération d'un objet.
	 * @return 
	 * 			true: modification réussi; false: modification échoué.
	 * 
	 * @throws DAOException 
	 */
	public boolean doUpdate(Person person) throws DAOException;
	
	/**
	 * Supprimer une donnée par rapoort au ID.
	 * @author YCUI
	 * 
	 * @param id 
	 * 			Opération d'un objet.
	 * @return 
	 * 			true: suppression réussi; false: suppression échoué.
	 * 
	 * @throws DAOException 
	 */
	public boolean doDelete(String id) throws DAOException;
	
	/**
	 * Supprimer tous les données.
	 * @author YCUI
	 * 
	 * @return 
	 * 			true: suppression réussi; false: suppression échoué.
	 * 
	 * @throws DAOException 
	 */
	public boolean doDeleteAll() throws DAOException;
	
	/**
	 * Rechercher une liste de donnée.
	 * 
	 * @author YCUI
	 * 
	 * @return 
	 * 			une liste de Person.
	 * 
	 * @throws DAOException 
	 */
	public Set<Person> findAll() throws DAOException;
	
	/**
	 * Rechercher une donnée par rapoort au ID.
	 * 
	 * @author YCUI
	 * 
	 * @param id 
	 * 			String id de Person 
	 * @return 
	 * 			une Person.
	 * 
	 * @throws DAOException 
	 */
	public Person findById(String id) throws DAOException;
	
	/**
	 * Rechercher une liste de donnée par rapoort au mot clé.
	 * 
	 * @author YCUI
	 * 
	 * @return 
	 * 			une liste de Person.
	 * 
	 * @throws DAOException 
	 */
	public Set<Person> findByKey(String keyWord) throws DAOException;
	


}
