function solve(input) {
    const data = {};

    input.forEach(x => {
        let [brand, model, quantity] = x.split(' | ')
        data[brand] = data[brand] || {}
        data[brand][model] = data[brand][model] || 0
        data[brand][model] += Number(quantity)
    });
    return Object.entries(data).map(([brand, models]) => `${brand}
${Object.entries(models)
        .map(([model, quantity]) => `###${model} -> ${quantity}`)
        .join('\n')}`).join('\n')
}