function attachEvents() {
    const createBtn = document.getElementById('btnCreate');
    createBtn.addEventListener('click', async () => {
        const personField = document.getElementById('person');
        const person = personField.value;
        const phoneField = document.getElementById('phone');
        const phone = phoneField.value;

        if (personField.value && personField.value !== '' && phoneField.value && phoneField.value !== '') {
            await createNewRecord({ person, phone });
            personField.value = '';
            phoneField.value = '';
            await loadRecords();
        }
    });

    document.getElementById('btnLoad').addEventListener('click', loadRecords);
}

function createElement(type, content, attributes = []) {
    const element = document.createElement(type);
    if (content && content !== '') {
        element.textContent = content;
    }
    if (attributes.length > 0) {
        element.setAttribute(attributes[0], attributes[1]);
    }
    return element;
}

async function loadRecords() {
    const res = await fetch('http://localhost:3030/jsonstore/phonebook');
    const data = await res.json();
    const phonebook = document.getElementById('phonebook');
    phonebook.innerHTML = '';

    Object.values(data).forEach(p => {
        const li = createElement('li', `${p.person}: ${p.phone}`);
        const deleteBtn = createElement('button', 'Delete', ['id', p._id]);
        li.appendChild(deleteBtn);
        phonebook.appendChild(li);
        deleteBtn.addEventListener('click', deleteRecord);
    });
}

async function createNewRecord(record) {
    const res = await fetch('http://localhost:3030/jsonstore/phonebook', {
        method: 'post',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(record),
    });
    const data = res.json();
    return data;
}

async function deleteRecord(event) {
    await fetch('http://localhost:3030/jsonstore/phonebook/' + event.target.id, {
        method: 'delete',
    });
    await loadRecords();
}

attachEvents();