function solve(arr) {
    const output = arr.sort().reduce((acc, curr) => {
        acc[curr[0]] = acc[curr[0]] || []
        acc[curr[0]].push(curr)
        return acc
    }, {})

    Object.entries(output).forEach(([symbol, items]) =>
        console.log(`${symbol}
  ${items.map(y => y.split(" : ").join(": ")).join("\n  ")}`)
    )
}