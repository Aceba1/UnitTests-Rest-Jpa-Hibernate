package com.careerdevs.restjpahibernate.repository;

import com.careerdevs.restjpahibernate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
