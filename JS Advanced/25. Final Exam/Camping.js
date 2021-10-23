class SummerCamp {
    constructor(organizer, location) {
        this.organizer = organizer;
        this.location = location;
        this.priceForTheCamp = {"child": 150, "student": 300, "collegian": 500};
        this.listOfParticipants = [];
    }

    registerParticipant(name, condition, money) {
        money = Number(money);

        if (!this.priceForTheCamp.hasOwnProperty(condition)) {
            throw new Error('Unsuccessful registration at the camp.');
        }

        if (this.listOfParticipants.some(p => p.name === name)) {
            return `The ${name} is already registered at the camp.`;
        }

        if (money < Number(this.priceForTheCamp[condition])) {
            return `The money is not enough to pay the stay at the camp.`;
        }

        this.listOfParticipants.push({name, condition, power: 100, wins: 0});
        return `The ${name} was successfully registered.`
    }

    unregisterParticipant(name) {
        if (this.listOfParticipants.some(p => p.name === name) === false) {
            throw new Error(`The ${name} is not registered in the camp.`);
        }

        this.listOfParticipants = this.listOfParticipants.filter(p => p.name !== name);
        return `The ${name} removed successfully.`;
    }

    timeToPlay(typeOfGame, participant1, participant2) {
        if (typeOfGame === 'WaterBalloonFights') {
            if (this.listOfParticipants.some(p => p.name !== participant1 || p.name !== participant2)) {
                throw new Error('Invalid entered name/s.');
            }

            if (this.listOfParticipants[participant1].condition !== this.listOfParticipants[participant2].condition) {
                throw new Error('Choose players with equal condition.');
            }

            let p1 = this.listOfParticipants.find(p => p.name = participant1)
            let p1Power = Number(p1);
            let p2 = this.listOfParticipants.find(p => p.name = participant2)
            let p2Power = Number(p2);


            if (p1Power > p2Power) {
                this.listOfParticipants[participant1].wins = p1Wins + 1;
                return `The ${participant1} is winner in the game ${typeOfGame}.`;
            } else if (p2Power > p1Power) {
                this.listOfParticipants[participant2].wins = p2Wins + 1;
                return `The ${participant2} is winner in the game ${typeOfGame}.`;
            } else {
                return 'There is no winner.';
            }
        }

        if (typeOfGame === 'Battleship') {
            if (!this.listOfParticipants.some(p => p.name === participant1)) {
                throw new Error('Invalid entered name/s.');
            }
            let currPower = this.listOfParticipants['participant1'].power;
            this.listOfParticipants[participant1].power = Number(currPower) + 20;
            return `The ${participant1} successfully completed the game ${typeOfGame}.`;
        }
    }

    toString() {
        let result = [];

        let numberOfParticipants = Object.keys(this.listOfParticipants).length;
        result.push(`${this.organizer} will take ${numberOfParticipants} participants on camping to ${this.location}`);

        this.listOfParticipants
            .sort((a, b) => b.power - a.power)
            .map(p => `${p.name} - ${p.condition} - ${p.power} - ${p.wins}`)
            .forEach(p => result.push(p));

        return result.join('\n');
    }
}