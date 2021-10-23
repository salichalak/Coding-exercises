function solve() {
    const task = document.getElementById('task');
    const description = document.getElementById('description');
    const date = document.getElementById('date');
    const addBtn = document.getElementById('add');

    const openSection = document.getElementsByTagName('section')[1];
    const inProgressSection = document.getElementsByTagName('section')[2];
    const completeSection = document.getElementsByTagName('section')[3];

    addBtn.addEventListener('click', e => {
        e.preventDefault();

        if (task.value === '' || description.value === '' || date.value === '') {
            return;
        }

        const article = createElement('article');
        const h3 = createElement('h3', task.value);
        const p_Description = createElement('p', 'Description: ' + description.value);
        const p_DueDate = createElement('p', 'Due Date: ' + date.value);
        const div = createElement('div', undefined, 'flex');
        const start = createElement('button', 'Start', 'green');
        const del = createElement('button', 'Delete', 'red');

        article.appendChild(h3);
        article.appendChild(p_Description);
        article.appendChild(p_DueDate);
        div.appendChild(start);
        div.appendChild(del);
        article.appendChild(div);

        openSection.children[1].appendChild(article);

        task.value = '';
        description.value = '';
        date.value = '';

        del.addEventListener('click', () => {
            article.remove();
        });


        start.addEventListener('click', () => {
            inProgressSection.children[1].appendChild(article);
            const finishButton = createElement('button', 'Finish', 'orange');
            start.remove();
            div.appendChild(finishButton);

            finishButton.addEventListener('click', () => {
                completeSection.children[1].appendChild(article);
                div.remove();
            });
        });
    });

    function createElement(type, text, className) {
        const el = document.createElement(type);
        el.textContent = text;
        if (className) {
            el.className = className;
        }
        return el;
    }
}