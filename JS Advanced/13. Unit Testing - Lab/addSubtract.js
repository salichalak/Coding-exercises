const createCalculator = require('./07. Add _ Subtract-tests').createCalculator;
let expect = require('chai').expect;

describe("Initialize", () => {
    let calculator;

    beforeEach(() => {
        calculator = createCalculator();
    });

    it("Return object", function () {
        expect(typeof calculator).to.equal('object');
    });
});