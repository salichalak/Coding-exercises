window.addEventListener('load', solution);

function solution() {
    const fullNameField = document.querySelector('#fname');
    const emailField = document.querySelector('#email');
    const phoneNumberField = document.querySelector('#phone');
    const addressField = document.querySelector('#address');
    const postalCodeField = document.querySelector('#code');
    const submitButton = document.querySelector('#submitBTN');
    const editButton = document.querySelector('#editBTN');
    const continueButton = document.querySelector('#continueBTN');
    const preview = document.querySelector('#infoPreview');

    let fullNameLi;
    let emailLi;
    let phoneNumberLi;
    let addressLi;
    let postalCodeLi;

    submitButton.addEventListener("click", (e) => {
        e.preventDefault();
        let isValid = fullNameField.value && emailField.value;

        if (isValid) {
            fullNameLi = document.createElement('li');
            emailLi = document.createElement('li');
            phoneNumberLi = document.createElement('li');
            addressLi = document.createElement('li');
            postalCodeLi = document.createElement('li');

            fullNameLi.textContent = `Full Name: ${fullNameField.value}`;
            preview.appendChild(fullNameLi);
            emailLi.textContent = `Email: ${emailField.value}`;
            preview.appendChild(emailLi);
            phoneNumberLi.textContent = `Phone Number: ${phoneNumberField.value}`;
            preview.appendChild(phoneNumberLi);
            addressLi.textContent = `Address: ${addressField.value}`;
            preview.appendChild(addressLi);
            postalCodeLi.textContent = `Postal Code: ${postalCodeField.value}`;
            preview.appendChild(postalCodeLi);

            fullNameField.value = '';
            emailField.value = '';
            phoneNumberField.value = '';
            addressField.value = '';
            postalCodeField.value = '';

            submitButton.disabled = true;
            editButton.disabled = false;
            continueButton.disabled = false;
        }
    });


    editButton.addEventListener('click', (ev) => {
        ev.preventDefault();

        fullNameField.value = fullNameLi.textContent.split(': ')[1].trim();
        emailField.value = emailLi.textContent.split(': ')[1].trim();
        phoneNumberField.value = phoneNumberLi.textContent.split(': ')[1].trim();
        addressField.value = addressLi.textContent.split(': ')[1].trim();
        postalCodeField.value = postalCodeLi.textContent.split(': ')[1].trim();

        preview.removeChild(fullNameLi);
        preview.removeChild(emailLi);
        preview.removeChild(phoneNumberLi);
        preview.removeChild(addressLi);
        preview.removeChild(postalCodeLi);

        submitButton.disabled = false;
        editButton.disabled = true;
        continueButton.disabled = true;
    });

    continueButton.addEventListener('click', () => {
        const body = document.querySelector('#block');
        body.innerHTML = '';
        const h3 = document.createElement('h3');
        h3.textContent = 'Thank you for your reservation!';
        body.appendChild(h3);
    });
}