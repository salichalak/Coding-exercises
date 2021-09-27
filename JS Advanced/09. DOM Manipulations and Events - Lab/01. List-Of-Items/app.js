function addItem() {
    let input = document.getElementById('newItemText');
    let itemsList = document.getElementById('items');
    let newItem = document.createElement('li');

    newItem.textContent = input.value;
    itemsList.appendChild(newItem);
    document.getElementById('newItemText').value = '';
}