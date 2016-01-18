package ycui.projet.pgp.operate;

import java.util.Iterator;

import ycui.projet.pgp.exception.DAOException;
import ycui.projet.pgp.proxy.MessageProxy;
import ycui.projet.pgp.util.*;
import ycui.projet.pgp.vo.Person;
import ycui.projet.pgp.vo.Student;

public class StudentOperate extends PersonOperate {
	public StudentOperate(LangType type) {
		super(type);
	}

	@Override
	public MessageProxy add() {
		MessageProxy mp = new MessageProxy();
		boolean flag = false;
		Student s = null;
		String name;
		int age;
		float score;
		do {
			name = input.getString(lang.translate("PO_00_NAME"));
		} while (name.equals(""));
		do {
			age = input.getInt(lang.translate("PO_00_AGE"));
		} while (age < 0);
		do {
			score = input.getFloat(lang.translate("PO_00_R02_SCORE"));
		} while (score < 0 || score > 20);
		s = new Student(new Stamp("2").getTimeStampRandom(), name, age, score);
		try {
			flag = this.dao.doCreate(s);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		mp.setMessage(SYSINFO
				+ (flag ? lang.translate("PO_01_R02_OK") : lang
						.translate("PO_01_R02_KO")) + s.getName());

		return mp;
	}

	@Override
	public MessageProxy update() {
		MessageProxy mp = new MessageProxy();
		boolean flag = false;
		Person p = null;
		String id = this.input.getString(lang.translate("PO_00_ID"));
		try {
			p = this.dao.doFindById(id);
			if (p != null && p instanceof Student) {
				String name;
				int age;
				float score;
				Student tmp = (Student) p;
				name = input.getString(lang.translate("PO_00_NAME") + "("
						+ tmp.getName() + "?)");
				do {
					age = input.getInt(lang.translate("PO_00_AGE") + "("
							+ tmp.getAge() + "?)");
				} while (age < 0);
				do {
					score = input.getFloat(lang.translate("PO_00_R02_SCORE")
							+ "(" + tmp.getScore() + "?)");
				} while (score < 0 || score > 20);
				Student s = new Student(p.getId(),
						name.equals("") ? tmp.getName() : name, age, score);
				flag = this.dao.doUpdate(s);
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		mp.setMessage(SYSINFO
				+ (flag ? lang.translate("PO_02_R02_OK") : lang
						.translate("PO_02_R02_KO")) + id);
		return mp;
	}

	@Override
	public MessageProxy findAll() {
		MessageProxy mp = new MessageProxy();
		StringBuffer buf = new StringBuffer("");
		boolean nobody = true;
		try {
			Iterator<Person> iter = this.dao.doFindAll().iterator();
			while (iter.hasNext()) {
				Person p = (Person) iter.next();
				if (p instanceof Student) {
					nobody = false;
					if (buf.length() == 0) {
						buf.append(lang.translate("PO_03_R02_HEAD"));
					}
					buf.append(p.toString());
					buf.append("\n");
				}
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		if (!nobody) {
			mp.setMessage(PrintFormat.setFormatCenter(lang
					.translate("PO_03_RESULT"))
					+ "\n"
					+ PrintFormat.setFormatFull(SEPARATOR)
					+ "\n"
					+ buf.toString() + PrintFormat.setFormatFull(SEPARATOR));
		} else {
			mp.setMessage(SYSINFO + lang.translate("PO_03_KO")); // LIST EMPTY
		}
		return mp;
	}

	@Override
	public MessageProxy findById() {
		MessageProxy mp = new MessageProxy();
		StringBuffer buf = new StringBuffer("");
		Person p = null;
		boolean nobody = true;
		String id = this.input.getString(lang.translate("PO_00_ID"));
		try {
			p = this.dao.doFindById(id);
			if (p != null && p instanceof Student) {
				nobody = false;
				if (buf.length() == 0) {
					buf.append(lang.translate("PO_03_R02_HEAD"));
				}
				buf.append(p.toString());
				buf.append("\n");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		if (!nobody) {
			mp.setMessage(PrintFormat.setFormatCenter(lang
					.translate("PO_03_RESULT"))
					+ "\n"
					+ PrintFormat.setFormatFull(SEPARATOR)
					+ "\n"
					+ buf.toString() + PrintFormat.setFormatFull(SEPARATOR));
		} else {
			mp.setMessage(SYSINFO + lang.translate("PO_03_KO")); // LIST EMPTY
		}
		return mp;
	}

	@Override
	public MessageProxy findByKey() {
		MessageProxy mp = new MessageProxy();
		StringBuffer buf = new StringBuffer("");
		String keyWord = this.input.getString(lang.translate("PO_03_KEY"));
		boolean nobody = true;
		try {
			Iterator<Person> iter = this.dao.doFindByKey(keyWord).iterator();
			while (iter.hasNext()) {
				Person p = (Person) iter.next();
				if (p instanceof Student) {
					nobody = false;
					if (buf.length() == 0) {
						buf.append(lang.translate("PO_03_R02_HEAD"));
					}
					buf.append(p.toString());
					buf.append("\n");
				}
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		if (!nobody) {
			mp.setMessage(PrintFormat.setFormatCenter(lang
					.translate("PO_03_RESULT"))
					+ "\n"
					+ PrintFormat.setFormatFull(SEPARATOR)
					+ "\n"
					+ buf.toString() + PrintFormat.setFormatFull(SEPARATOR));
		} else {
			mp.setMessage(SYSINFO + lang.translate("PO_03_KO")); // LIST EMPTY
		}
		return mp;
	}

	@Override
	public MessageProxy delete() {
		MessageProxy mp = new MessageProxy();
		boolean flag = false;
		Person p = null;
		String id = this.input.getString(lang.translate("PO_00_ID"));
		try {
			p = this.dao.doFindById(id);
			if (p != null && p instanceof Student) {
				flag = this.dao.doDelete(id);
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		mp.setMessage(SYSINFO
				+ (flag ? lang.translate("PO_04_R02_OK") : lang
						.translate("PO_04_R02_KO")) + id);
		return mp;
	}

}
