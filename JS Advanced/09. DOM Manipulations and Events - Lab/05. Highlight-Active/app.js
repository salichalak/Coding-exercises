function focused() {
    const inputs = Array.from(document.getElementsByTagName('input'));

    function addFocus(element) {
        element.parentNode.className = 'focused';
    }

    function removeFocus(element) {
        element.parentNode.className = '';
    }

    inputs.forEach(input => {
        input.addEventListener('focus', element => addFocus(element.target));
        input.addEventListener('blur', element => removeFocus(element.target));
    })
}