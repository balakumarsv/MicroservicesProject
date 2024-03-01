package com.student.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.student.model.DepartmentEntity;

@Configuration
public class StudentRestTemplate {
	@Autowired
	private RestTemplate rest;
	public DepartmentEntity getDepartmentEntityById(int departmentId) {
		ResponseEntity<DepartmentEntity> exchange = rest.exchange("http://localhost:8085/department/details/findById?id="+departmentId, HttpMethod.GET, null, DepartmentEntity.class);
		DepartmentEntity body = exchange.getBody();
		return body;
	}
	
}
