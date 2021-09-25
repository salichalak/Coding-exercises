function solve() {
    const text = document.getElementById("text").value;
    const convention = document.getElementById("naming-convention").value;

    let output = '';
    if (convention === 'Pascal Case') {
        output = text
            .toLowerCase()
            .split(' ')
            .map(x => x[0].toUpperCase() + x.slice(1))
            .join('');
    } else if (convention === 'Camel Case') {
        output = text
            .toLowerCase()
            .split(' ')
            .map((x, i) => x = i !== 0 ? x[0].toUpperCase() + x.slice(1) : x)
            .join('')
    } else {
        output = 'Error!';
    }

    let spanElement = document.getElementById('result');
    spanElement.textContent = output;
}