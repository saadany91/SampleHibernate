package com.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

// @immutable will allow to get and read data from db but not update
@Entity
@Table(name="a_Caching_Student")
@DynamicUpdate // update only the field that is changed
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Cache(usage= CacheConcurrencyStrategy.READ_ONLY)
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="studentID")
	private int sid;
	private String sname;
	private String location;
	private float marks;
	
	@Column(unique=true)
	private int rank;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	private String genderChar;
	

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(int sid, String sname, String location, float marks, int rank) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.location = location;
		this.marks = marks;
		this.rank = rank;
	}

	public long getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public float getMarks() {
		return marks;
	}

	public void setMarks(float marks) {
		this.marks = marks;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", location=" + location + ", marks=" + marks + ", rank="
				+ rank + "]";
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getGenderChar() {
		return genderChar;
	}

	public void setGenderChar(String genderChar) {
		this.genderChar = genderChar;
	}

	
	
	
}

