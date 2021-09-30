function solve(input) {
    let output = [];

    let commandsList = {
        add: e => output.push(e),
        remove: e => (output = output.filter(x => x !== e)),
        print: () => console.log(output.join(",")),
    }

    input.forEach(e => {
        const [command, value] = e.split(" ")
        commandsList[command](value)
    })
}