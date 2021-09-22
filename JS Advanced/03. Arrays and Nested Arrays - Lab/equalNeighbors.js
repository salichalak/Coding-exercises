function foo(arr) {
    let count = 0
    arr.forEach(x =>
        x.reduce((a, v) => {
            if (a === v) {
                count++;
            }
            return v;
        })
    )

    for (let i = 0; i < arr.length - 1; i++) {
        arr[i].forEach((_, j) => {
            if (arr[i][j] === arr[i + 1][j]) {
                count++;
            }
        })
    }
    return count;
}