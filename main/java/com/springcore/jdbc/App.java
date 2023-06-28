package com.springcore.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.springcore.jdbc.dao.StudentDao;
import com.springcore.jdbc.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
    	//Configuration using XML
//        ApplicationContext context=new ClassPathXmlApplicationContext("com/springcore/jdbc/config.xml");
//        StudentDao jdbc= context.getBean("studentDao",StudentDao.class);
        
        //Inserting into DB
//        Student student=new Student();
//        student.setId(2);
//        student.setName("Sudeep");
//        student.setCity("Jamakhandi");
//        int result= jdbc.updateChanges(student);
        
        //Updating from DB
//        Student student=new Student();
//        student.setId(2);
//        student.setName("Sudeep Gani");
//        student.setCity("Linganur");
//        int result= jdbc.updateChanges(student);
        
        //Deleting from DB
//        int result= jdbc.deleteData(4);
//        System.out.println("Rows updated : "+result);
        
        //Retrieving single data from DB
//        Student result= jdbc.getData(3);
//        System.out.println(result);
        
        //Retrieving all data from DB
//        List<Student> studentList= jdbc.getAllData();
//        for(Student student : studentList) {
//        	System.out.println(student);
//        }
    	
    	//Configuration using java
    	ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
    	StudentDao jdbc= context.getBean("studentDao",StudentDao.class);
    	//Adding data
//    	Student student=new Student();
//    	student.setId(5);
//    	student.setName("Java config");
//    	student.setCity("No XML configuratione");
//    	jdbc.insert(student);
    	
    	//Retrieving data
    	List<Student> studentList= jdbc.getAllData();
    	for(Student std: studentList) {
    		System.out.println(std);
    	}
    	
    	
    }
}
