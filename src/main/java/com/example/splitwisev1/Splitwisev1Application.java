package com.example.splitwisev1;

import com.example.splitwisev1.helpers.LoaderClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Splitwisev1Application {

    public static void main(String[] args) {

        SpringApplication.run(Splitwisev1Application.class, args);
        new LoaderClass();
        System.out.println("Its working finally");
        Scanner scanner = new Scanner(System.in);
        scanner.next();
    }

}
