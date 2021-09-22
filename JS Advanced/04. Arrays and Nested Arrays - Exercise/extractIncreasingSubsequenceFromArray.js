function extract(arr) {
    let result = [arr.shift()];

    for (const element of arr) {
        element >= result[result.length - 1] ? result.push(element) : '';
    }

    return result;
}