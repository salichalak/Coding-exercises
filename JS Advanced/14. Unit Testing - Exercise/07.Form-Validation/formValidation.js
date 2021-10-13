function validate() {
    const submitButton = document.getElementById('submit');
    const isCompanyCheckbox = document.getElementById('company');
    submitButton.addEventListener('click', validateFormHandler);
    isCompanyCheckbox.addEventListener('change', onIsCompanyHandler);

    function validateFormHandler(e) {
        e.preventDefault();
        let usernameInput = document.getElementById('username');
        let usernameRegex = /^[a-zA-Z0-9]{3,20}$/;
        let usernameIsValid = usernameRegex.test(usernameInput.value);
        setBorder(usernameInput, usernameIsValid);

        let emailInput = document.getElementById('email');
        let emailRegex = /^.*@.*\..*$/
        let emailIsValid = emailRegex.test(emailInput.value);
        setBorder(emailInput, emailIsValid);

        let passwordRegex = /^\w{5,15}$/;
        let passwordInput = document.getElementById('password');
        let confirmPasswordInput = document.getElementById('confirm-password');
        let passwordIsValid = passwordRegex.test(passwordInput.value);
        let passwordsAreEqual = passwordIsValid && passwordInput.value === confirmPasswordInput.value;
        setBorder(passwordInput, passwordsAreEqual);
        setBorder(confirmPasswordInput, passwordsAreEqual);

        let companyNumberIsValid = false;
        let isCompanyCheckbox = document.getElementById('company');
        if (isCompanyCheckbox.checked) {
            let companyNumberInput = document.getElementById('companyNumber');
            if (companyNumberInput.value.trim() !== '' && !isNaN(Number(companyNumberInput.value))) {
                let companyNumber = Number(companyNumberInput.value);
                if (companyNumber >= 1000 && companyNumber <= 9999) {
                    companyNumberIsValid = true;
                }
            }

            setBorder(companyNumberInput, companyNumberIsValid);
        }

        let validDiv = document.getElementById('valid');
        let mainInputsAreValid = usernameIsValid && emailIsValid && passwordsAreEqual
        let companyInfoIsValid = !isCompanyCheckbox.checked || (isCompanyCheckbox.checked && companyNumberIsValid);
        let shouldShowValidDiv = mainInputsAreValid && companyInfoIsValid;
        validDiv.style.display = shouldShowValidDiv ? 'block' : 'none';
    }

    function onIsCompanyHandler(e) {
        document.getElementById('companyInfo').style.display = e.target.checked
            ? 'block'
            : 'none';
    }

    function setBorder(element, isValid) {
        isValid
            ? element.style.setProperty('border', 'none')
            : element.style.setProperty('border', '2px solid red');
    }
}