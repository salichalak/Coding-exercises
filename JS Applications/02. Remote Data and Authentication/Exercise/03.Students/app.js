function solve() {
    getAllStudents();
    document.getElementById('form').addEventListener('submit', createStudent);
}

solve();

async function getAllStudents() {
    const res = await fetch('http://localhost:3030/jsonstore/collections/students');

    if (res.ok != true) {
        const error = await res.json();
        throw new Error(error.message);
    }

    const data = await res.json();
    document.querySelector('tbody').innerHTML = Object.values(data).map(createRow).join('');
}

function createRow(student) {
    return `<tr>
        <td>${student.firstName}</td>
        <td>${student.lastName}</td>
        <td>${student.facultyNumber}</td>
        <td>${student.grade.toFixed(2)}</td>
    </tr>`;
}

async function createStudent(event) {
    event.preventDefault();

    let formData = new FormData(event.target);
    const firstName = formData.get('firstName');
    const lastName = formData.get('lastName');
    const facultyNumber = formData.get('facultyNumber');
    const grade = Number(formData.get('grade'));
    let isValid = firstName && lastName && facultyNumber && Number(grade);

    if (isValid) {
        const student = {
            firstName,
            lastName,
            facultyNumber,
            grade,
        };

        const res = await fetch('http://localhost:3030/jsonstore/collections/students', {
            method: 'post',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(student),
        });

        if (res.ok != true) {
            const error = await res.json();
            throw new Error(error.message);
        }
        const data = await res.json();

        event.target.reset();
        getAllStudents();
    }
}