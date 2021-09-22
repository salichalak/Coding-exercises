function solve(fruit, grams, pricePerKg) {
const kilograms = grams * 0.001;
const totalPrice = kilograms * pricePerKg;

console.log(`I need $${totalPrice.toFixed(2)} to buy ${kilograms.toFixed(2)} kilograms ${fruit}.`)
}