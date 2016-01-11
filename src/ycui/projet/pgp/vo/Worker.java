package ycui.projet.pgp.vo;

public class Worker extends Person {
	/**
	 * Worker h��rite de Person
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
			if (this.getSalary() > w.getSalary()) { //������ʸ�
				return -1;
			} else if (this.getSalary() < w.getSalary()) { //������ʵ�
				return 1;
			} else { //�������һ��
				if (super.getAge() > w.getAge()) { //��������
					return -1;
				} else if (super.getAge() < w.getAge()) { //�������С
					return 1;
				}
			}
		}
		return super.compareTo(p); // �Ƚ����ͻ��Ⱥ����˳��
	}
}
