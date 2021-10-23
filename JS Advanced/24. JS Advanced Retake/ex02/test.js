const ChristmasMovies = require('./ChristmasMovies');
const {expect} = require('chai');

describe('Test suite', () => {
    let instance = {};
    beforeEach(() => instance = new ChristmasMovies());

    describe('Instantiation tests', () => {
        it('Should correctly work without parameters', function () {
            expect(instance.movieCollection).to.have.all.members([]);
            expect(instance.movieCollection).to.not.be.undefined;
            expect(instance.watched).to.deep.equal({});
            expect(instance.watched).to.not.be.undefined;
            expect(instance.actors).to.have.all.members([]);
            expect(instance.actors).to.not.be.undefined;
        });

        describe('buyMovie tests', () => {
            it('Should return correct output', () => {
                expect(instance.buyMovie('Movie', ['Anyone', 'Someone', 'Anyone'])).to
                    .equal('You just got Movie to your collection in which Anyone, Someone are taking part!');
                expect(() => instance.buyMovie('Movie', ['Jason'])).to
                    .throw('You already own Movie in your collection!');
            });
        });

        describe('discardMovie tests', () => {
            it('Should return correct output', () => {
                instance.buyMovie('testmovie', ['TheRock']);
                instance.buyMovie('SAW', ['Nobody']);
                instance.watched.testmovie = 1;
                expect(instance.discardMovie('testmovie')).to.equal('You just threw away testmovie!');
                expect(() => instance.discardMovie('notExistingMovie')).to.throw('notExistingMovie is not at your collection!');
                expect(() => instance.discardMovie('SAW')).to.throw('SAW is not watched!');
            });
        });

        describe('watchMovie tests', () => {
            it('Add watched movies to watched array', () => {
                instance.buyMovie('SAW', ['TheRock']);
                instance.watchMovie('SAW');
                expect(instance.watched.SAW).to.equal(1);
                expect(() => instance.watchMovie('Hell')).to.throw('No such movie in your collection!');
            });
        });

        describe('favouriteMovie tests', () => {
            it(`Should return correct output`, () => {
                instance.watched.SAW = 4;
                instance.watched.Movie = 5;
                expect(instance.favouriteMovie()).to.equal('Your favourite movie is Movie and you have watched it 5 times!');
            });

            it('Should throw ex without watched movies', () => {
                expect(() => instance.favouriteMovie()).to.throw('You have not watched a movie yet this year!');
            });
        });

        describe('mostStarredActors tests', () => {
            it(`Should return correct output`, () => {
                instance.buyMovie('Hell1', ['TheRock', 'Jason']);
                instance.buyMovie('Hell2', ['TheRock', 'Nobody']);
                instance.buyMovie('Hell3', ['TheRock', 'Test']);
                expect(instance.mostStarredActor()).to.equal(`The most starred actor is TheRock and starred in 3 movies!`);
            });

            it('Should throw when there are no watched movies', () => {
                expect(() => instance.mostStarredActor()).to.throw('You have not watched a movie yet this year!');
            });
        });
    });
});