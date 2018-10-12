package com.revature.ServletChallenge.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.ServletChallenge.models.Users;
import com.revature.ServletChallenge.util.HibernateUtil;

public class HibernateDAO {
	public List<Users> getUsers() {
		Session session = HibernateUtil.getSession();
		return session.createQuery("from User").list();
	}
	
	public Users getUserByName(String aName) {
		Users found = null;
		List<Users> users = new ArrayList<>();
		Session session = HibernateUtil.getSession();
		users = session.createQuery(
				"from User where name = :nameVar")
				.setString("nameVar", aName).list();
		
		if (!users.isEmpty()) {
			found = users.get(0);
		}
		
		return found;
	}
	
	
	public int saveAnimal(Users u) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		int result = (int) session.save(u);
		tx.commit();
		return result;
	}
}
