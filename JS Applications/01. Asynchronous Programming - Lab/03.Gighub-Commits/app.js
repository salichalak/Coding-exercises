async function loadCommits() {
    const nameField = document.getElementById('username');
    const repoField = document.getElementById('repo');
    const resultE = document.getElementById('commits');
    resultE.innerHTML = '';
    const createEl = (tag, content = '') => {
        const el = document.createElement(tag);
        el.innerHTML = content;
        return el;
    }

    try {
        const res = await fetch(`https://api.github.com/repos/${nameField.value}/${repoField.value}/commits`);
        if (!res.ok) {
            throw new Error(`${res.status} (${res.statusText})`);
        }
        const data = await res.json();
        data.forEach(({ commit }) => resultE.appendChild(createEl(
            'li',
            `${commit.author.name}: ${commit.message}`
        )));
    } catch (err) {
        resultE.appendChild(createEl('li', err));
    }
}