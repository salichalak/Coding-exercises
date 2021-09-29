function encodeAndDecodeMessages() {
    const main = document.getElementById('main');
    const decodedMessage = document.getElementsByTagName('textarea')[0];
    const encodedMessage = document.getElementsByTagName('textarea')[1];

    main.addEventListener('click', (ev) => {
        if (ev.target.tagName === 'BUTTON') {
            if (ev.target.textContent.includes('Encode')) {
                const message = decodedMessage.value;
                let encoded = [];

                for (let i = 0; i < message.length; i++) {
                    let character = message.charCodeAt(i);
                    encoded.push(String.fromCharCode(character + 1));
                }
                decodedMessage.value = '';
                encodedMessage.value = encoded.join('');
            } else if (ev.target.textContent.includes('Decode')) {
                const message = encodedMessage.value;
                let decoded = [];
                for (let i = 0; i < message.length; i++) {
                    let character = message.charCodeAt(i);
                    decoded.push(String.fromCharCode(character - 1));
                }
                encodedMessage.value = decoded.join('');
            }
        }
    });
}