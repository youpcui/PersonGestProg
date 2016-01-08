package ycui.projet.pgp.dao;

import java.util.Set;

import ycui.projet.pgp.exception.DAOException;
import ycui.projet.pgp.vo.Person;


//�����������ݲ�������
public interface PersonDAO {
	/**
	 * Ins��rer une donn��e.
	 * 
	 * @author YCUI
	 * 
	 * @param person 
	 * 			Op��ration d'un objet.
	 * @return 
	 * 			true: insertion r��ussi; false: insertion ��chou��.
	 * @throws DAOException 
	 */
	public boolean doCreate(Person person) throws DAOException;
	
	/**
	 * Modifier une donn��e.
	 * 
	 * @author YCUI
	 * 
	 * @param person 
	 * 			Op��ration d'un objet.
	 * @return 
	 * 			true: modification r��ussi; false: modification ��chou��.
	 * 
	 * @throws DAOException 
	 */
	public boolean doUpdate(Person person) throws DAOException;
	
	/**
	 * Supprimer une donn��e par rapoort au ID.
	 * @author YCUI
	 * 
	 * @param id 
	 * 			Op��ration d'un objet.
	 * @return 
	 * 			true: suppression r��ussi; false: suppression ��chou��.
	 * 
	 * @throws DAOException 
	 */
	public boolean doDelete(String id) throws DAOException;
	
	/**
	 * Supprimer tous les donn��es.
	 * @author YCUI
	 * 
	 * @return 
	 * 			true: suppression r��ussi; false: suppression ��chou��.
	 * 
	 * @throws DAOException 
	 */
	public boolean doDeleteAll() throws DAOException;
	
	/**
	 * Rechercher une liste de donn��e.
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
	 * Rechercher une donn��e par rapoort au ID.
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
	 * Rechercher une liste de donn��e par rapoort au mot cl��.
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
