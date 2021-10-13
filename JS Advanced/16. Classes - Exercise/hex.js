class Hex {
    constructor(num) {
        this.value = Number(num);
    }

    valueOf() {
        return this.value;
    }

    toString() {
        let result = this.value.toString(16).toUpperCase();
        return `0x${result}`;
    }

    plus(num) {
        let result = this.value + Number(num.valueOf());
        let hex = new Hex(result);
        return hex;
    }

    minus(num) {
        let result = this.value - Number(num.valueOf());
        let hex = new Hex(result);
        return hex;
    }

    parse(input) {
        return parseInt(input, 16);
    }
}