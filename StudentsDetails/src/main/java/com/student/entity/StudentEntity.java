package com.student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {
	@Id
	private int departmentId;
	private String studentName;
	private String departmentName;
	private String collegeName;
	private String location;
	
}
