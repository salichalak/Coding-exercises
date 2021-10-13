class Company {
    constructor() {
        this.departments = new Map();
    }

    addEmployee(username, salary, position, department) {
        if (!username || !salary || salary < 0 || !position || !department) {
            throw new Error("Invalid input!");
        }
        let employee = {username, salary, position, department};
        if (this.departments.has(department)) {
            this.departments.get(department).push(employee);
        } else {
            this.departments.set(department, [employee]);
        }

        return `New employee is hired. Name: ${username}. Position: ${position}`;
    }

    bestDepartment() {
        let totalSalary = (department) => {
            let total = department[1].reduce((acc, employee) => {
                return acc += employee.salary
            }, 0);
            let average = (total / department[1].length).toFixed(2);
            department.push(average);
            return average;
        };

        let bestDepartment = [...this.departments].sort((a, b) => totalSalary(b) - totalSalary(a))[0];
        let sortBySalaryAndName = bestDepartment[1].sort((a, b) => b.salary - a.salary
            || a.username.localeCompare(b.username));
        let result = `Best Department is: ${bestDepartment.shift()}\n`;
        result += `Average salary: ${bestDepartment.pop()}\n`;
        sortBySalaryAndName.forEach(e => result += `${e.username} ${e.salary} ${e.position}\n`);

        return result.trim();
    }
}