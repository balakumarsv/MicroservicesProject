package com.student.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.student.entity.StudentEntity;
import com.student.model.CreateStudent;
import com.student.model.DepartmentEntity;
import com.student.repo.StudentRepository;
import com.student.resttemplate.StudentRestTemplate;
import com.student.service.StudentService;

@Component
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository repo;
	@Autowired
	private StudentRestTemplate template;
	@Override
	public StudentEntity createStudent(CreateStudent createStudent) {
		int departmentId = createStudent.getDepartmentId();
		String studentName = createStudent.getStudentName();
		String location = createStudent.getLocation();
		DepartmentEntity departmentEntityById = template.getDepartmentEntityById(departmentId);
		StudentEntity entity = new StudentEntity(departmentId, studentName, departmentEntityById.getDepartmentName(), departmentEntityById.getCollegeName(), location);
		return repo.save(entity);
	}
	@Override
	public List<StudentEntity> getAllDetails() {
		return repo.findAll();
	}
	@Override
	public StudentEntity departmentfindById(int departmentId) {
		StudentEntity entity = null;
		Optional<StudentEntity> findById = repo.findById(departmentId);
		if(findById.isPresent()) {
			entity = findById.get();
		}
		return entity;
	}
	@Override
	public StudentEntity updateDetailsById(int departmentId, StudentEntity entity) {
		StudentEntity updateData = null;
		Optional<StudentEntity> findById = repo.findById(departmentId);
		if(findById.isPresent()) {
			updateData = findById.get();
			int departmentId2 = entity.getDepartmentId();
			String departmentName = entity.getDepartmentName();
			String collegeName = entity.getCollegeName();
			String studentName = entity.getStudentName();
			updateData.setDepartmentId(departmentId2);
			updateData.setDepartmentName(departmentName);
			updateData.setCollegeName(collegeName);
			updateData.setStudentName(studentName);
		}
		return repo.save(updateData);
	}

	@Override
	public void deleteDepartmentById(int departmentId) {
		Optional<StudentEntity> findById = repo.findById(departmentId);
		if(findById.isPresent()) {
			StudentEntity entity = findById.get();
			 repo.delete(entity);
		}
	}
	}
	
	

