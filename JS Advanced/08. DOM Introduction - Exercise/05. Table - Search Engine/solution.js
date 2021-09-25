function solve() {
    document.querySelector('#searchBtn').addEventListener('click', onClick);

    function onClick() {
        let searchBox = document.getElementById('searchField');
        let input = searchBox.value;
        let rows = Array.from(document.querySelectorAll('tbody tr'));

        rows.forEach(el => {
            el.className = '';
        });

        let filteredRows = rows.filter(el => {
            if (Array.from(el.children).some(x => x.textContent.includes(input))) {
                el.className = 'select';
            }
        });
        searchBox.value = '';
    }
}