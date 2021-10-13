function solve(array, startIndex, endIndex) {
    if (startIndex < 0) {
        startIndex = 0;
    }

    if (endIndex > array.length - 1) {
        endIndex = array.length - 1;
    }

    try {
        return (array.slice(startIndex, endIndex + 1).reduce((acc, curr) => acc + curr, 0) * 10) / 10;
    } catch (ex) {
        return NaN;
    }
}