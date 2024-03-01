package com.department.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.department.entity.DepartmentEntity;
import com.department.model.CreateReqBody;
@Service
public interface DepartmentService {
	List<DepartmentEntity> getAllDetailsInDb();
	DepartmentEntity createDepartment(CreateReqBody req);
	DepartmentEntity departmentfindById(int departmentId);
	DepartmentEntity updateDetailsById(int departmentId, DepartmentEntity departmentEntity);
	void deleteDepartmentById(int departmentId);
}
