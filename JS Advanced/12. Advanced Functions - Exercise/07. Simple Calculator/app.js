function calculator() {
    let selector1 = '';
    let selector2 = '';
    let resultSelector = '';

    function calc(s1, s2, command) {
        const commandsList = {
            '+': (a, b) => a + b,
            '-': (a, b) => a - b
        }
        return commandsList[command](Number(s1), Number(s2));
    }

    return {
        init: (s1, s2, command) => {
            selector1 = document.querySelector(s1)
            selector2 = document.querySelector(s2)
            resultSelector = document.querySelector(command)
        },
        add: () => resultSelector.value = calc(selector1.value, selector2.value, '+'),
        subtract: () => resultSelector.value = calc(selector1.value, selector2.value, '-'),
    }
}