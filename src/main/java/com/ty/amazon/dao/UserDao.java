package com.ty.amazon.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.amazon.dto.User;

@Repository
public class UserDao {
	
	@Autowired
	EntityManager entityManager;
	
	@Autowired
	EntityTransaction entityTransaction;
	
	public User saveUser(User user) {
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return user;
	}
	
	public void deleteUserById(int id) {
		User user = entityManager.find(User.class, id);
		entityTransaction.begin();
		entityManager.remove(user);
		entityTransaction.commit();
	}
	public void updateUser(User user) {
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();
	}
	public User getUserById(int id) {
		return entityManager.find(User.class, id);
	}
	public List<User> getAllUser(){
		 return entityManager.createQuery("SELECT u FROM User u").getResultList();
	}
	public User loginUser(String email,String password) {
		Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.email=?1 AND u.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		
		try {
			User user = (User) query.getSingleResult();
			return user;
		} catch (Exception e) {
			return null;
		}
	}

}
