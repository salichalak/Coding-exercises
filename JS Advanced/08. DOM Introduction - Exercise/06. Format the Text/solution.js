function solve() {
    let input = document.getElementById('input').value;
    let output = document.getElementById('output');

    let sentences = input
        .split('.')
        .filter(x => x !== '')
        .map(x => x + '.');

    let linesPerParagraph = Math.ceil(sentences.length / 3);
    for (let line = 1; line <= linesPerParagraph; line++) {
        output.innerHTML += `<p>${sentences.splice(0, 3).join('')}</p>`
    }
}