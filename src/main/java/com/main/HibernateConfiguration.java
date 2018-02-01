package com.main;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {
	@Value("${db.driver}")
	private String DRIVER;

	@Value("${db.password}")
	private String PASSWORD;

	@Value("${db.url}")
	private String URL;

	@Value("${db.username}")
	private String USERNAME;

	@Value("${hibernate.dialect}")
	private String DIALECT;

	@Value("${hibernate.show_sql}")
	private String SHOW_SQL;

	@Value("${hibernate.hbm2ddl.auto}")
	private String HBM2DDL_AUTO;

	@Value("${entitymanager.packagesToScan}")
	private String PACKAGES_TO_SCAN;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(DRIVER);
		dataSource.setUrl(URL);
		dataSource.setUsername(USERNAME);
		dataSource.setPassword(PASSWORD);
		
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(PACKAGES_TO_SCAN);
		Properties hibernateProperties = new Properties();
		
		// add dialect depending on db used
		hibernateProperties.put("hibernate.dialect", DIALECT);
		// show the queries in console
		hibernateProperties.put("hibernate.show_sql", SHOW_SQL);
		// 'create' will drop and create tables each time
		//hibernateProperties.put("hibernate.hbm2ddl.auto", HBM2DDL_AUTO);
		// will show the queries formatted instead of in one line
		hibernateProperties.put("hibernate.format_sql", true); // 

		// used to track performance in development environment.
		// by showing session metrics like number of queries and execution time
		hibernateProperties.put("hibernate.generate_statistics", true); 
		
		// enable second level caching
		hibernateProperties.put("hibernate.cache.use_second_level_cache", true);
		// add the cache provider
		hibernateProperties.put("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");
		
		// add query level caching
		hibernateProperties.put("hibernate.cache.use_query_cache", true);
		
		/*-------------------Connection Pool -------------------------- */
		
		// Minimum number of JDBC connections in the pool. Hibernate default: 1
		hibernateProperties.put("hibernate.c3p0.min_size", 5);

		// Maximum number of JDBC connections in the pool. Hibernate default: 100
		hibernateProperties.put("hibernate.c3p0.max_size", 20);
		
		// When an idle connection is removed from the pool (in second). Hibernate default: 0, never expire.
		hibernateProperties.put("hibernate.c3p0.timeout", 300);
		
		// Number of prepared statements will be cached. Increase performance. Hibernate default: 0 , caching is disable.
		hibernateProperties.put("hibernate.c3p0.max_statements", 50);
		
		//  idle time in seconds before a connection is automatically validated. Hibernate default: 0
		hibernateProperties.put("hibernate.c3p0.idle_test_period", 500);
		

		sessionFactory.setHibernateProperties(hibernateProperties);

		return sessionFactory;
		
		
	}

	@Bean
	public HibernateTransactionManager transactionManager() {
		
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}	
}