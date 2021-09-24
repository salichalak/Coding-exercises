function extract(content) {
    const element = document.getElementById(content);

    return element.innerHTML
        .match(/(?!\()[\w*\s*\d*]*(?=\))/g)
        .filter(x => x !== '')
        .join('; ');
}