function diagonalSums(input) {
    let firstDiagonal = 0;
    let secondDiagonal = 0;
    let firstIndex = 0;
    let secondIndex = input[0].length - 1;

    input.forEach(row => {
        firstDiagonal += row[firstIndex++];
        secondDiagonal += row[secondIndex--];
    });

    console.log(firstDiagonal + ' ' + secondDiagonal);
}