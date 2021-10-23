const cinema = require("./cinema");
const {expect} = require("chai");

describe('Cinema - Test Suite', function () {
    describe('showMovies tests', function () {
        it('Test with empty array movies', function () {
            expect(cinema.showMovies([])).to.be.equal('There are currently no movies to show.');
        });

        it('Test with valid array of movies', function () {
            expect(cinema.showMovies(['JS'])).to.be.equal('JS');
            expect(cinema.showMovies(['JS', 'Java', 'C#'])).to.be.equal('JS, Java, C#');
        });
    });

    describe('ticketPrice tests', function () {
        it("Premiere price", function () {
            expect(cinema.ticketPrice("Premiere")).to.be.equal(12.00);
        })

        it("Normal price", function () {
            expect(cinema.ticketPrice("Normal")).to.be.equal(7.50);
        })

        it("Discount price", function () {
            expect(cinema.ticketPrice("Discount")).to.be.equal(5.50);
        })

        it('Should throw ex with invalid projection type ', function () {
            expect(() => cinema.ticketPrice("Invalid")).to.throw("Invalid projection type.");
            expect(() => cinema.ticketPrice('')).to.throw('Invalid projection type.');
            expect(() => cinema.ticketPrice(null)).throw('Invalid projection type.');
            expect(() => cinema.ticketPrice(undefined)).throw('Invalid projection type.');
        });
    });

    describe('swapSeatsInHall tests', function () {
        it('Should swap correctly with valid params', function () {
            expect(cinema.swapSeatsInHall(1, 2)).to.be.equal("Successful change of seats in the hall.");
            expect(cinema.swapSeatsInHall(20, 2)).to.be.equal("Successful change of seats in the hall.");
            expect(cinema.swapSeatsInHall(1, 20)).to.be.equal("Successful change of seats in the hall.");
        });

        it('Should throw ex with invalid params', function () {
            expect(cinema.swapSeatsInHall(21)).equal("Unsuccessful change of seats in the hall.");
            expect(cinema.swapSeatsInHall(11.11, 12)).equal("Unsuccessful change of seats in the hall.");
            expect(cinema.swapSeatsInHall(11, 12.12)).equal("Unsuccessful change of seats in the hall.");
            expect(cinema.swapSeatsInHall(11.11, 12.12)).equal("Unsuccessful change of seats in the hall.");
            expect(cinema.swapSeatsInHall(30, 5)).equal("Unsuccessful change of seats in the hall.");
            expect(cinema.swapSeatsInHall(5, 30)).equal("Unsuccessful change of seats in the hall.");
            expect(cinema.swapSeatsInHall(6, -6)).equal("Unsuccessful change of seats in the hall.");
            expect(cinema.swapSeatsInHall(-6, 7)).equal("Unsuccessful change of seats in the hall.");
            expect(cinema.swapSeatsInHall(-6, -6)).equal("Unsuccessful change of seats in the hall.");
            expect(cinema.swapSeatsInHall(6, 0)).equal("Unsuccessful change of seats in the hall.");
            expect(cinema.swapSeatsInHall(0, 6)).equal("Unsuccessful change of seats in the hall.");
            expect(cinema.swapSeatsInHall(0, 0)).equal("Unsuccessful change of seats in the hall.");
            expect(cinema.swapSeatsInHall(5, 5)).to.be.equal("Unsuccessful change of seats in the hall.");
            expect(cinema.swapSeatsInHall('test', 5)).equal("Unsuccessful change of seats in the hall.");
            expect(cinema.swapSeatsInHall(null, 5)).equal("Unsuccessful change of seats in the hall.");
            expect(cinema.swapSeatsInHall(50, 40)).equal("Unsuccessful change of seats in the hall.");
            expect(cinema.swapSeatsInHall(10, 10)).equal("Unsuccessful change of seats in the hall.");
        });
    });
});