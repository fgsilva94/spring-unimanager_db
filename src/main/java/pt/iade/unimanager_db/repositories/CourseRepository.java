package pt.iade.unimanager_db.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import pt.iade.unimanager_db.models.Course;
import pt.iade.unimanager_db.models.Plan;

public interface CourseRepository extends CrudRepository<Course, Integer> {
  @Modifying
  @Transactional
  @Query(value = "INSERT INTO planoestudos " + "(pla_cur_id, pla_dis_id, pla_semestre) "
      + "values(:#{#plan.course.id}, :#{#plan.unit.id}, :#{#plan.semester})", nativeQuery = true)
  void addUnitToCourse(@Param("plan") Plan plan);
}
