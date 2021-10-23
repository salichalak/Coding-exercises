function solution() {
    const inputField = document.querySelector('div > input[type=text]');
    const addGiftBtn = document.querySelector('div > button');
    let ul = document.querySelector('body > div > section:nth-child(2) > ul');

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
        ul.appendChild(li);


        let liElements = Array.from(ul.querySelectorAll('li'));
        let sortedLiElements = liElements
            .sort((a, b) => a.innerText.localeCompare(b.innerText));

        while (ul.firstChild) {
            ul.firstChild.remove();
        }

        for (const element of sortedLiElements) {
            ul.appendChild(element);
        }

        inputField.value = '';

        sendBtn.addEventListener('click', function (e) {
            e.preventDefault();

            let sentItemsList = document.querySelector('.container > section:nth-of-type(3) > ul');
            e.target.remove();
            discardBtn.remove();
            sentItemsList.appendChild(li);
        });

        discardBtn.addEventListener('click', function (e) {
            e.preventDefault();

            let discardItemsList = document.querySelector('.container > section:nth-of-type(4) > ul');
            e.target.remove();
            sendBtn.remove();
            discardItemsList.appendChild(li);
        })
    });
}