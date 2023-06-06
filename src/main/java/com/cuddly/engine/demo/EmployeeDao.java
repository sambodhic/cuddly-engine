package com.cuddly.engine.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cuddly.engine.entities.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
	public void createEmployee(Employee employee){
		Session session= null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.persist(employee);
			System.out.println("Employee created is:: "+employee.toString());
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public void readEmployee(Employee employee){
		Session session= null;
		try {
			session = sessionFactory.openSession();
			session.getReference(employee.getClass(), employee.getId());
			System.out.println("Employee read is:: "+employee.toString());
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void updateEmployee(Employee employee){
		Session session= null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.merge(employee);
			System.out.println("Employee updated is:: "+employee.toString());
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void deleteEmployee(Employee employee){
		Session session= null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.remove(session.getReference(employee.getClass(), employee.getId()));
			System.out.println("Employee deleted is:: "+employee.toString());
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}