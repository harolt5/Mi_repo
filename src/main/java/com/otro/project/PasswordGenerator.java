package com.otro.project;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = "12345678";
String passwordcod = encoder.encode(password);

System.out.println(passwordcod);




	}
    
}