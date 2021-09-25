function generateReport() {
    let checkboxes = document.querySelectorAll("input[type='checkbox']");
    let rows = document.getElementsByTagName("tr");
    let output = document.getElementById("output");

    const selected = Array.from(checkboxes)
        .map((x, i) => [x, i])
        .filter(x => x[0].checked)
        .map(x => [x[0].name, x[1]]);

    const rowData = Array.from(rows)
        .slice(1)
        .map(x => Array.from(x.children).map(x => x.innerHTML));

    output.value = JSON.stringify(rowData.map(x => selected
            .reduce((a, v) => {
                const [sColName, sColIndex] = v
                a[sColName] = x[sColIndex]
                return a
            }, {})
        )
    )
}