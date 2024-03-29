class ChristmasDinner {
    budget;

    constructor(newValue) {
        this._budget = newValue;
        this.dishes = [];
        this.products = [];
        this.guests = {};
    }

    set _budget(newValue) {
        if (newValue < 0) {
            throw new Error('The budget cannot be a negative number');
        }

        this.budget = newValue;
    }

    shopping([name, price]) {
        if (Number(price) > this.budget) {
            throw new Error("Not enough money to buy this product");
        }

        this.products.push(name);
        this.budget -= price;
        return `You have successfully bought ${name}!`;
    }

    recipes({recipeName, productsList}) {
        productsList.forEach((product) => {
            if (!this.products.includes(product)) {
                throw new Error('We do not have this product');
            }
        });

        this.dishes.push({recipeName, productsList});
        return `${recipeName} has been successfully cooked!`;
    }

    inviteGuests(name, dish) {
        if (this.guests[name] !== undefined) {
            throw new Error('This guest has already been invited');
        }

        if (this.dishes.find(d => d.recipeName === dish) === undefined) {
            throw new Error('We do not have this dish');
        }

        this.guests[name] = dish;
        return `You have successfully invited ${name}!`
    }

    showAttendance() {
        let result = [];

        Object.keys(this.guests).forEach(guestName => {
            let dish = this.guests[guestName];
            let products = [];

            this.dishes.forEach((d) => {
                if (d.recipeName === dish) {
                    products = d.productsList;
                }
            });
            result.push(`${guestName} will eat ${dish}, which consists of ${products.join(', ')}\n`);
        });

        return result;
    }
}