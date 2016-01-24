package ycui.projet.pgp.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.TreeSet;

import ycui.projet.pgp.dao.PersonDAO;
import ycui.projet.pgp.dbc.DataBaseConnection;
import ycui.projet.pgp.exception.DAOException;
import ycui.projet.pgp.vo.*;

public class PersonDAOImplJDBC implements PersonDAO {
	private DataBaseConnection dbc = null;

	public boolean doCreate(Person person) throws DAOException {
		this.dbc = new DataBaseConnection();
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = null;
		float f = 0.0f;
		if(person instanceof Worker){
			Worker w = (Worker)person;
			f = w.getSalary();
			sql = "INSERT INTO tperson (id, name, age, salary) VALUES (?,?,?,?)";
		}
		else if(person instanceof Student){
			Student s = (Student)person;
			f = s.getScore();
			sql = "INSERT INTO tperson (id, name, age, score) VALUES (?,?,?,?)";
		}
		try {
			pstmt = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, person.getId());
			pstmt.setString(2, person.getName());
			pstmt.setInt(3, person.getAge());
			pstmt.setFloat(4, f);
			int i = pstmt.executeUpdate();
			pstmt.close();
			flag = i!=0?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	public boolean doUpdate(Person person) throws DAOException {
		this.dbc = new DataBaseConnection();
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = null;
		float f = 0.0f;
		if(person instanceof Worker){
			Worker w = (Worker)person;
			f = w.getSalary();
			sql = "UPDATE tperson SET name=?, age=?, salary=? WHERE id=?";
		}
		else if(person instanceof Student){
			Student s = (Student)person;
			f = s.getScore();
			sql = "UPDATE tperson SET name=?, age=?, score=? WHERE id=?";
		}
		try {
			pstmt = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, person.getName());
			pstmt.setInt(2, person.getAge());
			pstmt.setFloat(3, f);
			pstmt.setString(4, person.getId());
			int i = pstmt.executeUpdate();
			pstmt.close();
			flag = i!=0?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	public boolean doDelete(String id) throws DAOException {
		this.dbc = new DataBaseConnection();
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = null;
		sql = "DELETE FROM tperson WHERE id=?";
		try {
			pstmt = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, id);
			int i = pstmt.executeUpdate();
			pstmt.close();
			flag = i!=0?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	public boolean doDeleteAll() throws DAOException {
		this.dbc = new DataBaseConnection();
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = null;
		sql = "DELETE FROM tperson WHERE id LIKE ? or ?";
		try {
			pstmt = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, "1%");
			pstmt.setString(2, "2%");
			int i = pstmt.executeUpdate();
			pstmt.close();
			flag = i!=0?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	public Set<Person> doFindAll() throws DAOException {
		this.dbc = new DataBaseConnection();
		PreparedStatement pstmt = null;
		String sql = null;
		Set<Person> allPerson = new TreeSet<Person>();
		Person p = null;
		sql = "SELECT id,name,age,salary,score FROM tperson";
		try {
			pstmt = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
			ResultSet rs = (ResultSet) pstmt.executeQuery();
			while(rs.next()){
				if("1".equals(rs.getString(1).substring(0, 1))){
					p = new Worker(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getFloat(4));
				}else if("2".equals(rs.getString(1).substring(0, 1))){
					p = new Student(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getFloat(5));
				}
				allPerson.add(p);
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
		return allPerson;
	}

	public Person doFindById(String id) throws DAOException {
		this.dbc = new DataBaseConnection();
		PreparedStatement pstmt = null;
		String sql = null;
		Person p = null;
		sql = "SELECT id,name,age,salary,score FROM tperson WHERE id=?";
		try {
			pstmt = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = (ResultSet) pstmt.executeQuery();
			while(rs.next()){
				if("1".equals(id.substring(0, 1))){
					p = new Worker(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getFloat(4));
				}else if("2".equals(id.substring(0, 1))){
					p = new Student(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getFloat(5));
				}
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
		return p;
	}

	public Set<Person> doFindByKey(String keyWord) throws DAOException {
		this.dbc = new DataBaseConnection();
		PreparedStatement pstmt = null;
		String sql = null;
		Set<Person> allPerson = new TreeSet<Person>();
		Person p = null;
		sql = "SELECT id,name,age,salary,score FROM tperson WHERE name like ?";
		try {
			pstmt = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, "%"+keyWord+"%");
			ResultSet rs = (ResultSet) pstmt.executeQuery();
			while(rs.next()){
				if("1".equals(rs.getString(1).substring(0, 1))){
					p = new Worker(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getFloat(4));
				}else if("2".equals(rs.getString(1).substring(0, 1))){
					p = new Student(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getFloat(5));
				}
				allPerson.add(p);
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
		return allPerson;
	}

}
