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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="a_Caching_Student_art")
@PrimaryKeyJoinColumn(name="id", referencedColumnName="studentID")
public class ArtStudent extends Student{
	
	private double homeScienceMarks;
	

	public ArtStudent() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ArtStudent(double homeScienceMarks) {
		super();
		this.homeScienceMarks = homeScienceMarks;
	}


	public double getHomeScienceMarks() {
		return homeScienceMarks;
	}


	public void setHomeScienceMarks(double homeScienceMarks) {
		this.homeScienceMarks = homeScienceMarks;
	}
	
	
	
}

