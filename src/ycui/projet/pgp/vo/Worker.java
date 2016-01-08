package ycui.projet.pgp.vo;

public class Worker extends Person {
	/**
	 * Worker h¨¦rite de Person
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
		if (p instanceof Student) {
			return 1;
		} else if (p instanceof Worker) {
			Worker w = (Worker) p;
			if (this.getSalary() > w.getSalary()) {
				return -1;
			} else if (this.getSalary() < w.getSalary()) {
				return 1;
			} else {
				if (super.getAge() > w.getAge()) {
					return -1;
				} else if (super.getAge() < w.getAge()) {
					return 1;
				} else {
					return 0;
				}
			}
		} else
			return 0;
	}
}
