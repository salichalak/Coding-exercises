function deleteByEmail() {
    const input = document.querySelector('input[name= "email"]');

    const rows = Array.from(document.querySelector('tbody').children)
        .filter(row => row.children[1].textContent === input.value);

    for (let i = 0; i < rows.length; i++) {
        rows[i].remove();
    }
    document.getElementById('result').textContent = rows.length > 0
        ? 'Deleted.'
        : 'Not found.';
}