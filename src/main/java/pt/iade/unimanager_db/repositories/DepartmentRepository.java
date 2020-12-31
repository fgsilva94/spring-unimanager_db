package pt.iade.unimanager_db.repositories;

import org.springframework.data.repository.CrudRepository;

import pt.iade.unimanager_db.models.Department;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {

}
