function attachEvents() {
    const sendBtn = document.getElementById('submit');
    const refreshBtn = document.getElementById('refresh');

    sendBtn.addEventListener('click', async () => {
        const authorField = document.querySelector('[name="author"]');
        const author = authorField.value;
        const contentField = document.querySelector('[name="content"]');
        const content = contentField.value;

        createMessage({ author, content });
        contentField.value = '';
    });

    refreshBtn.addEventListener('click', loadMessages);
}

async function createMessage(message) {
    await fetch('http://localhost:3030/jsonstore/messenger', {
        method: 'post',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(message),
    });
}

async function loadMessages() {
    const res = await fetch('http://localhost:3030/jsonstore/messenger');
    const data = await res.json();
    const messages = Object.values(data).map(m => `${m.author}: ${m.content}`).join('\n');
    const messagesField = document.getElementById('messages');
    messagesField.value = messages;
}

attachEvents();