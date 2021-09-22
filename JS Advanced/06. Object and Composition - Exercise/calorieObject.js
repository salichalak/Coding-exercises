function composeObj(arr) {
    let result = {};
    for (let index = 0; index < arr.length; index += 2) {
        result[arr[index]] = Number(arr[index + 1]);

    }
    return result;
}