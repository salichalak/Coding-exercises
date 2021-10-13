function add(x) {
    let total = function (y) {
        return add(x + y);
    }

    total.valueOf = function () {
        return x;
    }
    return total;
}