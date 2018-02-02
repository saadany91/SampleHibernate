package com.serviceImp;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.Dao;
import com.models.Student;
import com.service.ServiceI;


@Service
public class ServiceImp implements ServiceI{
	
	@Autowired
	Dao dao;



	@Override
	@Transactional(propagation= Propagation.REQUIRED)
	public void add(Student s1) {
		dao.add(s1);	
		dao.update(s1);
	}



	@Override
	@Transactional
	public List<Student> getAll() {
		return dao.getAll();
	}



}
