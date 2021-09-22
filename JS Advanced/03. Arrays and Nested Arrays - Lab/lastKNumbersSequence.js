function foo(n, k) {
    const arr = [1]

    for (let i = 1; i < n; i++) {
        let result = arr.slice(-k).reduce((acc, curr) => acc + curr, 0);
        arr.push(result);
    }

    return arr
}