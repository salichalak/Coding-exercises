const dealership = require('./dealership');
const {expect} = require('chai');

describe('Dealership Test Suite', function () {
    describe('newCarCost tests', function () {
        it('Should return new car price if the model does not exist', function () {
            expect(dealership.newCarCost('Audi A3 8L', 666)).to.equal(666);
        });

        it('Should correct price for each valid model', function () {
            expect(dealership.newCarCost('Audi A4 B8', 20000)).to.equal(5000);
            expect(dealership.newCarCost('Audi A6 4K', 25000)).to.equal(5000);
            expect(dealership.newCarCost('Audi A8 D5', 30000)).to.equal(5000);
            expect(dealership.newCarCost('Audi TT 8J', 16000)).to.equal(2000);
        });

        it('Should work correctly with old car price equal to new car price', function () {
            expect(dealership.newCarCost('Audi A4 B8', 15000)).to.equal(0);
            expect(dealership.newCarCost('Audi A6 4K', 20000)).to.equal(0);
            expect(dealership.newCarCost('Audi A8 D5', 25000)).to.equal(0);
            expect(dealership.newCarCost('Audi TT 8J', 14000)).to.equal(0);
        });
    });

    describe('carEquipment tests', function () {
        it('Should return correct extras', function () {
            expect(dealership.carEquipment(['seats', 'roof', 'rims', 'navigation'], [0, 1]))
                .to.have.all.members(['seats', 'roof']);
            expect(dealership.carEquipment(['seats', 'roof', 'rims', 'navigation'], [0]))
                .to.have.all.members(['seats']);
        });
    });

    describe('euroCategory tests', function () {
        it('Should work correctly with category > 4', function () {
            expect(dealership.euroCategory(5)).to.be.equal('We have added 5% discount to the final price: 14250.');
        });

        it('Should work correctly with category = 4', function () {
            expect(dealership.euroCategory(4)).to.be.equal('We have added 5% discount to the final price: 14250.');
        });

        it('Should work correctly with category < 4', function () {
            expect(dealership.euroCategory(3)).to.be.equal('Your euro category is low, so there is no discount from the final price!')
        });
    });
});