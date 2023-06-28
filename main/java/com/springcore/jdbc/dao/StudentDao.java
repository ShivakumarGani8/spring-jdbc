package com.springcore.jdbc.dao;

import java.util.List;

import com.springcore.jdbc.entities.Student;

public interface StudentDao {
	int insert(Student student);
	int updateChanges(Student student);
	int deleteData(int id);
	Student getData(int id);
	List<Student> getAllData();
}
