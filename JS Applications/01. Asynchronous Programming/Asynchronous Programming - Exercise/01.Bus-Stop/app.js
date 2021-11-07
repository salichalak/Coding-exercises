async function getInfo() {
    const stopId = document.getElementById('stopId').value;
    const stopNameElement = document.getElementById('stopName');
    const busesElement = document.getElementById('buses');

    try {
        stopNameElement.textContent = 'Please wait!';
        busesElement.textContent = '';

        const res = await fetch('http://localhost:3030/jsonstore/bus/businfo/' + stopId);

        if (res.status !== 200) {
            throw new Error('Invalid input!');
        }

        const data = await res.json();
        stopNameElement.textContent = data.name;

        for (const bus of Object.entries(data.buses)) {
            const id = bus[0];
            const time = bus[1];
            
            const li = document.createElement('li');
            li.textContent = `Bus ${id} arrives in ${time} minutes`;
            busesElement.appendChild(li);
        }
    } catch (e) {
        stopNameElement.textContent = 'Error';
    }
}