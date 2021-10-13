function solve(array, criteria) {
    class Ticket {
        constructor(destination, price, status) {
            this.destination = destination;
            this.price = Number(price);
            this.status = status;
        }
    }

    let output = [];

    for (let line of array) {
        let [destination, price, status] = line.split('|');
        output.push(new Ticket(destination, price, status));
    }

    output.sort((a, b) =>
        criteria === 'price' ? a[criteria] - b[criteria] : a[criteria].localeCompare(b[criteria]))

    return output;
}