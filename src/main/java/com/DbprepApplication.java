package com;

import com.db.MyDB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DbprepApplication {
    public static void main(String[] args) {
       // SpringApplication.run(DbprepApplication.class, args);
        MyDB myDB = new MyDB();
    }
}
