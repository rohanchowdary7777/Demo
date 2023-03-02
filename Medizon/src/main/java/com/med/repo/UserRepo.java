package com.med.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.med.module.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	@Query(value = "select * from user where username=?1 or email=?2",nativeQuery = true)
	User findByUserNameOrEmail(String userNameOrEmail, String userNameOrEmail2);

}
