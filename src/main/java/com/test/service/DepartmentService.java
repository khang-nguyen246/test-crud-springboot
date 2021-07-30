package com.test.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.Department;
import com.test.repository.IDepartmentRepository;
@Service
public class DepartmentService implements IDepartmentService {
@Autowired
private IDepartmentRepository departmentRepository;
public List<Department> getAllDepartments() {
return departmentRepository.findAll();
}
}
