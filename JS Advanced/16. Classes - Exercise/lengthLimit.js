class Stringer {
    constructor(string, length) {
        this.innerString = string;
        this.innerLength = Number(length);
    }

    decrease(number) {
        let decreasedLength = Math.max(0, this.innerLength - number);
        return this.innerLength = decreasedLength;
    }

    increase(number) {
        let increasedLength = this.innerLength + number;
        return this.innerLength = increasedLength;
    }

    toString() {
        if (this.innerLength >= this.innerString.length) {
            return this.innerString;
        } else {
            let result = this.innerString.substr(0, this.innerLength);
            return `${result}...`;
        }
    }
}