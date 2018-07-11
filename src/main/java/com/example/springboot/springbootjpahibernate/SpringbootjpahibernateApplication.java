package com.example.springboot.springbootjpahibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.context.ApplicationContext;

import com.example.springboot.springbootjpahibernate.processor.EmailPreferenceProcessor;

@SpringBootApplication (exclude = {JpaRepositoriesAutoConfiguration.class})
public class SpringbootjpahibernateApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootjpahibernateApplication.class, args);
		EmailPreferenceProcessor emailPrefProcessor = context.getBean(EmailPreferenceProcessor.class);
		emailPrefProcessor.processEmailPreference();
	}
}
