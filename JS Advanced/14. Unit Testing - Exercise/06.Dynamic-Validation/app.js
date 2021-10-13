function validate() {
    const regex = /^[a-z]+@[a-z]+\.[a-z]+$/;
    const emailField = document.getElementById('email');

    emailField.addEventListener('change', ()=> {
        if (!regex.test(emailField.value)) {
            emailField.classList.add('error');
        } else {
            emailField.classList.remove('error');
        }
    });
}