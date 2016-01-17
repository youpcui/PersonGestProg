package ycui.projet.pgp.operate;

import java.util.Iterator;

import ycui.projet.pgp.exception.DAOException;
import ycui.projet.pgp.proxy.MessageProxy;
import ycui.projet.pgp.util.Stamp;
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
		Student s = new Student(new Stamp("2").getTimeStampRandom(),
				input.getString(lang.getProperty("PO_01_NAME")),
				input.getInt(lang.getProperty("PO_01_AGE")),
				input.getFloat(lang.getProperty("PO_01_R02_SCORE")));
		try {
			flag = this.dao.doCreate(s);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		System.out.println(RESULTHEAD + "-->L'étudiant(e) " + s.getName() // 学生名字
				+ (flag ? " est bien " : " n'est pas ")// 成功与否
				+ "ajouté(e).\n" + RESULTEND);
		return mp;
	}

	@Override
	public MessageProxy update() {
		MessageProxy mp = new MessageProxy();
		boolean flag = false;
		StringBuffer buf = new StringBuffer("");
		Person p = null;
		String id = this.input.getString("Saisir id:");
		try {
			p = this.dao.doFindById(id);
			if (p != null) {
				if (p instanceof Student) {
					Student tmp = (Student) p;
					Student w = new Student(
							p.getId(),
							input.getString(("Saisir le nouveau nom d'étudiant(e) (original "
									+ tmp.getName() + "):")),
							input.getInt(("Saisir le nouvel age (original "
									+ tmp.getAge() + "):")),
							input.getFloat(("Saisir le nouveau notes [original "
									+ tmp.getScore() + "):")));
					flag = this.dao.doUpdate(w);
					buf.append("-->L'étudiant(e) [");
					buf.append(p.getId());
					buf.append(flag ? "] est bien modifié(e)\n"
							: "] n'est pas modifié(e)\n");
				} else {
					buf.append("-->[");
					buf.append(p.getId());
					buf.append("] est trouvé, mais pas l'étudiant(e).\n");
				}
			} else {
				buf.append("-->L'étudiant(e) [");
				buf.append(id);
				buf.append("] n'est pas trouvé(e).\n");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		System.out.println(RESULTHEAD + buf.toString() + RESULTEND);
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
						buf.append(lang.getProperty("STUDENTHEAD"));
					}
					buf.append(p.toString());
					buf.append("\n");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(RESULTHEAD
				+ (nobody ? ("-->La liste est vide.\n") : buf.toString())
				+ RESULTEND);
		return mp;
	}

	@Override
	public MessageProxy findById() {
		MessageProxy mp = new MessageProxy();
		StringBuffer buf = new StringBuffer("");
		Person p = null;
		boolean nobody = true;
		String id = this.input.getString("Saisir id:");
		try {
			p = this.dao.doFindById(id);
			if (p != null && p instanceof Student) {
				nobody = false;
				if (buf.length() == 0) {
					buf.append(lang.getProperty("STUDENTHEAD"));
				}
				buf.append(p.toString());
				buf.append("\n");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		System.out.println(RESULTHEAD
				+ (nobody ? "-->L'étudiant(e) n'est pas trouvé.\n" : buf
						.toString()) + RESULTEND);
		return mp;
	}

	@Override
	public MessageProxy findByKey() {
		MessageProxy mp = new MessageProxy();
		StringBuffer buf = new StringBuffer("");
		String keyWord = this.input.getString("Saisir mot clé:");
		boolean nobody = true;
		try {
			Iterator<Person> iter = this.dao.doFindByKey(keyWord).iterator();
			while (iter.hasNext()) {
				Person p = (Person) iter.next();
				if (p instanceof Student) {
					nobody = false;
					if (buf.length() == 0) {
						buf.append(lang.getProperty("STUDENTHEAD"));
					}
					buf.append(p.toString());
					buf.append("\n");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out
				.println(RESULTHEAD
						+ (nobody ? ("-->Ne personne correspond à \"" + keyWord + "\".\n")
								: buf.toString()) + RESULTEND);
		return mp;
	}

	@Override
	public MessageProxy delete() {
		MessageProxy mp = new MessageProxy();
		boolean flag = false;
		StringBuffer buf = new StringBuffer("");
		Person p = null;
		String id = this.input.getString("Saisir id:");
		try {
			p = this.dao.doFindById(id);
			if (p != null && p instanceof Student) {
				flag = this.dao.doDelete(id);
				buf.append("-->L'étudiant(e) ");
				buf.append(p.getName());
				buf.append("[");
				buf.append(p.getId());
				buf.append(flag ? "] est bien supprimé(e)\n"
						: "] n'est pas supprimé(e)\n");
			} else {
				buf.append("-->L'étudiant(e) [");
				buf.append(id);
				buf.append("] n'est pas trouvé(e).\n");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		System.out.println(RESULTHEAD + buf.toString() + RESULTEND);
		return mp;
	}

}
