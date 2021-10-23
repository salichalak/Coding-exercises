window.addEventListener('load', solve);

function solve() {
    const genreField = document.getElementById('genre');
    const nameField = document.getElementById('name');
    const authorField = document.getElementById('author');
    const dateField = document.getElementById('date');
    const addBtn = document.getElementById('add-btn');

    let collectionsOfSongDIV = document.querySelector('.all-hits-container');

    addBtn.addEventListener('click', function (e) {
        e.preventDefault();

        if (genreField.value === '' || nameField.value === '' || authorField.value === '' || dateField.value === '') {
            return;
        }

        let newDiv = document.createElement('div');
        newDiv.setAttribute('class', 'hits-info');
        let img = document.createElement('img');
        img.setAttribute('src', "./static/img/img.png");
        newDiv.appendChild(img);
        let h2Genre = document.createElement('h2');
        h2Genre.innerText = `Genre: ${genreField.value}`;
        newDiv.appendChild(h2Genre);
        let h2Name = document.createElement('h2');
        h2Name.innerText = `Name: ${nameField.value}`;
        newDiv.appendChild(h2Name);
        let h2Author = document.createElement('h2');
        h2Author.innerText = `Author: ${authorField.value}`;
        newDiv.appendChild(h2Author);
        let h3date = document.createElement('h3');
        h3date.innerText = `Date: ${dateField.value}`;
        newDiv.appendChild(h3date);

        let save = document.createElement('button');
        save.setAttribute('class', "save-btn");
        save.innerText = 'Save song';
        newDiv.appendChild(save);

        let like = document.createElement('button');
        like.setAttribute('class', "like-btn");
        like.innerText = 'Like song';
        newDiv.appendChild(like);

        let del = document.createElement('button');
        del.setAttribute('class', "delete-btn");
        del.innerText = 'Delete';
        newDiv.appendChild(del);

        collectionsOfSongDIV.appendChild(newDiv);

        genreField.value = '';
        nameField.value = '';
        authorField.value = '';
        dateField.value = '';

        like.addEventListener('click', function (e) {
            like.disabled = true;
            let totalLikes = document.getElementById('total-likes').querySelector('p');
            let currentLikesCounts = Number(totalLikes.textContent.split(': ')[1]);
            currentLikesCounts++;
            totalLikes.textContent = `Total Likes: ${currentLikesCounts}`;
        });

        save.addEventListener('click', function (e) {
            let savedSongsDiv = document.querySelector('div.saved-container');
            save.remove();
            like.remove();
            savedSongsDiv.appendChild(newDiv);
        });

        del.addEventListener('click', function (e) {
            del.parentElement.parentElement.removeChild(newDiv);
        });
    });
}