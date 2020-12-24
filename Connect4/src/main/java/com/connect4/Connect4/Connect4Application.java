package com.connect4.Connect4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.connect4.Connect4.entity.Player;

@SpringBootApplication
public class Connect4Application {
	

	public static void main(String[] args) {
		SpringApplication.run(Connect4Application.class, args);
		
	}

}
