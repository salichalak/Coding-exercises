class List {
    constructor() {
        this.numbers = [];
        this.size = 0;
    }

    add(num) {
        this.numbers.push(Number(num));
        this.size++;
        return this.numbers.sort((a, b) => a - b);
    }

    remove(index) {
        this.validateIndex(index);
        this.numbers.splice(index, 1);
        this.size--;
        return this.numbers;
    }

    get(index) {
        this.validateIndex(index);
        return this.numbers[index];
    }

    validateIndex(index) {
        if (index < 0 || index > this.size) {
            throw new Error("Index out of bounds");
        }
    }
}