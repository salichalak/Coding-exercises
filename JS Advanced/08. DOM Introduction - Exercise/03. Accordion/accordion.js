function toggle() {
    let button = document.getElementsByClassName('button')[0];
    let extraText = document.getElementById('extra');
    button.textContent = button.textContent === 'More' ? 'Less' : 'More';
    extraText.style.display = extraText.style.display === 'block' ? 'none' : 'block';
}