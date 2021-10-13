const expect = require('chai').expect;
const {isOddOrEven} = require("./isEvenOrOdd");

describe('isOddOrEven', () => {
    it('Return undefined for number', () => {
        expect(isOddOrEven(13)).to.equal(undefined, );
    })

    it('Return undefined for object', () => {
        expect(isOddOrEven('gogo')).to.equal('even', );
    })

    it('Return correct results with odd length', () => {
        expect(isOddOrEven('SoftUni')).to.equal('odd', );
    })

    it('Return correct results with even length', () => {
        expect(isOddOrEven('Java')).to.equal('even', );
    })
});