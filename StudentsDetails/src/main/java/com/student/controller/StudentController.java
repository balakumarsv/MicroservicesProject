package com.student.controller;

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
import com.student.entity.StudentEntity;
import com.student.model.CreateStudent;
import com.student.serviceimpl.StudentServiceImpl;

@RestController
@RequestMapping("student/details")
public class StudentController {
	@Autowired
	StudentServiceImpl impl;
	
	@PostMapping(value ="/create")
	public ResponseEntity<StudentEntity> CreateStudentDetails(@RequestBody CreateStudent createStudent) {
		return ResponseEntity.status(HttpStatus.CREATED).body(impl.createStudent(createStudent));
	}
	
	@GetMapping(value = "/getAll")
	public ResponseEntity<List<StudentEntity>> getAllDetails() {
		 return ResponseEntity.ok(impl.getAllDetails());
		 
	}
	@GetMapping(value ="/findById")
	public ResponseEntity<StudentEntity> findById(@RequestParam int id) {
		StudentEntity studentEntity = impl.departmentfindById(id);	
	 if (studentEntity != null) {
         return ResponseEntity.ok(studentEntity);
     } else {
         return ResponseEntity.notFound().build();
     }
	}
	@PutMapping(value = "/updateDetails/{id}")
	public ResponseEntity<StudentEntity> updateDetails(@PathVariable int id, @RequestBody Map<String, String> request) {
		StudentEntity studentEntity = impl.departmentfindById(id);
		 if (studentEntity != null) {
		        // Update departmentName if present in the request
			 if (request.containsKey("departmentName")) {
				 studentEntity.setDepartmentName(request.get("departmentName"));
			 }
		        // Update collegeName if present in the request
		     if (request.containsKey("collegeName")) {
		    	 studentEntity.setCollegeName(request.get("collegeName"));
		     }
		     StudentEntity updatedEntity = impl.updateDetailsById(id, studentEntity);
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
