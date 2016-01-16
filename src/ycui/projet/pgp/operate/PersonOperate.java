package ycui.projet.pgp.operate;

import java.util.Iterator;

import ycui.projet.pgp.dao.PersonDAO;
import ycui.projet.pgp.exception.DAOException;
import ycui.projet.pgp.lang.Language;
import ycui.projet.pgp.lang.LanguageFactory;
import ycui.projet.pgp.proxy.MessageProxy;
import ycui.projet.pgp.proxy.PersonDAOProxyFile;
import ycui.projet.pgp.util.InputData;
import ycui.projet.pgp.util.PrintFormat;
import ycui.projet.pgp.vo.Person;
import ycui.projet.pgp.vo.Student;
import ycui.projet.pgp.vo.Worker;

public class PersonOperate implements IPersonOperate{
	protected PersonDAO dao = null;
	protected InputData input = null;
	protected Language lang = null;

	public PersonOperate(LangType type){
		this.dao = new PersonDAOProxyFile();
		this.input = new InputData();
		this.lang = LanguageFactory.getLanguage(type);
	}
	/**
	 * Ajouter les données.
	 */
	public void add(){}

	/**
	 * Modifier les données.
	 */
	public void update(){}

	/**
	 * Rechercher tous les données.
	 * @return 
	 */
	public MessageProxy findAll(){
		StringBuffer bufW = new StringBuffer("");
		StringBuffer bufS = new StringBuffer("");
		boolean nobodyW = true;
		boolean nobodyS = true;
		MessageProxy mp = new MessageProxy();

		try {
			Iterator<Person> iter = this.dao.doFindAll().iterator();
			while(iter.hasNext()){
				Person p = (Person) iter.next();
				if(p instanceof Worker){
					nobodyW = false;
					if(bufW.length() == 0){
						bufW.append(lang.getProperty("WORKERHEAD"));
					}
					bufW.append(p.toString());
					bufW.append("\n");
				}else if(p instanceof Student){
					nobodyS = false;
					if(bufS.length() == 0){
						bufS.append(lang.getProperty("STUDENTHEAD"));
					}
					bufS.append(p.toString());
					bufS.append("\n");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!nobodyW || !nobodyS){
			mp.setData(PrintFormat.setFormatCenter(lang.getProperty("RESULT"))
					+ "\n"
					+ PrintFormat.setFormatFull(SEPARATOR)
					+ bufW.toString()
					+ "\n"
					+ bufS.toString()
					+ PrintFormat.setFormatFull(SEPARATOR));
		}
			mp.setMessage(lang.getProperty("PO_F_EX1")); //LIST EMPTY
/*
		System.out.println(lang.getProperty("RESULT")
				+ PrintFormat.setFormatFull(SEPARATOR)
				+ (nobodyW?("-->La liste d'étudiant est vide.\n"):bufW.toString())
				+ "\n"
				+ (nobodyS?("-->La liste d'étudiant est vide.\n"):bufS.toString())
				+ RESULTEND); 
*/		
		return mp;
	}

	/**
	 * Rechercher une donnée par id 
	 */
	public void findById(){}

	/**
	 * REchercher une donnée par mot clé
	 */
	public void findByKey(){}

	/**
	 * Supprimer une donnée
	 */
	public void delete(){}

	/**
	 * Supprimer tous les données
	 */
	public void deleteAll(){
		boolean flag = false;
		try {
			this.dao.doDeleteAll();
			flag = true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(RESULTHEAD
				+ "Tous les personnes" // 员工名字
				+ (flag?" est bien ":" n'est pas ")//成功与否
				+ "supprimé(e).\n" + RESULTEND);
		
	}
}
