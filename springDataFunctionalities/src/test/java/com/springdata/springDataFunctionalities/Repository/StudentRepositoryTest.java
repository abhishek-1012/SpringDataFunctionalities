package com.springdata.springDataFunctionalities.Repository;

import com.springdata.springDataFunctionalities.Entity.Student;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Configuration;

import com.springdata.springDataFunctionalities.Entity.Student;
import com.springdata.springDataFunctionalities.Repository.StudentRepository;
import lombok.Builder;

@SpringBootTest
class StudentRepositoryTest {
	 
			@Autowired
			public StudentRepository sr;
			
			@Test
			public void saveStudent() {
				Student st=Student.builder()
						.firstName("Abhishek")
				          .LastName("Purohit")
				          .emailID("Jean.com")
				          .build()
						
						
//						
						          .firstName("Abhishek")
						          .LastName("Purohit")
						          .emailID("Jean.com");
			}
			
			@Test
			public void printAllStudent() {
				List<Student> result=sr.findAll();
				System.out.println(result);
			}
			
			@Test
			public void getStudentByEmailID(String email) {
				Student st=sr.getStudentByEmailAddress("ab@ghhd.com");
					System.out.println(st);
			}
				
	    

}