package com.bilyari;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class BilyariApplication {

    public static void main(String[] args) {
        SpringApplication.run(BilyariApplication.class, args);
        System.out.printf("Bilyari has been successfully stated at: (%s)%n",
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss")));
    }

}
