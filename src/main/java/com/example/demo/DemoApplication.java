package com.example.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.github.javafaker.Faker;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return args ->{
//			var maria = new Student("maria","db", "maria@gmail.com",23);
//			var mongo = new Student("mongo","db", "mongo@gmail.com",28);
//			
//			
//			studentRepository.saveAll(List.of(maria,mongo));
			
//			System.out.println(studentRepository.count());
//			
//			
////			Finding single Student object with Id
//			
//			studentRepository
//			.findById(2L)
//			.ifPresentOrElse(
//					System.out::println,
//					()-> System.out.println("Student of Id 2 not found")
//					);
////			Finding all the students on database
//			
//			List<Student> students = studentRepository.findAll();
//			students.forEach(System.out::println);
//			
////			Deleting all students from database
//			
//			studentRepository.deleteAll();
//			
////			Deleting student of id 2 
//			
//			studentRepository.deleteById(2L);
			
//			Finding Student by Email
//			studentRepository
//				.findStudentByEmail("mongo@gmail.com")
//				.ifPresentOrElse(System.out::println,
//					()-> System.out.println("No student found"));
////			Finding Student by Email and age 
//			studentRepository
//				.findStudentByFirstNameEqualsAndAgeEquals("maria", 23)
//				.forEach(System.out::println);
			
/////////////////////SORTING & PAGINATION///////////////////////////////////
			
			generateRandomStudents(studentRepository);
			
			
//			sorting(studentRepository); 
			
			
			PageRequest pageRequest = PageRequest.of(0,5,Sort.by("firstName").ascending());
			Page<Student> page =studentRepository.findAll(pageRequest);
			
			System.out.println(page);
		};
	}
	
	
	public void sorting(StudentRepository studentRepository) {
//		Sort sort =	Sort.by(Sort.Direction.ASC, "firstName");
		Sort sort = Sort.by("firstName")
				.ascending()
				.and(Sort.by("age").ascending());
		
		studentRepository
			.findAll(sort)
			.forEach(
					student -> System.out.println(
							student.getFirstName() + " " + student.getAge())
					);
	}
	
	private void generateRandomStudents(StudentRepository studentRepository) {
		Faker faker = new Faker();
		
		for(int i = 0; i <= 20; i++) {
			String firstName = faker.name().firstName();
			String lastName = faker.name().lastName();
			String email = String.format("%s.%s@gmail.com", firstName, lastName);
			var student = new  Student(
					firstName, 
					lastName,
					email,
					faker.number().numberBetween(17,55)
					);
			
			studentRepository.save(student);
			}
		}
}



