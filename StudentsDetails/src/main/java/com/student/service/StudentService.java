package com.student.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.student.entity.StudentEntity;
import com.student.model.CreateStudent;

@Service
public interface StudentService {
	StudentEntity createStudent(CreateStudent createStudent);
	List<StudentEntity> getAllDetails();
	StudentEntity departmentfindById(int departmentId);
	StudentEntity updateDetailsById(int departmentId, StudentEntity entity);
	void deleteDepartmentById(int departmentId);
}
