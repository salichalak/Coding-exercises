function solve() {
    const departButton = document.getElementById('depart');
    const arriveButton = document.getElementById('arrive');
    const info = document.querySelector('#info span');

    let stop = {
        next: 'depot'
    };

    async function depart() {
        departButton.disabled = true;
        arriveButton.disabled = false;
        const res = await fetch('http://localhost:3030/jsonstore/bus/schedule/' + stop.next);
        const data = await res.json();
        info.textContent = 'Next stop ' + data.name;
        stop = data;
    }

    function arrive() {
        departButton.disabled = false;
        arriveButton.disabled = true;
        const currentStop = stop.name;
        info.textContent = 'Arriving at ' + currentStop;
    }

    return {
        depart,
        arrive
    };
}

let result = solve();