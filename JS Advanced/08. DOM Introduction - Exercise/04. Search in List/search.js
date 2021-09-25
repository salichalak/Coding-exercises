function search() {
    const input = document.getElementById('searchText').value;
    const output = document.getElementById('result');
    const towns = Array.from(document.getElementById('towns').children);
    let matches = 0

    towns.forEach(town => {
        if (town.innerHTML.includes(input)) {
            town.style.textDecoration = 'bold underline';
            matches++;
        }
    });

    output.innerHTML = `${matches} matches found`;
}