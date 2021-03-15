package com.example.demo;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
//	Customer query written 
//	@Query("SELECT s FROM Student s WHERE s.email = ?1")   //JPQL query
	
//	@Query(value = "SELECT * FROM student WHERE email=?1", nativeQuery = true)
//	Optional<Student> findStudentByEmail(String email);
	
//	@Query("SELECT s FROM Student s WHERE s.firstName = ?1 AND s.age >= ?2")  //JPQL query
	
	
	/////NATIVE QUERY /////////
//	@Query(value = "SELECT * FROM student WHERE first_name=?1 AND age=?2", nativeQuery = true)
//	List<Student> findStudentByFirstNameEqualsAndAgeEquals(String firstName, Integer age);
//	
	
	
//	2nd way to write native query ////////
//	@Query(value = "SELECT * FROM student WHERE first_name= :first_name AND age >= :age",nativeQuery = true)
//	List<Student> findStudentByFirstNameEqualsAndAgeEquals(
//			@Param("firstName") String firstName, 
//			@Param("age") Integer age);
	
	
//	@Transactional
//	@Modifying
//	@Query("DELETE FROM Student u WHERE u.id = ?1")
//	int deleteStudentById(Long id);
	
	
}
