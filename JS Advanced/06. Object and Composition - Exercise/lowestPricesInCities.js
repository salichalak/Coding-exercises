function lowPrice(arr) {
    let products = {};
    for (let index = 0; index < arr.length; index++) {
        let [townName, productName, productPrice] = arr[index].split(' | ');
        productPrice = Number(productPrice);

        if (!products.hasOwnProperty(productName)) {
            products[productName] = {};
        }

        products[productName][townName] = productPrice;

    }

    let output = [];
    for (const product in products) {
        let towns = Object.entries(products[product]).sort((a, b) => a[1] - b[1]);
        let cheapest = towns[0]
        output.push(`${product} -> ${cheapest[1]} (${cheapest[0]})`)
    }
    return output.join('\n')
}   