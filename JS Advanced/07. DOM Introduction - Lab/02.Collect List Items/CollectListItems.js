function extractText() {
    let nodes = document.querySelectorAll("ul#items li");
    let textarea = document.querySelector("#result");

    for (let node of nodes) {
        textarea.value += node.textContent + "\n";
    }
}