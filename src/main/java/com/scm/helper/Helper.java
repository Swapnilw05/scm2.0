package com.scm.helper;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class Helper {

    public static String getEmailOfLoggedInUser(Authentication authentication){
        
        // if we are signing in with email and password : how we can fetch email

        if (authentication instanceof OAuth2AuthenticationToken) {
        
            var aOAuth2AuthenticationToken = (OAuth2AuthenticationToken) authentication; 
            var clientId = aOAuth2AuthenticationToken.getAuthorizedClientRegistrationId();

            var oauth2User = (OAuth2User)authentication.getPrincipal();
            String username = "";

            if (clientId.equalsIgnoreCase("google")) {
                // sign in with google :  how we can fetch email

                System.out.println("getting user from google");

                username = oauth2User.getAttribute("email").toString();

            } else if (clientId.equalsIgnoreCase("github")) {
                //  sign in with github :  how we can fetch email
                System.out.println("getting email from github");

                String email = oauth2User.getAttribute("email") != null ? oauth2User.getAttribute("email").toString()
                : oauth2User.getAttribute("login").toString() + "@gmail.com";

            }

            return username;

        } else {
            System.out.println("getting data from local database");
            return authentication.getName();
        }

    }

    public static String getLinkForEmailVerification(String emailToken){
       
        String link = "http://localhost:8083/auth/verify-email?token=" + emailToken;

        return link;
    }
}
