package ycui.projet.pgp.vo;

import java.io.Serializable;

public abstract class Person implements Comparable<Person>,Serializable {
	/**
	 * classe abstraite
	 */
	private static final long serialVersionUID = -8407058666713258182L;
	// 定义各公共属性
	private String id;
	private String name;
	private int age;
	
	public Person(String id, String name, int age){
		this.setId(id);
		this.setName(name);
		this.setAge(age);
	}
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return this.age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String toString(){
		return this.getId() + "\t" + this.getName() + ((this.getName().length()<8)?"\t\t":"\t") + this.getAge() + "\t";
	}
	public int compareTo(Person p) {
		String thisType = this.getId().substring(0, 1);
		String argType = p.getId().substring(0, 1);
		String thisSerial = this.getId().substring(3, 21);
		String argSerial = p.getId().substring(3, 21);
		if (Integer.parseInt(thisType) < Integer.parseInt(argType)){ //如果是员工
			return -1;
		} else if (Integer.parseInt(thisType) > Integer.parseInt(argType)){ //如果是学生
			return 1;
		} else { //如果同类型
			if(Long.parseLong(thisSerial) < Long.parseLong(argSerial)){ //如果先加入
				return -1;
			}else if(Long.parseLong(thisSerial) > Long.parseLong(argSerial)){ //如果后加入
				return 1;
			}
		}
		return 0; //即本人
	}
}