function lockedProfile() {
    (async () => {
        const res = await fetch('http://localhost:3030/jsonstore/advanced/profiles');
        const data = await res.json();
        let mainSection = document.getElementById('main');
        let template = document.querySelector('.profile');
        template.remove();

        Object.keys(data).forEach((p, i) => {
            let profile = data[p];
            let htmlProfile = createProfile(i + 1, profile.username, profile.email, profile.age);
            mainSection.appendChild(htmlProfile);
        });
    })();

    function createProfile(index, username, email, age) {
        let profileDiv = document.createElement('div');
        profileDiv.classList.add('profile');

        let profileImg = document.createElement('img');
        profileImg.src = './iconProfile2.png';
        profileImg.classList.add('userIcon');

        let lockLabel = document.createElement('label');
        lockLabel.textContent = 'Lock';

        let lockRadio = document.createElement('input');
        lockRadio.type = 'radio';
        lockRadio.name = `user${index}Locked`;
        lockRadio.value = 'lock';
        lockRadio.checked = true;

        let unlockLabel = document.createElement('label');
        unlockLabel.textContent = 'Unlock';

        let unlockRadio = document.createElement('input');
        unlockRadio.type = 'radio';
        unlockRadio.name = `user${index}Unlocked`;
        unlockRadio.value = 'unlock';
        unlockRadio.checked = false;

        let br = document.createElement('br');
        let hr = document.createElement('hr');

        let usernameLabel = document.createElement('label');
        usernameLabel.textContent = 'Username:';

        let usernameInput = document.createElement('input');
        usernameInput.name = `user${index}Username`;
        usernameInput.value = username;
        usernameInput.readOnly = true;
        usernameInput.disabled = true;

        let hiddenFieldsDiv = document.createElement('div');
        hiddenFieldsDiv.id = `user${index}HiddenFields`;

        let hiddenFieldsHr = document.createElement('hr');

        let emailLabel = document.createElement('label');
        emailLabel.textContent = 'Email:';

        let emailInput = document.createElement('input');
        emailInput.type = 'email';
        emailInput.name = `user${index}Email`;
        emailInput.value = email;
        emailInput.readOnly = true;
        emailInput.disabled = true;

        let ageLabel = document.createElement('label');
        ageLabel.textContent = 'Age:';

        let ageInput = document.createElement('input');
        ageInput.type = 'email';
        ageInput.name = `user${index}Age`;
        ageInput.value = age;
        ageInput.readOnly = true;
        ageInput.disabled = true;

        hiddenFieldsDiv.appendChild(hiddenFieldsHr);
        hiddenFieldsDiv.appendChild(emailLabel);
        hiddenFieldsDiv.appendChild(emailInput);
        hiddenFieldsDiv.appendChild(ageLabel);
        hiddenFieldsDiv.appendChild(ageInput);

        let showMoreBtn = document.createElement('button');
        showMoreBtn.textContent = 'Show More';
        showMoreBtn.addEventListener('click', revealHiddenInfo);

        profileDiv.appendChild(profileImg);
        profileDiv.appendChild(lockLabel);
        profileDiv.appendChild(lockRadio);
        profileDiv.appendChild(unlockLabel);
        profileDiv.appendChild(unlockRadio);
        profileDiv.appendChild(br);
        profileDiv.appendChild(hr);
        profileDiv.appendChild(usernameLabel);
        profileDiv.appendChild(usernameInput);
        profileDiv.appendChild(hiddenFieldsDiv);
        profileDiv.appendChild(showMoreBtn);

        return profileDiv;
    }

    function revealHiddenInfo(e) {
        let showMoreBtn = e.target;
        let hiddenFieldsDiv = e.target.previousElementSibling;
        let radioBtn = document.querySelector('input[type="radio"]:checked');

        if (radioBtn.value !== 'unlock') {
            return;
        }

        showMoreBtn.textContent = showMoreBtn.textContent === 'Show More' ? 'Hide' : 'Show More';
        hiddenFieldsDiv.style.display = hiddenFieldsDiv.style.display === 'block' ? 'none' : 'block';
    }
}