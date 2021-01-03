let unitId;
let courseId;

window.onload = async function () {
  unitId = sessionStorage.getItem("unitId");
  courseId = sessionStorage.getItem("courseId");
  let elem = document.getElementById("students");

  try {
    let plan = await $.ajax({
      url: `/api/plans/${courseId}/${unitId}`,
      method: "get",
      dataType: "json",
    });

    document.getElementById("unit").innerHTML = plan.unit.name;

    let html = "";

    for (let enrolment of plan.enrolments) {
      html += `<section class="btn" onclick="showStudent(${enrolment.id})">
        <h3 class="name">${enrolment.student.name}</h3>
        <section class="grade">${
          enrolment.grade === null ? "Not Graded" : "Grade: " + enrolment.grade
        }</section>
      </section>`;
    }

    elem.innerHTML = html;
  } catch (err) {
    console.log(err);
    elem.innerHTML = "<h1>Page not available</h1>";
  }
};

function showStudent(id) {
  sessionStorage.setItem("enrolmentId", id);
  window.location = "student.html";
}
