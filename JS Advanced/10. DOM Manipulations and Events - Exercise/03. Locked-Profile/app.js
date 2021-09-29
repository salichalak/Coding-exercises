function lockedProfile() {
    const buttons = Array.from(document.querySelectorAll('.profile button'));

    buttons.forEach(button => button.addEventListener('click', function (ev) {
        const profile = ev.target.parentElement;
        const isUnlocked = profile.querySelector('input[type="radio"][value="unlock"]').checked;

        if (isUnlocked) {
            const div = profile.querySelector('div');
            if (ev.target.textContent === 'Show more') {
                div.style.display = 'block';
                ev.target.textContent = 'Hide it';
            } else {
                div.style.display = '';
                ev.target.textContent = 'Show more';
            }
        }
    }));
}