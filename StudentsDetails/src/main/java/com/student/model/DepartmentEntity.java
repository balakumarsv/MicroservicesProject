package com.student.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentEntity {
	private int  departmentId;
	private String departmentName;
	private String CollegeName;
}
