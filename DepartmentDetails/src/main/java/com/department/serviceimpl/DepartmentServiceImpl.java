package com.department.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.department.entity.DepartmentEntity;
import com.department.model.CreateReqBody;
import com.department.repo.DepartmentRepository;
import com.department.service.DepartmentService;

@Component
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	DepartmentRepository repo;
	@Override
	public List<DepartmentEntity> getAllDetailsInDb() {
		return repo.findAll();
	}
	@Override
	public DepartmentEntity createDepartment(CreateReqBody req) {
		DepartmentEntity d = new DepartmentEntity(0, req.getDepartmentName(), req.getCollegeName());
		DepartmentEntity save = repo.save(d);
		return save;
	}
	@Override
	public DepartmentEntity departmentfindById(int departmentId) {
		DepartmentEntity entity = null;
		Optional<DepartmentEntity> findById = repo.findById(departmentId);
		if(findById.isPresent()) {
			entity = findById.get();
		}
		return entity;
	}
	@Override
	public DepartmentEntity updateDetailsById(int departmentId, DepartmentEntity departmentEntity) {
		DepartmentEntity updateData = null;
		Optional<DepartmentEntity> findById = repo.findById(departmentId);
		if(findById.isPresent()) {
			updateData = findById.get();
			int departmentId2 = departmentEntity.getDepartmentId();
			String departmentName = departmentEntity.getDepartmentName();
			String collegeName = departmentEntity.getCollegeName();
			updateData.setDepartmentId(departmentId2);
			updateData.setDepartmentName(departmentName);
			updateData.setCollegeName(collegeName);
		}
		return repo.save(updateData);
	}
	@Override
	public void deleteDepartmentById(int departmentId) {
		Optional<DepartmentEntity> findById = repo.findById(departmentId);
		if(findById.isPresent()) {
			DepartmentEntity entity = findById.get();
			 repo.delete(entity);
		}
	}
	
}
