const numberOperations = require("./03. Number Operations_Resources");
const {expect} = require("chai");

describe("Number Operations Test suite", function () {
    describe("powNumber tests", function () {
        it('Calculate correctly with integer and floating point number', function () {
            expect(numberOperations.powNumber(5)).to.be.equal(25);
            expect(numberOperations.powNumber(5.5)).to.be.equal(30.25);
        });
    });

    describe("numberChecker tests", function () {
        it('Parse invalid input ', function () {
            expect(() => numberOperations.numberChecker("X")).to.throw('The input is not a number!');
        });

        it('Works with numbers > 100', function () {
            expect(numberOperations.numberChecker(100)).to.be.equal('The number is greater or equal to 100!');
            expect(numberOperations.numberChecker(101)).to.be.equal('The number is greater or equal to 100!');
        });

        it('Works with numbers < 100', function () {
            expect(numberOperations.numberChecker(99)).to.be.equal('The number is lower than 100!');
            expect(numberOperations.numberChecker(0)).to.be.equal('The number is lower than 100!');
            expect(numberOperations.numberChecker(-1)).to.be.equal('The number is lower than 100!');
        });
    });

    describe("sumArrays tests", function () {
        it('Work with longer first array', function () {
            expect(numberOperations.sumArrays([1, 1, 1, 1], [2, 2, 2])).to.have.all.members([3, 3, 3, 1]);
        });

        it('Work with longer second array', function () {
            expect(numberOperations.sumArrays([1, 1, 1], [2, 2, 2, 2])).to.have.all.members([3, 3, 3, 2]);
        });
    })
});