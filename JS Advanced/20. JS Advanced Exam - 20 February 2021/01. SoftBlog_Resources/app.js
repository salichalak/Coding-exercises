function solve() {
    const author = document.getElementById('creator');
    const title = document.getElementById('title');
    const category = document.getElementById('category');
    const content = document.getElementById('content');
    const articlesSection = document.querySelector('.site-content main section');
    const archivedSection = document.querySelector('.archive-section ol');
    const createButton = document.querySelector('form button');

    createButton.addEventListener('click', function (e) {
        e.preventDefault();

        let article = document.createElement('article');

        let articleHeader = document.createElement('h1');
        articleHeader.textContent = `${title.value}`;
        article.appendChild(articleHeader);
        let articleCategory = document.createElement('p');
        articleCategory.innerHTML = `Category: <strong>${category.value}</strong>`;
        article.appendChild(articleCategory);
        let articleAuthor = document.createElement('p');
        articleAuthor.innerHTML = `Creator: <strong>${author.value}</strong>`;
        article.appendChild(articleAuthor);
        let articleContent = document.createElement('p');
        articleContent.textContent = `${content.value}`;
        article.appendChild(articleContent);
        let div = document.createElement('div');
        div.classList.add('buttons');
        div.innerHTML = `<button class="btn delete">Delete</button><button class="btn archive">Archive</button>`;
        article.appendChild(div);

        article.appendChild(div);
        articlesSection.appendChild(article);

        author.value = '';
        title.value = '';
        category.value = '';
        content.value = '';

        div.querySelectorAll("button")[0].addEventListener('click', () => {
            articlesSection.removeChild(article);
        });

        div.querySelectorAll("button")[1].addEventListener('click', () => {
            let li = document.createElement('li');
            li.textContent = articleHeader.textContent
            archivedSection.appendChild(li);
            let archivedItems = Array.from(document.querySelectorAll('.archive-section ol li'));
            let sortedItems = archivedItems.sort((a, b) => a.textContent.localeCompare(b.textContent));
            archivedSection.innerHTML = ``;
            for (let el of sortedItems) {
                archivedSection.innerHTML += `<li>${el.textContent}</li>`
            }
            articlesSection.removeChild(article);
        })
    });
}