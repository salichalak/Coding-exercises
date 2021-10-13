function notify(message) {
    const div = document.querySelector("#notification");
    div.textContent = message;
    div.style.display = 'block';
    div.addEventListener('click', function hide() {
        div.style.display = 'none';
    })
}