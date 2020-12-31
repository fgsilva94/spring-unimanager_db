package pt.iade.unimanager_db.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "inscricoes")
public class Enrolment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ins_id")
  private int id;

  @Column(name = "ins_alu_id")
  @JsonIgnore
  private int studentId;

  @ManyToOne
  @MapsId("studentId")
  @JoinColumn(name = "ins_alu_id")
  @JsonIgnoreProperties({ "enrolments", "course" })
  private Student student;

  @Column(name = "ins_pla_cur_id")
  @JsonIgnore
  private int courseId;

  @ManyToOne
  @MapsId("courseId")
  @JoinColumn(name = "ins_pla_cur_id")
  @JsonIgnoreProperties("plans")
  private Course course;

  @Column(name = "ins_pla_dis_id")
  @JsonIgnore
  private int unitId;

  @ManyToOne
  @MapsId("unitId")
  @JoinColumn(name = "ins_pla_dis_id")
  @JsonIgnoreProperties("plans")
  private Unit unit;

  @Column(name = "ins_dt_inscricao")
  private LocalDate enrolmentDate;

  @Column(name = "ins_dt_avaliacao")
  private LocalDate evaluationDate;

  @Column(name = "ins_nota")
  private Double grade;

  public Enrolment() {
  }

  public Enrolment(int id, Student student, Course course, Unit unit, LocalDate enrolmentDate,
      LocalDate evaluationDate) {
    this.id = id;
    this.student = student;
    this.course = course;
    this.unit = unit;
    this.enrolmentDate = enrolmentDate;
    this.evaluationDate = evaluationDate;
  }

  public int getId() {
    return id;
  }

  public int getStudentId() {
    return studentId;
  }

  public Student getStudent() {
    return student;
  }

  public int getCourseId() {
    return courseId;
  }

  public Course getCourse() {
    return course;
  }

  public int getUnitId() {
    return unitId;
  }

  public Unit getUnit() {
    return unit;
  }

  public LocalDate getEnrolmentDate() {
    return enrolmentDate;
  }

  public void setEnrolmentDate(LocalDate enrolmentDate) {
    this.enrolmentDate = enrolmentDate;
  }

  public LocalDate getEvaluationDate() {
    return evaluationDate;
  }

  public void setEvaluationDate(LocalDate evaluationDate) {
    this.evaluationDate = evaluationDate;
  }

  public Double getGrade() {
    return grade;
  }

  public void setGrade(Double grade) {
    this.grade = grade;
  }
}
