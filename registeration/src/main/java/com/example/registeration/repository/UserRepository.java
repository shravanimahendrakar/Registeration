package com.example.registeration.repository;

import com.example.registeration.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);

	User getUserById(Long userId);
}
