function townPopulation(townData) {
    const towns = {};

    for (let town of townData) {
        let tokens = town.split(' <-> ');
        let name = tokens[0];
        let population = Number(tokens[1]);

        if (towns[name] != undefined) {
            population += towns[name];
        }

        towns[name] = population;
    }

    for (let town in towns) {
        console.log(`${town} : ${towns[town]}`);
    }
}