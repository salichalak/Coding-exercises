class Restaurant {
    constructor(budget) {
        this.budgetMoney = Number(budget);
        this.menu = {};
        this.stockProducts = {};
        this.history = [];
    }

    loadProducts(products) {
        products.forEach((product) => {
            let [productName, productQuantity, productTotalPrice] = product.split(' ');
            productQuantity = Number(productQuantity);
            productTotalPrice = Number(productTotalPrice);

            if (this.budgetMoney >= productTotalPrice) {
                if (!this.stockProducts[productName]) {
                    this.stockProducts[productName] = productQuantity;
                } else {
                    this.stockProducts[productName] += productQuantity;
                }
                this.budgetMoney -= productTotalPrice;
                this.history.push(`Successfully loaded ${productQuantity} ${productName}`);
            } else {
                this.history.push(`There was not enough money to load ${productQuantity} ${productName}`);
            }
        });

        return this.history.join("\n");
    }

    addToMenu(meal, products, price) {
        if (!this.menu[meal]) {
            this.menu[meal] = {
                products: {},
                price: price
            }

            products.forEach((product) => {
                let [productName, productQuantity] = product.split(' ');
                this.menu[meal].products[productName] = Number(productQuantity);
            });

            const mealsCount = Object.keys(this.menu).length;
            return mealsCount === 1
                ? `Great idea! Now with the ${meal} we have 1 meal in the menu, other ideas?`
                : `Great idea! Now with the ${meal} we have ${mealsCount} meals in the menu, other ideas?`;
        }

        return `The ${meal} is already in the our menu, try something different.`;
    }

    showTheMenu() {
        const mealsCount = Object.keys(this.menu).length;
        if (mealsCount === 0) {
            return "Our menu is not ready yet, please come later...";
        }

        let output = [];
        for (let meal in this.menu) {
            output.push(`${meal} - $ ${this.menu[meal].price}`);
        }

        return output.join('\n');
    }

    makeTheOrder(meal) {
        if (!this.menu[meal]) {
            return `There is not ${meal} yet in our menu, do you want to order something else?`;
        }

        const neededProducts = {};
        for (let product in this.menu[meal].products) {
            if (!this.stockProducts[product] || this.stockProducts[product] < this.menu[meal].products[product]) {
                return `For the time being, we cannot complete your order (${meal}), we are very sorry...`;
            } else {
                neededProducts[product] = this.menu[meal].products[product];
            }
        }

        for (let product in neededProducts) {
            this.stockProducts[product] -= neededProducts[product];
        }

        this.budgetMoney += this.menu[meal].price;
        return `Your order (${meal}) will be completed in the next 30 minutes and will cost you ${this.menu[meal].price}.`
    }
}