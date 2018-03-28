package se.coredev.repository;

import se.coredev.data.Department;

import java.util.List;

public interface DepartmentRepository {

    Department addDepartment(Department department);

    Department getDepartmentById(Long id);
}
