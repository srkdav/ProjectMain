package com.cdac.irp.service;

import java.util.List;

import com.cdac.irp.models.StudentRegisterModel;
import com.cdac.irp.pojos.Student;
import com.cdac.irp.pojos.TimeTable;

public interface IStudentService {

	Student Authenticate(String email, String password);

	List<Student> getAllStudents();

	void RegisterStudent(StudentRegisterModel _student);


}
