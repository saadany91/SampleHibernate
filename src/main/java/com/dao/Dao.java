package com.dao;

import java.util.List;

import com.models.Student;

public interface Dao {

	void add(Student s1);

	List<Student> getAll();

}
