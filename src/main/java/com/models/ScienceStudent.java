package com.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="a_Caching_Student_science")
public class ScienceStudent extends Student{
	
	private double practicalMarks;
	

	public ScienceStudent() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ScienceStudent(double practicalMarks) {
		super();
		this.practicalMarks = practicalMarks;
	}


	public double getPracticalMarks() {
		return practicalMarks;
	}


	public void setPracticalMarks(double practicalMarks) {
		this.practicalMarks = practicalMarks;
	}


	
	
}

