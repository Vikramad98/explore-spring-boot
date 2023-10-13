package com.vikram.explorespringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ExploreSpringBootApplication {

	public static void main(String[] args) {

		SpringApplication.run(ExploreSpringBootApplication.class, args);

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of a: ");
		int a = sc.nextInt();
		System.out.println("Enter the value of b: ");
		int b= sc.nextInt();
		int result = multiply(a,b);
		System.out.println("Multiplication of "+a+" &"+ " b is:" +result);

	}

	public static int multiply(int a,int b){
		return a*b;
	}

}
