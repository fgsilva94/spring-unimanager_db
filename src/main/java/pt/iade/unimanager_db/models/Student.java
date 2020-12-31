package pt.iade.unimanager_db.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "alunos")
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "alu_id")
  private int id;

  @Column(name = "alu_nome")
  private String name;

  @Column(name = "alu_local")
  private String address;

  @Column(name = "alu_dnsc")
  private LocalDate birthDate;

  @Column(name = "alu_sexo")
  private char gender;

  @Column(name = "alu_email")
  private String email;

  @ManyToOne
  @JoinColumn(name = "alu_cur_id")
  @JsonIgnoreProperties("plans")
  private Course course;

  @OneToMany
  @JoinColumn(name = "ins_alu_id")
  @JsonIgnoreProperties("enrolments")
  private List<Enrolment> enrolments = new ArrayList<>();

  public Student() {
  }

  public Student(int id, String name, String address, LocalDate birthDate, char gender, String email) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.birthDate = birthDate;
    this.gender = gender;
    this.email = email;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public char getGender() {
    return gender;
  }

  public String getEmail() {
    return email;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public List<Enrolment> getEnrolments() {
    return enrolments;
  }
}
