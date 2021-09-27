function validate() {
    const email = document.getElementById("email");
    const regex = /^[a-z]+@[a-z]+\.[a-z]+/g;

    function validateEmail(email) {
        return regex.test(email);
    }

    function applyStyle(element, email) {
        element.className = validateEmail(email)
            ? ''
            : "error"
    }

    email.addEventListener("change", element => applyStyle(element.target, element.target.value));
}