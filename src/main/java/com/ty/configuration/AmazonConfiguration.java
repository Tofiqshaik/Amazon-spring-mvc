package com.ty.configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ty")
public class AmazonConfiguration {
	
	@Bean
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("amazon").createEntityManager();
	}
	
	@Bean
	public EntityTransaction getEntityTransaction() {
		return getEntityManager().getTransaction();
	}

}
