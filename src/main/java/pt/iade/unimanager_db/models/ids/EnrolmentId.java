package pt.iade.unimanager_db.models.ids;

import java.io.Serializable;

public class EnrolmentId implements Serializable {
  private static final long serialVersionUID = 1L;
  private int studentId;
  private int courseId;
  private int unitId;

  public EnrolmentId() {
  }

  public EnrolmentId(int studentId, int courseId, int unitId) {
    this.studentId = studentId;
    this.courseId = courseId;
    this.unitId = unitId;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public int getStudentId() {
    return studentId;
  }

  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }

  public int getCourseId() {
    return courseId;
  }

  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }

  public int getUnitId() {
    return unitId;
  }

  public void setUnitId(int unitId) {
    this.unitId = unitId;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + courseId;
    result = prime * result + studentId;
    result = prime * result + unitId;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    EnrolmentId other = (EnrolmentId) obj;
    if (courseId != other.courseId)
      return false;
    if (studentId != other.studentId)
      return false;
    if (unitId != other.unitId)
      return false;
    return true;
  }
}
