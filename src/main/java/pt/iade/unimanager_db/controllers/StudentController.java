package pt.iade.unimanager_db.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.unimanager_db.models.Student;
import pt.iade.unimanager_db.repositories.StudentRepository;

@RestController
@RequestMapping(path = "/api/students")
public class StudentController {
  private Logger logger = LoggerFactory.getLogger(StudentController.class);

  @Autowired
  private StudentRepository studentRepository;

  @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Student> getStudents() {
    logger.info("Sending all students");
    return studentRepository.findAll();
  }
}
