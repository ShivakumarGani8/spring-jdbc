package com.springcore.jdbc.dao;


import java.util.List;
import java.util.jar.Attributes.Name;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.springcore.jdbc.entities.Student;

//@Component("studentDao")
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//Inserting into table
	public int insert(Student student) {
		//Query
        String query="insert into Student(id,name,city) value(?,?,?)";
		return jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
	}
	
	//Updating the data
	public int updateChanges(Student student) {
		String query="update student set name=?, city=? where id=?";
		return jdbcTemplate.update(query,student.getName(), student.getCity(),student.getId());
	}
	
	//Deleting data
	public int deleteData(int id) {
		String query="delete from Student where id=?";
		return jdbcTemplate.update(query,id);
	}
	
	//Retrieving single data
	public Student getData(int id) {
		String query="select * from student where id=?";
		RowMapper<Student> rowMapper=new RowMapperImpl();
		return jdbcTemplate.queryForObject(query, rowMapper,id);
		
	}
	
	//Retrieving all data
	public List<Student> getAllData() {
		String query= "select * from Student";
		List<Student> students= jdbcTemplate.query(query, new RowMapperImpl());
		return students;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
}
