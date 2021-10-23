const library = require('./library');
const {expect} = require('chai');

describe('Test Suite', () => {
    describe('calcPriceOfBook tests', () => {
        it('Should throw ex with invalid input ', function () {
            expect(() => library.calcPriceOfBook(null, 1995)).to.throw('Invalid input');
            expect(() => library.calcPriceOfBook('a', null)).to.throw('Invalid input');
            expect(() => library.calcPriceOfBook(null, null)).to.throw('Invalid input');
            expect(() => library.calcPriceOfBook('a')).to.throw('Invalid input');
            expect(() => library.calcPriceOfBook(1995)).to.throw('Invalid input');
        });

        it('Should calculate correctly with year <= 1980', function () {
            expect(library.calcPriceOfBook('Hell1', 1980)).to.equal('Price of Hell1 is 10.00');
            expect(library.calcPriceOfBook('Hell2', 1979)).to.equal('Price of Hell2 is 10.00');
        });

        it('Should calculate correctly with year > 1980', function () {
            expect(library.calcPriceOfBook('Hell3', 1981)).to.equal('Price of Hell3 is 20.00');
            expect(library.calcPriceOfBook('Hell4', 2000)).to.equal('Price of Hell4 is 20.00');
        });
    });

    describe('findBook tests', () => {
        it('Should ex without any books', function () {
            expect(() => library.findBook([], 'Book')).to.throw('No books currently available');
        });

        it('Should return correct book with valid book and non empty book array', function () {
            expect(library.findBook(['Test1', 'Test2', 'Test3'], 'Test2')).to.equal('We found the book you want.');
        });

        it('Should return correct output if the book is not found', function () {
            expect(library.findBook(['Test1', 'Test2', 'Test3'], 'InvalidBook')).to.equal('The book you are looking for is not here!');
        });
    });

    describe('arrangeBooks tests', () => {
        it('Should ex with invalid input', function () {
            expect(() => library.arrangeTheBooks('a')).to.throw('Invalid input');
            expect(() => library.arrangeTheBooks(null)).to.throw('Invalid input');
            expect(() => library.arrangeTheBooks()).to.throw('Invalid input');
            expect(() => library.arrangeTheBooks(-1)).to.throw('Invalid input');
        });

        it('Should return correct output with available space >= count of books', function () {
            expect(library.arrangeTheBooks(3)).to.equal('Great job, the books are arranged.');
            expect(library.arrangeTheBooks(5)).to.equal('Great job, the books are arranged.');
            expect(library.arrangeTheBooks(39)).to.equal('Great job, the books are arranged.');
            expect(library.arrangeTheBooks(40)).to.equal('Great job, the books are arranged.');
        });

        it('Should return correct output with available space < count of books', function () {
            expect(library.arrangeTheBooks(500)).to.equal('Insufficient space, more shelves need to be purchased.');
        });
    });
});