function createArticle({ _id, title }) {
    const div = document.createElement('div');
    div.setAttribute('class', 'accordion');

    const headDiv = document.createElement('div');
    headDiv.setAttribute('class', 'head')

    const titleSpan = document.createElement('span');
    titleSpan.textContent = title;

    const btn = document.createElement('button');
    btn.setAttribute('class', 'button');
    btn.textContent = 'More';

    const extra = document.createElement('div');
    extra.setAttribute('class', 'extra');
    extra.style.display = 'none';

    const contentParagraph = document.createElement('p');

    btn.id = _id;
    headDiv.append(titleSpan, btn);
    extra.appendChild(contentParagraph);
    div.append(headDiv, extra);

    btn.addEventListener('click', async () => {
        if (extra.style.display !== 'none') {
            btn.textContent = 'More';
            extra.style.display = 'none';
        } else {
            try {
                const res = await fetch(`http://localhost:3030/jsonstore/advanced/articles/details/${_id}`);

                if (res.ok != true) {
                    throw new Error(res.statusText);
                }

                const data = await res.json();
                btn.textContent = 'Less';
                extra.style.display = 'block';
                contentParagraph.textContent = data.content;
            } catch (err) {
                console.log(err);
            }
        }
    });

    return div;
}

async function solution() {
    try {
        const res = await fetch('http://localhost:3030/jsonstore/advanced/articles/list');

        if (res.ok != true) {
            throw new Error(res.statusText);
        }

        const data = await res.json();
        const main = document.getElementById('main');
        data.forEach(x => main.appendChild(createArticle(x)));
    } catch (err) {
        console.log(err);
    }
}

document.addEventListener('DOMContentLoaded', solution);