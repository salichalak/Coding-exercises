function solve(data, argument) {
    return argument === "asc"
        ? data.sort((a, b) => a - b)
        : data.sort((a, b) => b - a);
}