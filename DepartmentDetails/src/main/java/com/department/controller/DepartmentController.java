package com.department.controller;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.department.entity.DepartmentEntity;
import com.department.model.CreateReqBody;
import com.department.serviceimpl.DepartmentServiceImpl;

@RestController
@RequestMapping("department/details")
public class DepartmentController {
	@Autowired
	DepartmentServiceImpl impl;
	@GetMapping(value ="/getAll")
	public ResponseEntity<List<DepartmentEntity>> getAllDetails() {
		return ResponseEntity.ok(impl.getAllDetailsInDb());
	}
	@PostMapping(value = "/create")
	public ResponseEntity<DepartmentEntity> createDepartment(@RequestBody CreateReqBody req) {
		DepartmentEntity createDepartment = impl.createDepartment(req);
		return ResponseEntity.status(HttpStatus.CREATED).body(createDepartment);
	}
	@GetMapping(value ="/findById")
	public ResponseEntity<DepartmentEntity> findById(@RequestParam int id) {
	 DepartmentEntity departmentfindById = impl.departmentfindById(id);	
	 if (departmentfindById != null) {
         return ResponseEntity.ok(departmentfindById);
     } else {
         return ResponseEntity.notFound().build();
     }
	}
	@PutMapping(value = "/updateDetails/{id}")
	public ResponseEntity<DepartmentEntity> updateDetails(@PathVariable int id, @RequestBody Map<String, String> request) {
		 DepartmentEntity departmentEntity = impl.departmentfindById(id);
		 if (departmentEntity != null) {
		        // Update departmentName if present in the request
		        if (request.containsKey("departmentName")) {
		            departmentEntity.setDepartmentName(request.get("departmentName"));
		        }
		        // Update collegeName if present in the request
		        if (request.containsKey("collegeName")) {
		            departmentEntity.setCollegeName(request.get("collegeName"));
		        }
		        DepartmentEntity updatedEntity = impl.updateDetailsById(id, departmentEntity);
		        return ResponseEntity.ok(updatedEntity);
		 } 
		 return ResponseEntity.notFound().build();
		    }	
	@DeleteMapping(value ="/delete/{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable int id) {
		 impl.deleteDepartmentById(id);
		 return ResponseEntity.ok("Deleted");
	}
}
