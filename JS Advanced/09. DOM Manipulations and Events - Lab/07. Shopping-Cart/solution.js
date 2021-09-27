function solve() {
    let textArea = document.querySelector('body > div > textarea');
    let totalPrice = 0;
    let uniqueThingsList = [];
    let addBtn = document.getElementsByClassName('add-product');
    let addButtonArr = Array.from(addBtn);

    for (let i = 0; i < addButtonArr.length; i++) {
        addButtonArr[i].addEventListener('click', function one() {
            let name = document.querySelector(`body > div > div:nth-child(${i + 2}) > div.product-details > div`).textContent;
            let price = document.querySelector(`body > div > div:nth-child(${i + 2}) > div.product-line-price`).textContent;
            if (!uniqueThingsList.includes(name)) {
                uniqueThingsList.push(name);
            }
            let result = `Added ${name} for ${price} to the cart.\n`;
            totalPrice += Number(price);
            textArea.value += result;
        });
    }

    let checkOut = document.querySelector('body > div > button');

    checkOut.addEventListener('click', function final() {
        let finalSting = `You bought ${uniqueThingsList.join(', ')} for ${totalPrice.toFixed(2)}.`;
        textArea.value += finalSting;
        disableButtons();
    });

    function disableButtons() {
        let buttons = Array.from(document.querySelectorAll('button'));
        buttons.forEach(button => button.disabled = true);
    }
}