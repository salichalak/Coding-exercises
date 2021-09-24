function editElement(reference, match, replacer) {
    const matcher = new RegExp(match, 'g');
    reference.textContent = reference.textContent.replace(matcher, replacer);
}