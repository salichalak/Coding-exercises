function solve(matrix) {
    const sum = matrix[0].reduce((a, x) => a + x);

    for (let row = 0; row < matrix.length; row++) {
        const sumRows = matrix[row].reduce((a, x) => a + x);
        const sumCols = matrix.map((el) => el[row]).reduce((a, x) => a + x);

        if (sumRows !== sum || sumCols !== sum || sumRows !== sumCols) {
            return false;
        }
    }

    return true;
}