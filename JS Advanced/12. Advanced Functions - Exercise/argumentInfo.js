function solve(...input) {
    const occurrences = {};
    const result = [];

    input.forEach((parameter) => {
        let type = typeof parameter;
        occurrences[type] === undefined
            ? occurrences[type] = 1
            : occurrences[type]++;

        return result.push(`${type}: ${parameter}`);
    });

    Object.keys(occurrences)
        .sort((a, b) => occurrences[b] - occurrences[a])
        .forEach(param => result.push(`${param} = ${occurrences[param]}`))

    result.forEach((param) => {
        console.log(param);
    });
}