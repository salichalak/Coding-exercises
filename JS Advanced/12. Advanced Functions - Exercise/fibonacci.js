function getFibonator() {
    let current = 0;
    let next = 1;
    let result = 0;

    return function fib() {
        result = current + next
        current = next;
        next = result
        return current;
    }
}