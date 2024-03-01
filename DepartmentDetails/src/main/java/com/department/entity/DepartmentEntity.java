package com.department.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Department_Entity")
public class DepartmentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_seq_generator")
    @SequenceGenerator(name="department_seq_generator", sequenceName = "department_seq", allocationSize = 1)
	private int  departmentId;
	
	private String departmentName;
	
	private String CollegeName;
}
