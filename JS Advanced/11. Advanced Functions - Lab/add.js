function solve(n) {
    let number = n;

    return function add(n) {
        return number + n;
    }
}