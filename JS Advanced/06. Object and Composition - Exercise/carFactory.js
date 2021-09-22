function foo({model, power, color, carriage, wheelsize}) {
    const engines = [
        {power: 90, volume: 1800},
        {power: 120, volume: 2400},
        {power: 200, volume: 3500},
    ];

    const carriages = [
        {type: "hatchback", color: ""},
        {type: "coupe", color: ""},
    ];

    function getWheels(wheelsize) {
        let wheel = Math.floor(wheelsize) % 2 === 0
            ? Math.floor(wheelsize) - 1
            : Math.floor(wheelsize);

        return [wheel, wheel, wheel, wheel];
    }

    return {
        model,
        engine: engines.reduce((a, v) =>
            Math.abs(a.power - power) < Math.abs(v.power - power)
                ? a
                : v
        ),
        carriage: {type: carriage, color},
        wheels: getWheels(wheelsize),
    }
}