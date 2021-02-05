package com.sathish.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="Student")
@XmlRootElement
public class Student
{
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int stu_id = 0;

	@Column(name="Name")
	String stu_Name = null;
	
	@Column(name="RegNo")
	int stu_reg_no = 0;
	
	@Column(name="Mark")
	int stu_mark = 0;
	
	
	
	public Student() {
		
	}
	
	public Student(String stu_Name, int stu_reg_no, int stu_mark) {
		
		
		this.stu_Name = stu_Name;
		this.stu_reg_no = stu_reg_no;
		this.stu_mark = stu_mark;
	}
	public int getStu_id() {
		return stu_id;
	}
	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_Name() {
		return stu_Name;
	}
	public void setStu_Name(String stu_Name) {
		this.stu_Name = stu_Name;
	}
	public int getStu_reg_no() {
		return stu_reg_no;
	}
	public void setStu_reg_no(int stu_reg_no) {
		this.stu_reg_no = stu_reg_no;
	}
	public int getStu_mark() {
		return stu_mark;
	}
	@Override
	public String toString() {
		return "Student [stu_id=" + stu_id + ", stu_Name=" + stu_Name + ", stu_reg_no=" + stu_reg_no + ", stu_mark="
				+ stu_mark + "]";
	}
	public void setStu_mark(int stu_mark) {
		this.stu_mark = stu_mark;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stu_Name == null) ? 0 : stu_Name.hashCode());
		result = prime * result + stu_id;
		result = prime * result + stu_mark;
		result = prime * result + stu_reg_no;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (stu_Name == null) {
			if (other.stu_Name != null)
				return false;
		} else if (!stu_Name.equals(other.stu_Name))
			return false;
		if (stu_id != other.stu_id)
			return false;
		if (stu_mark != other.stu_mark)
			return false;
		if (stu_reg_no != other.stu_reg_no)
			return false;
		return true;
	}
	

	
}