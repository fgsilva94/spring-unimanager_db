let enrolmentId;

window.onload = async function () {
  enrolmentId = sessionStorage.getItem("enrolmentId");
  try {
    let enrolment = await $.ajax({
      url: `/api/enrolments/${enrolmentId}`,
      method: "get",
      dataType: "json",
    });

    document.getElementById("student").innerHTML = enrolment.student.name;
    let student = enrolment.student;
    let html = "";
    html += `<div class="studentData">
          <h2>${enrolment.course.name} - ${enrolment.unit.name}</h2>
          <p>Id: ${student.id}</p>
          <p>Name: ${student.name}</p>
          <p>Address: ${student.address}</p>
          <p>Birth Date: ${student.birthDate}</p>
          <p>Gender: ${student.gender}</p>
          <p>Email: ${student.email}</p>
        </div>
        <div class="studentGrade">
        <form class="grade">
        <label for="grade">Grade: </label>
        <input type="text" id="grade" name="grade" value="${
          enrolment.grade === null ? 0 : enrolment.grade
        }">
        <input type="button" onclick="gradeStudent()" value="Set Grade">
        </form>
        </div>`;

    document.getElementById("info").innerHTML = html;
  } catch (err) {
    console.log(err);
  }
};

async function gradeStudent() {
  try {
    let grade = parseFloat(document.getElementById("grade").value);

    if (typeof grade === "number" && grade > 0 && grade <= 20) {
      let result = await $.ajax({
        url: `/api/enrolments/${enrolmentId}/grade`,
        method: "put",
        data: JSON.stringify(grade),
        dataType: "json",
        contentType: "application/json",
      });

      alert(`${result.student.name} successfully graded!`);
    } else {
      alert(`Error grading the student`);
    }
  } catch (err) {
    console.log(err);
  }
}
