function solve(input) {
    let num = 1;
    let output = [];

    for (const command of input) {
        command === 'add'
            ? output.push(num)
            : output.pop();
        num++;
    }

    output.length > 0
        ? console.log(output.join('\n'))
        : console.log('Empty')
}