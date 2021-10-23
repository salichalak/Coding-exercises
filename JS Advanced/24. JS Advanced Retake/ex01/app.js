function solution() {
    const inputField = document.querySelector('div > input[type=text]');
    const addGiftBtn = document.querySelector('div > button');
    let gifts_ul = document.querySelector('body > div > section:nth-child(2) > ul');

    addGiftBtn.addEventListener('click', function (e) {
        e.preventDefault();

        const li = document.createElement('li');
        li.classList.add('gift');
        li.textContent = inputField.value;

        const sendBtn = document.createElement('button');
        sendBtn.setAttribute('id', 'sendButton');
        sendBtn.textContent = 'Send';

        const discardBtn = document.createElement('button');
        discardBtn.setAttribute('id', 'discardButton');
        discardBtn.textContent = 'Discard';

        li.appendChild(sendBtn);
        li.appendChild(discardBtn);
        gifts_ul.appendChild(li);

        let sortedLiElements = Array.from(gifts_ul.querySelectorAll('li'))
            .sort((a, b) => a.innerText.localeCompare(b.innerText));

        while (gifts_ul.firstChild) {
            gifts_ul.firstChild.remove();
        }

        for (const element of sortedLiElements) {
            gifts_ul.appendChild(element);
        }

        inputField.value = '';

        sendBtn.addEventListener('click', function (e) {
            e.preventDefault();

            let sentList = document.querySelector('.container > section:nth-of-type(3) > ul');
            e.target.remove();
            discardBtn.remove();
            sentList.appendChild(li);
        });

        discardBtn.addEventListener('click', function (e) {
            e.preventDefault();

            let discardList = document.querySelector('.container > section:nth-of-type(4) > ul');
            e.target.remove();
            sendBtn.remove();
            discardList.appendChild(li);
        })
    });
}