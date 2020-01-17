package com.cdac.irp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdac.irp.MD5;
import com.cdac.irp.models.StudentRegisterModel;
import com.cdac.irp.pojos.Student;


@Repository
public class StudentDaoImpl implements IStudentDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public Student Authenticate(String email, String password) {
		Student s;
		String jpql = "select s from Student s where s.email=:em and s.password=:pa";
		try {
			s = entityManager.unwrap(Session.class).createQuery(jpql, Student.class).setParameter("em", email)
					.setParameter("pa", password).getSingleResult();
		} catch (Exception e) {
			return null;
		}
		return s;
	}

	@Override
	public List<Student> getAllStudents() {
		String jpql = "select s from Student s";
		return entityManager.unwrap(Session.class).createQuery(jpql, Student.class).getResultList();
	}

	@Override
	public void Registration(StudentRegisterModel regStudent) {
		// String jpql = "Insert into Student s
		// (s.firstName,s.lastName,s.email,s.password,s.birthDate) values
		// (:fn,:ln,:em,:pa,:bd)";
		// entityManager.createNativeQuery(jpql).setParameter("fn",
		// regStudent.getFirstName()).setParameter("ln",
		// regStudent.getLastName()).setParameter("em",
		// regStudent.getEmail()).setParameter("pa",
		// regStudent.getPassword()).setParameter("bd", regStudent.getBirthDate());
		String jpql = "Insert into Student (prn,first_name,last_name,email,password,birth_date) values (?,?,?,?,?,?)";
		entityManager.createNativeQuery(jpql).setParameter(1, regStudent.getPrn())
				.setParameter(2, regStudent.getFirstName()).setParameter(3, regStudent.getLastName())
				.setParameter(4, regStudent.getEmail()).setParameter(5, MD5.getMd5(regStudent.getPassword()))
				.setParameter(6, regStudent.getBirthDate()).executeUpdate();
		System.out.println(regStudent);
	}


}
