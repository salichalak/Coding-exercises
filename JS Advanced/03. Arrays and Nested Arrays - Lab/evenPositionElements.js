function getEvenNumbers(input) {
    let result = input.filter((value, index) => index % 2 === 0)
    console.log(result.join(" "))
}