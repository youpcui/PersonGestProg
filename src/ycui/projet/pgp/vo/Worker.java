package ycui.projet.pgp.vo;

public class Worker extends Person {
	/**
	 * Worker hérite de Person
	 */
	private static final long serialVersionUID = 1847194021013575055L;
	private float salary = 0.0f;
	
	public Worker(String id, String name, int age, float salary){
		super(id,name,age);
		this.setSalary(salary);
	}
	public float getSalary() {
		return this.salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String toString(){
		return super.toString() + this.getSalary();
	}
	@Override
	public int compareTo(Person p) {
		if (p instanceof Worker) {
			Worker w = (Worker) p;
			if (this.getSalary() > w.getSalary()) { //如果工资高
				return -1;
			} else if (this.getSalary() < w.getSalary()) { //如果工资低
				return 1;
			} else { //如果工资一样
				if (super.getAge() > w.getAge()) { //如果年龄大
					return -1;
				} else if (super.getAge() < w.getAge()) { //如果年龄小
					return 1;
				}
			}
		}
		return super.compareTo(p); // 比较类型或先后加入顺序
	}
}
