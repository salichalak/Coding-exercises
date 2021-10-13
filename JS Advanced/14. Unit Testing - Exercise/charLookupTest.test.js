const expect = require('chai').expect;
const {lookupChar} = require("./charLookUp");


describe('lookupChar', function () {
    it('with a non-string first parameter, should return undefined', () => {
        expect(lookupChar(13, 0)).to.equal(undefined);
    })

    it('with a non-string second parameter, should return undefined', () =>  {
        expect(lookupChar('test', 'test')).to.equal(undefined);
    })

    it('with a floating point number second parameter, should return undefined', () =>  {
        expect(lookupChar('test', 4.53)).to.equal(undefined);
    })

    it('with an incorrect index value, should return undefined', function () {
        expect(lookupChar('test', 9)).to.equal("Incorrect index");
    })

    it('with an index value equal to string length, should return incorrect index', function () {
        expect(lookupChar('test', 4)).to.equal("Incorrect index");
    })

    it('with correct parameters, should return correct values', function () {
        expect(lookupChar('pesho', 0)).to.equal('p');
    })

    it('with correct parameters, should return correct values', function () {
        expect(lookupChar('stamat', 3)).to.equal('m');
    })
});