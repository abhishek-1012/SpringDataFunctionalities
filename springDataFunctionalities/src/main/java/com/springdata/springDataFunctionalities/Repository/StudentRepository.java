package com.springdata.springDataFunctionalities.Repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springdata.springDataFunctionalities.Entity.Student;

import jakarta.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
	
	//We can also implement custom methods in Student Repository and we just to keep in mind the naming convention and give the definition, we don't have to implement it.
	
	
	public List<Student>FindByFirstName(String name);

	public List<Student>FindByFirstNameContaining(String name);
	
	public List<Student>FindByLastNameNotNull();
	
	public List<Student>FindByGuardianName(String name);
	
	public Student FindByFirstNameAndLastname(String name1,String name2);
	
	//JPQL query
	@Query("SELECT S FROM STIDENT S WHERE S.emailID=?1")
	public Student getStudentByEmailAddress(String email);
	
	//JPQL queries are defined based on the classes and attributes which you have defined and not on the basis of table name
	//?1 MEANS FORST PARAMETER
	
	@Query("Select S.firstName from S where S.emailID=?1")
	public String getFirstNameFromEmailID(String email);
	
	//NativeQuery	
	//We can run both native as well as JPQL queries on our DB BUT IN NATIVE QUERIES WE GIVE THE NAMES OF THE TABLE ATTRIBUTES AND NOT CLASS
	@Query(
			value="SELECT LASTname from tbl_student s where s.email=?1",
			nativeQuery= true
			)
	public String getLastNameFromEmailId(String email);
	
	
	//Named parameter, instead of passing Questionmarks, we are passing named parameters which makes it easier for us to read and understand
	@Query(
			
			value= "SELECT firstName FROM tbl_student s where s.emailId= :emailID",
			nativeQuery=true
			)
	public String getFirstNameByNativeQuery(@Param("emailID") String email);
	
	@Modifying //This should be used for queries which are modifying the record in your Database
	@Transactional  //This should be used when some transaction (occurs while updating) happens
	@Query(
			value= "update tbl_student s set s.firstName= ?1 where s.emailid=?2",
			nativeQuery=true
			)
	public int updateFirstName(String UpdatedName, String email);
	
	
	
	
	
	
	
	
	
}
