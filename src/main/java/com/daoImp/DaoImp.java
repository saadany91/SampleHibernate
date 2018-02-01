package com.daoImp;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.controller.Controller;
import com.dao.Dao;
import com.models.Gender;
//import com.models.Address;
import com.models.Student;


@Repository
public class DaoImp implements Dao{

	@Autowired
	private  SessionFactory sessionFactory;

	static Logger logger = Logger.getLogger(DaoImp.class);
	

	@Override
	public void add(Student s1) {
		
		Session session = this.sessionFactory.openSession();
		

		//s1.setSname("mohamed");
		//s1.setRank(18);
		//s1.setLocation("ohio");
		
		session.save(s1);
		session.flush();
		session.clear();
		
		////////////////////////HQL//////////////////////////
		// will not work on inserting rows in db
		
		/*
		String query= "from Student";
		
		Query result= session.createQuery(query);
		result.list().get(0);
		*/
		
		/*
		String query= "insert into a_caching_Student values (5,'M' , 'MALE','chicago', 3 ,2,'mohamed')";
		Query result= session.createQuery(query);
		// Query result= session.createSQLQuery(query);        // this will fire the query as SQL query same as if it is executed in db and thus allowing insert
		 * we can also solve the n+1 problem using that by writing our own query to avoid complex joins. when we want to write subquery.
		result.executeUpdate();
		*/

	}


	@Override
	public List<Student> getAll() {

		Session session = this.sessionFactory.openSession();

		
		////////////////////////criteria//////////////////////////
		// used in select from db
		
		// when we want to use where clause we use restrictions
		
			
		   Criteria c= session.createCriteria(Student.class).
				add(Restrictions.or(
						Restrictions.eq("sid", 30),Restrictions.le("rank", 8)));
		  
		
		//List<Student> l= c.list();
		
		//System.out.println(l);
		
		//logger.info(s1);
		//logger.info(l);
		
		////////////////////////Projection//////////////////////////
		// used to select certain columns from table
		
		Projection p= Projections.property("sname");
		
		c.setProjection(p);
		 c.setCacheable(true);
		 
		List<Student> l=c.list();
		
		//logger.info(l);
		/////////////////////////////////////////////////////////////////
		
		 Criteria c1= session.createCriteria(Student.class).
					add(Restrictions.or(
							Restrictions.eq("sid", 30),Restrictions.le("rank", 8)));
		
			Projection p1= Projections.property("sname");
			
			c1.setProjection(p1);
			
			 c1.setCacheable(true);

			List<Student> l1=c1.list();
			
			//logger.info(l1);
		
		/////////////////////////////////////////////////////////////
		
		
		//session will store the data in cache
	     //Student student=session.get(Student.class, 2); //select * from account where id=5
	     //session.close();
	     
	     //session = this.sessionFactory.openSession();
	     //Student student1=session.get(Student.class, 2); //returns data from cache
	     //session.close();
	     
	     //logger.info(student);
		
		
		return l1;
	}

	
	
	
}
