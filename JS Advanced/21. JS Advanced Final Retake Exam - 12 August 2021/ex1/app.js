window.addEventListener('load', solve);

function solve() {
    const modelField = document.getElementById('model');
    const yearField = document.getElementById('year');
    const descriptionField = document.getElementById('description');
    const priceField = document.getElementById('price');
    const tableBody = document.getElementById('furniture-list');
    const addBtn = document.getElementById('add');

    addBtn.addEventListener('click', function (e) {
        e.preventDefault();

        const dataIsValid = modelField.value && yearField.value && descriptionField.value && priceField.value && yearField.value >= 0 && priceField.value >= 0;

        if (dataIsValid) {
            const newFurniture = `<tr class="info">
                    <td>${modelField.value}</td>
                    <td>${Number(priceField.value).toFixed(2)}</td>
                    <td>
                    <button class="moreBtn">More Info</button>
                    <button class="buyBtn">Buy it</button>
                    </td>
                    </tr>
                    <tr class="hide">
                    <td>Year: ${yearField.value}</td>
                    <td colspan="3">Description: ${descriptionField.value}</td>
                    </tr>`;

            tableBody.innerHTML += newFurniture;
            modelField.value = '';
            yearField.value = '';
            descriptionField.value = '';
            priceField.value = '';
        }

        Array.from(document.querySelectorAll('button.moreBtn')).forEach(b => b.addEventListener('click', function (e) {
            const hideBtn = e.target.parentElement.parentElement.nextElementSibling;

            if (e.target.textContent === 'More Info' && !hideBtn.hasOwnProperty('style')) {
                hideBtn.style.display = 'contents';
                e.target.textContent = 'Less Info';
            } else if (hideBtn.style.display === 'none') {
                hideBtn.style.display = 'contents';
                e.target.textContent = 'Less Info';
            } else if (hideBtn.style.display === 'contents') {
                hideBtn.style.display = 'none';
                e.target.textContent = 'More Info';
            }
        }));


        Array.from(document.querySelectorAll('button.buyBtn')).forEach(b => b.addEventListener('click', function (e) {
            const furniture = e.target.parentElement.parentElement;
            furniture.remove();
            const total = document.querySelector('.total-price');
            const buyPrice = Number(furniture.children[1].textContent);
            const currentTotal = Number(total.textContent);
            total.textContent = (buyPrice + currentTotal).toFixed(2);
        }))
    });
}