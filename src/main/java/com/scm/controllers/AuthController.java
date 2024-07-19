package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm.entities.User;
import com.scm.helper.Message;
import com.scm.helper.MessageType;
import com.scm.repositories.UserRepo;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class AuthController {

	// verify email
	@Autowired
	private UserRepo userRepo;

	@GetMapping("/verify-email")
	public String verifyEmail(@RequestParam("token") String token, HttpSession session
	){
		
		User user = userRepo.findByEmailToken(token).orElse(null);
		
		if (user != null) {
			// means user is fetched and we have to procees by it.

			if (user.getEmailToken().equals(token)) {
				user.setEmailVerified(true);
				user.setEnabled(true);
				userRepo.save(user);
				session.setAttribute("message", Message.builder()
				.type(MessageType.green)
				.content("Your Email is verified. Now you can login  ")
				.build());
				return "success_page";
			}
			return "error_page";
			
		}

		session.setAttribute("message", Message.builder()
		.type(MessageType.red)
		.content("Email not verified ! Token is not associated with User. ")
		.build());

		return "error_page";
	}
}
