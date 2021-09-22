function solve(pies, startFlavor, endFlavor) {
    const start = pies.indexOf(startFlavor);
    const end = pies.indexOf(endFlavor);
    const result = pies.slice(start, end + 1);
    return result;
}