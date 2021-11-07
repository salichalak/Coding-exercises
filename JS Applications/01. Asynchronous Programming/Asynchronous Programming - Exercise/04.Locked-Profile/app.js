async function lockedProfile() {
    function createProfile({ username, email, age }, id) {
        const div = document.createElement('div');
        div.setAttribute('class', 'profile');

        div.innerHTML = `<img src="./iconProfile2.png" class="userIcon">
    <label>Lock</label>
    <input type="radio" name="user${id}Locked" value="lock" checked="">
    <label>Unlock</label>
    <input type="radio" name="user${id}Locked" value="unlock"><br>
    <hr>
    <label>Username</label>
    <input type="text" name="user${id}Username" value=${username} disabled="" readonly="">
    <div id="user${id}HiddenFields">
    <hr>
    <label>Email:</label>
    <input type="email" name="user${id}Email" value=${email} disabled="" readonly="">
    <label>Age:</label>
    <input type="email" name="user${id}Age" value=${age} disabled="" readonly="">
    </div>`;

        const button = document.createElement('button');
        button.textContent = 'Show more';
        button.addEventListener('click', () => {
            const isChecked = div.querySelector('input[type=radio]:checked');
            if (isChecked.value === 'unlock' && button.textContent === 'Show more') {
                div.querySelector(`#user${id}HiddenFields`).style.display = 'block';
                button.textContent = 'Hide';
            } else {
                div.querySelector(`#user${id}HiddenFields`).style.display = 'none';
                button.textContent = 'Show more';
            }
        });

        div.appendChild(button);
        return div;
    }

    try {
        const res = await fetch('http://localhost:3030/jsonstore/advanced/profiles');

        if (res.ok != true) {
            throw new Error(res.statusText);
        }

        const data = await res.json();
        const mainSection = document.querySelector('main');
        mainSection.innerHTML = '';
        Object.values(data)
            .forEach((value, index) =>
                mainSection.appendChild(createProfile(value, index + 1)));
    } catch (err) {
        console.log(error);
    }
}