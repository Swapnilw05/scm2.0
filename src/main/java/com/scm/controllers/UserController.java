package com.scm.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.helper.Helper;

@Controller
@RequestMapping("/user")
public class UserController {

   private Logger logger = LoggerFactory.getLogger(UserController.class);

// user dashboard 

@RequestMapping(value = "/dashboard")
public String userDashboard(){
    return "user/dashboard";
}

// user profile page
@RequestMapping(value = "/profile")
    public String userProfile(Authentication authentication){

        String username = Helper.getEmailOfLoggedInUser(authentication);

        logger.info("User logged in : {}", username);

        System.out.println("User Profile");
        return "user/profile";
    }


// user add contacts

// user view contacts

// user edit contacts

// user delete contacts

// user search contacts


}
