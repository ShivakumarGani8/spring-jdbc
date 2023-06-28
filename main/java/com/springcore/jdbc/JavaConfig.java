package com.springcore.jdbc;

import java.sql.DriverManager;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.springcore.jdbc.dao.StudentDao;
import com.springcore.jdbc.dao.StudentDaoImpl;

@Configuration
//For autowired
//@ComponentScan(basePackages = "com.springcore.jdbc.dao")
public class JavaConfig {
	private DataSource getDriverManager() {
		DriverManagerDataSource driverManager=new DriverManagerDataSource();
		driverManager.setDriverClassName("com.mysql.jdbc.Driver");
		driverManager.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		driverManager.setUsername("root");
		driverManager.setPassword("Shiva@9980");
		return driverManager;
	}
	
	@Bean(name="jdbcTemplate")
	public JdbcTemplate getTemplate() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate();
		jdbcTemplate.setDataSource(getDriverManager());
		return jdbcTemplate; 
	}
	
	@Bean(name = { "studentDao"})
	public StudentDao getStudentDao() {
		StudentDaoImpl studentDao =new StudentDaoImpl();
		studentDao.setJdbcTemplate(getTemplate());
		return studentDao;
	}
	

}
