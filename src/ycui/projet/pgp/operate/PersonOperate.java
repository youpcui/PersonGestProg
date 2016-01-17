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
	 * Ajouter les donn¨¦es.
	 */
	public MessageProxy add(){return null;}

	/**
	 * Modifier les donn¨¦es.
	 */
	public MessageProxy update(){return null;}

	/**
	 * Rechercher tous les donn¨¦es.
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
		mp.setStatus(!nobodyW || !nobodyS);
		if(mp.isStatus()){
			mp.setMessage(PrintFormat.setFormatCenter(lang.getProperty("RESULT"))
					+ "\n"
					+ PrintFormat.setFormatFull(SEPARATOR)+"\n"
					+ bufW.toString()
					+ "\n"
					+ bufS.toString()
					+ PrintFormat.setFormatFull(SEPARATOR));
		}else{
			mp.setMessage(SYSINFO + lang.getProperty("PO_03_KO")); //LIST EMPTY
		}
		return mp;
	}

	/**
	 * Rechercher une donn¨¦e par id 
	 */
	public MessageProxy findById(){return null;}

	/**
	 * REchercher une donn¨¦e par mot cl¨¦
	 */
	public MessageProxy findByKey(){return null;}

	/**
	 * Supprimer une donn¨¦e
	 */
	public MessageProxy delete(){return null;}

	/**
	 * Supprimer tous les donn¨¦es
	 */
	public MessageProxy deleteAll(){
		MessageProxy mp = new MessageProxy();
		boolean flag = false;
		try {
			flag = this.dao.doDeleteAll();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		mp.setStatus(flag);
		if(mp.isStatus()){
			mp.setMessage(lang.getProperty("PO_04_OK"));
		}else{
			mp.setMessage(lang.getProperty("PO_04_KO"));
		}
		return mp;
	}
}
