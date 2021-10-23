const testNumbers = require("./testNumbers");
const {expect} = require("chai");

describe("Test suite", function () {
    describe("sumNumbers method", function () {
        it('Sum of invalid numbers', function () {
            expect(testNumbers.sumNumbers("x", "y")).to.be.equal(undefined);
            expect(testNumbers.sumNumbers(null, null)).to.be.equal(undefined);
            expect(testNumbers.sumNumbers(undefined, undefined)).to.be.equal(undefined);
            expect(testNumbers.sumNumbers(undefined, null)).to.be.equal(undefined);
            expect(testNumbers.sumNumbers("", "")).to.be.equal(undefined);
        });

        it('Sum of valid numbers', function () {
            expect(testNumbers.sumNumbers(15, 15)).to.be.equal("30.00");
        });

        it('Sum of floating point numbers', function () {
            expect(testNumbers.sumNumbers(7, 7.5)).to.be.equal("14.50");
        });

        it('Sum of positive and negative numbers', function () {
            expect(testNumbers.sumNumbers(-5, 15)).to.be.equal("10.00");
            expect(testNumbers.sumNumbers(-6, -6)).to.be.equal("-12.00");
        });

        it('Round to the second number after the decimal point', function () {
            expect(testNumbers.sumNumbers(4.666, 4.222)).to.be.equal("8.89");
        });
    });

    describe("numberChecker method", function () {
        it('Parse invalid input ', function () {
            expect(() => testNumbers.numberChecker("X")).to.throw('The input is not a number!');
        });

        it('Works with even numbers', function () {
            expect(testNumbers.numberChecker(4)).to.be.equal('The number is even!');
            expect(testNumbers.numberChecker("4")).to.be.equal('The number is even!');
        });

        it('Works with odd numbers', function () {
            expect(testNumbers.numberChecker(5)).to.be.equal('The number is odd!');
            expect(testNumbers.numberChecker("5")).to.be.equal('The number is odd!');
        });
    });

    describe("averageSumArray method", function () {
        it('Find average correctly of integers', function () {
            expect(testNumbers.averageSumArray([1, 2, 3])).to.be.equal(2);
        });

        it('Find average correctly of floating point numbers', function () {
            expect(testNumbers.averageSumArray([1.5, 2.5, 3.5])).to.be.equal(2.5);
        });
    })
});