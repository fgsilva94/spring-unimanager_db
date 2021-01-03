package pt.iade.unimanager_db.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.unimanager_db.models.Enrolment;
import pt.iade.unimanager_db.models.exceptions.NotFoundException;
import pt.iade.unimanager_db.repositories.EnrolmentRepository;

@RestController
@RequestMapping(path = "/api/enrolments")
public class EnrolmentController {
  private Logger logger = LoggerFactory.getLogger(StudentController.class);

  @Autowired
  private EnrolmentRepository enrolmentRepository;

  @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Enrolment getEnrolment(@PathVariable int id) {
    logger.info("Sending enrolment with id " + id);
    Optional<Enrolment> _enrolment = enrolmentRepository.findById(id);

    if (_enrolment.isEmpty()) {
      throw new NotFoundException("" + id, "Enrolment", "id");
    } else {
      return _enrolment.get();
    }
  }

  @PutMapping(path = "/{id:[0-9]+}/grade", produces = MediaType.APPLICATION_JSON_VALUE)
  public Enrolment setGrade(@PathVariable("id") int id, @RequestBody double grade) throws NotFoundException {
    logger.info("Setting grade of enrolment with id " + id);
    Optional<Enrolment> _enrolment = enrolmentRepository.findById(id);

    if (_enrolment.isEmpty()) {
      throw new NotFoundException("" + id, "Enrolment", "id");
    } else {
      Enrolment enr = _enrolment.get();
      enr.setGrade(grade);
      enrolmentRepository.save(enr);
      return enr;
    }
  }
}
