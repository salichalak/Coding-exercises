function bookLibrary() {
    document.getElementById('loadBooks').addEventListener('click', loadBooks);
    document.getElementById('createForm').addEventListener('submit', onCreate);
    document.getElementById('editForm').addEventListener('submit', onUpdate);
    document.querySelector('table').addEventListener('click', onClick);
}

bookLibrary();

async function loadBooks() {
    const books = await request('http://localhost:3030/jsonstore/collections/books');
    document.querySelector('body > table > tbody').innerHTML = Object.entries(books).map(createRow).join('');
}

function onClick(event) {
    event.target.className === 'deleteBtn'
        ? deleteBook(event.target.parentNode.parentNode.id)
        : loadEditedBook(event.target.parentNode.parentNode.id);
}

function createRow([id, book]) {
    const row = `<tr id="${id}">
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td><button class="editBtn">Edit</button><button class="deleteBtn">Delete</button></td>
                </tr>`;
    return row;
}

async function onCreate(event) {
    event.preventDefault();
    const formData = new FormData(event.target);
    const title = formData.get('title');
    const author = formData.get('author');

    if (title !== '' && author !== '') {
        event.target.reset();
        await request('http://localhost:3030/jsonstore/collections/books', {
            method: 'post',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ title, author }),
        });
    }
}

async function onUpdate(event) {
    event.preventDefault();
    const formData = new FormData(event.target);
    const id = formData.get('id');
    const title = formData.get('title');
    const author = formData.get('author');

    if (title !== '' && author !== '') {
        event.target.reset();
        await request(`http://localhost:3030/jsonstore/collections/books/${id}`, {
            method: 'put',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ title, author }),
        });
    }
}

async function loadEditedBook(bookId) {
    const book = await request(`http://localhost:3030/jsonstore/collections/books/${bookId}`);
    document.querySelector('#editForm [name="id"]').value = bookId;
    document.querySelector('#editForm [name="title"]').value = book.title;
    document.querySelector('#editForm [name="author"]').value = book.author;
}

async function deleteBook(id) {
    await request(`http://localhost:3030/jsonstore/collections/books/${id}`, {
        method: 'delete',
    });
}

async function request(url, options) {
    const response = await fetch(url, options);

    if (response.ok != true) {
        const error = await response.json();
        alert(error.message);
        throw new Error(error.message);
    }

    const data = await response.json();
    return data;
}

function createElement(type, content, attributes = []) {
    const element = document.createElement(type);

    if (content) {
        element.textContent = content;
    }

    if (attributes.length > 0) {
        element.setAttribute(attributes[0], attributes[1]);
    }

    return element;
}