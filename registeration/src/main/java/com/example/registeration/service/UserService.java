package com.example.registeration.service;

import com.example.registeration.model.*;
import com.example.registeration.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

	public User getUserById(Long userId) {
		return userRepository.getUserById(userId);
	}
}
