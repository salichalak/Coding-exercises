function solve() {
    let output = "";

    return {
        append: x => (output += x),
        removeStart: x => (output = output.slice(x)),
        removeEnd: x => (output = output.slice(0, -x)),
        print: () => console.log(output),
    }
}