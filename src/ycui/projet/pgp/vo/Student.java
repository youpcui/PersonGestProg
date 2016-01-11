package ycui.projet.pgp.vo;

public class Student extends Person {
	/**
	 * Student hérite de Person
	 */
	private static final long serialVersionUID = 4571173674064593091L;
	private float score = 0.0f;
	
	public Student(String id, String name, int age, float score){
		super(id,name,age);
		this.setScore(score);
	}
	public float getScore() {
		return this.score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public String toString(){
		return super.toString() + this.getScore();
	}
	@Override
	public int compareTo(Person p) {
		if (p instanceof Student) {
			Student s = (Student) p;
			if (this.getScore() > s.getScore()) { //如果成绩高
				return -1;
			} else if (this.getScore() < s.getScore()) { //如果成绩低
				return 1;
			} else { //如果成绩一样
				if (super.getAge() > s.getAge()) { //如果年龄大
					return -1;
				} else if (super.getAge() < s.getAge()) { //如果年龄小
					return 1;
				}
			}
		}
		return super.compareTo(p); // 比较类型或先后加入顺序
	}
}
