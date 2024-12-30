package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.binding.SignUpForm;
import com.example.demo.entity.StudentEntity;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, Long>{
	
		//@Query("SELECT CASE WHEN COUNT(s) > 0 THEN TRUE ELSE FALSE END FROM StudentEntity s WHERE s.emailId = :emailId")
		List<StudentEntity> findByEmailId(String emailId);

		StudentEntity save(SignUpForm signupForm);

		@Modifying
	    @Query("UPDATE StudentEntity s SET s.password = :password WHERE s.emailId = :emailId")
		int updatePassword(@Param("emailId") String emailId, @Param("password") String password);

}
