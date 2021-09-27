function addItem() {
    const input = document.getElementById('newItemText');
    const item = document.createElement('li');
    item.textContent = input.value;

    const deleteButton = document.createElement('a');
    deleteButton.href = '#';
    deleteButton.textContent = '[Delete]';
    deleteButton.addEventListener('click', removeElement);

    item.appendChild(deleteButton);
    document.getElementById('items').appendChild(item);
    input.value = '';

    function removeElement(ev) {
        const parent = ev.target.parentNode;
        parent.remove();
    }
}