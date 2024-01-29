package com.project.Shopping.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Shopping.Model.Users;
import com.project.Shopping.Repository.UserRepository;

@Service
public class FrontService {

	@Autowired
	UserRepository userrepository;

	public String saveRegister(Users users) {
		userrepository.save(users);
		System.err.println(users);
		System.err.println("Registered");
		return "true";
	}

	public String CheckLogin(Users users) {

		Optional<Users> optionalUser = userrepository.findById(users.getEmail());

		if (optionalUser.isPresent()) {
			Users storedUser = optionalUser.get();
			if (storedUser.getEmail().equals(users.getEmail())
					&& storedUser.getPassword().equals(users.getPassword())) {
				System.err.println("Login successful!");
				return "Home";
			} else {
				System.err.println("Invalid credentials");
				return "Login";
			}
		}

		else if (users.getEmail().equals("admin@123") && users.getPassword().equals("1848")) {
			return "Admin";
		}

		else {
			System.err.println("User not found");
			return "Notfound";
		}
	}

	public String adminlogin(Users users) {
		if (users.getEmail().equals("admin@123") && users.getPassword().equals("1848")) {
			return "AdminPanel";
		} else {
			return "LoginPage";
		}
	}

}
