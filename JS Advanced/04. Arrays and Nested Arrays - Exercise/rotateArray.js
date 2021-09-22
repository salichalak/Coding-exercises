function solve(arr, rotations) {
    rotations = Number(rotations);

    for (let rotation = 1; rotation <= rotations % arr.length; rotation++) {
        arr.unshift(arr.pop());
    }

    return arr.join(' ');
}