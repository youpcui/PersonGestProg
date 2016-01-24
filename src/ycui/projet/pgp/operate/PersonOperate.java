package ycui.projet.pgp.operate;

import java.util.Iterator;

import ycui.projet.pgp.dao.PersonDAO;
import ycui.projet.pgp.exception.DAOException;
import ycui.projet.pgp.lang.Language;
import ycui.projet.pgp.proxy.*;
import ycui.projet.pgp.util.InputData;
import ycui.projet.pgp.util.PrintFormat;
import ycui.projet.pgp.vo.MessageComm;
import ycui.projet.pgp.vo.Person;
import ycui.projet.pgp.vo.Student;
import ycui.projet.pgp.vo.Worker;

public class PersonOperate implements IPersonOperate{
	protected PersonDAO dao = null;
	protected InputData input = null;
	protected Language lang = null;

	public PersonOperate(LangType type){
		this.dao = new PersonDAOProxyJDBC();
		this.input = new InputData();
		this.lang = new Language(type);
	}
	/**
	 * Ajouter les donn¨¦es.
	 */
	public MessageComm add(){return null;}

	/**
	 * Modifier les donn¨¦es.
	 */
	public MessageComm update(){return null;}

	/**
	 * Rechercher tous les donn¨¦es.
	 * @return 
	 */
	public MessageComm findAll(){
		StringBuffer bufW = new StringBuffer("");
		StringBuffer bufS = new StringBuffer("");
		boolean nobodyW = true;
		boolean nobodyS = true;
		MessageComm mp = new MessageComm();

		try {
			Iterator<Person> iter = this.dao.doFindAll().iterator();
			while(iter.hasNext()){
				Person p = (Person) iter.next();
				if(p instanceof Worker){
					nobodyW = false;
					if(bufW.length() == 0){
						bufW.append(lang.translate("PO_03_R01_HEAD"));
					}
					bufW.append(p.toString());
					bufW.append("\n");
				}else if(p instanceof Student){
					nobodyS = false;
					if(bufS.length() == 0){
						bufS.append(lang.translate("PO_03_R02_HEAD"));
					}
					bufS.append(p.toString());
					bufS.append("\n");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!nobodyW || !nobodyS){
			mp.setMessage(PrintFormat.setFormatCenter(lang.translate("PO_03_RESULT"))
					+ "\n"
					+ PrintFormat.setFormatFull(SEPARATOR)+"\n"
					+ bufW.toString()
					+ "\n"
					+ bufS.toString()
					+ PrintFormat.setFormatFull(SEPARATOR));
		}else{
			mp.setMessage(SYSINFO + lang.translate("PO_03_KO")); //LIST EMPTY
		}
		return mp;
	}

	/**
	 * Rechercher une donn¨¦e par id 
	 */
	public MessageComm findById(){return null;}

	/**
	 * REchercher une donn¨¦e par mot cl¨¦
	 */
	public MessageComm findByKey(){return null;}

	/**
	 * Supprimer une donn¨¦e
	 */
	public MessageComm delete(){
		MessageComm mp = new MessageComm();
		boolean flag = false;
		try {
			flag = this.dao.doDeleteAll();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		mp.setMessage(SYSINFO + (flag?
				lang.translate("PO_04_OK"):
					lang.translate("PO_04_KO")));
		return mp;
	}
}
