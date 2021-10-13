function solve(data) {
    const bottles = new Map();

    data.reduce((acc, curr) => {
        let [juice, quantity] = curr.split(" => ");
        quantity = Number(quantity);
        if (!acc.hasOwnProperty(juice)) {
            acc[juice] = 0;
        }
        acc[juice] += quantity;
        if (acc[juice] >= 1000) {
            if (!bottles.has(juice)) {
                bottles.set(juice, 0);
            }
            bottles.set(juice, bottles.get(juice) + Number(acc[juice] / 1000));
            acc[juice] %= 1000;
        }

        return acc;
    }, {});


    for (let [key, value] of bottles) {
        console.log(`${key} => ${value}`);
    }
}