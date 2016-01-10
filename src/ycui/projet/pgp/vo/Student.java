package ycui.projet.pgp.vo;

public class Student extends Person {
	/**
	 * Student h¨¦rite de Person
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
		if(p.equals(this)){
			return -1;
		}
		if (p instanceof Worker) {
			return -1;
		} else if (p instanceof Student) {
			Student s = (Student) p;
			if (this.getScore() > s.getScore()) {
				return -1;
			} else if (this.getScore() < s.getScore()) {
				return 1;
			} else {
				if (super.getAge() > s.getAge()) {
					return -1;
				} else if (super.getAge() < s.getAge()) {
					return 1;
				}
			}
		}
		return 0;
	}
}
