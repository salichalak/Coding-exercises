function sumTable() {
    let cost = Array.from(document.querySelectorAll('tr td:nth-child(2)'));
    let sum = cost.pop();
    sum.textContent = cost.reduce((a, x) => a + Number(x.textContent), 0);
}

function sumTable() {
    let dataCells = Array.from(document.getElementsByTagName("td"));

    document.getElementById("sum").innerHTML = dataCells
        .slice(0, dataCells.length - 1)
        .reduce((a, v) => a + (Number(v.innerHTML) || 0), 0)
}