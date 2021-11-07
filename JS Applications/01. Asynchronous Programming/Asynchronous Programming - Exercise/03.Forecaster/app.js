const weathers = {
    Sunny: '&#x2600;',
    'Partly sunny': '&#x26C5;',
    Overcast: '&#x2601;',
    Rain: '&#x2614;',
    Degrees: '&#176;',
}

const getData = async (uri) => {
    const res = await fetch(`http://localhost:3030/jsonstore/forecaster/${uri}`);
    if (res.ok != true) {
        throw new Error(res.statusText);
    }
    const data = res.json();
    return data;
}

const getCode = (locations, locationName) => {
    const location = locations.find(l => l.name === locationName);
    if (location === undefined || location === null) {
        throw new Error('Location not found!');
    }
    return location.code;
}

function currentDay({ condition, high, low }) {
    const span = document.createElement('span');
    span.className = 'upcoming';
    span.innerHTML = `<span class="symbol">${weathers[condition]}</span>
    <span class="forecast-data">${high}&#176;/${low}&#176;</span>
    <span class="forecast-data">${condition}</span>`;
    return span;
}

function nextDay({ forecast, name }) {
    const div = document.createElement('div');
    div.setAttribute('class', 'forecasts');
    div.innerHTML = `<span class="condition symbol">${weathers[forecast.condition]}</span>
    <span class="condition"><span class="forecast-data">${name}</span>
    <span class="forecast-data">${forecast.high}&#176;/${forecast.low}&#176;</span>
    <span class="forecast-data">${forecast.condition}</span></span>`;
    return div;
}

async function displayData(name) {
    const current = document.getElementById('current');
    current.innerHTML = `<div class="label">Current conditions</div>`;
    const upcoming = document.getElementById('upcoming');
    upcoming.innerHTML = `<div class="label">Three-day forecast</div>`;
    const forecast = document.getElementById('forecast');
    forecast.style.display = 'block';

    try {
        const info = await getData('locations');
        const code = getCode(info, name);
        const tmrw = await getData(`today/${code}`)
        const threeDays = await getData(`upcoming/${code}`)
        current.appendChild(nextDay(tmrw));
        Object.values(threeDays.forecast)
            .forEach(x => upcoming.appendChild(currentDay(x)));
    } catch (err) {
        current.appendChild(document.createTextNode('Error'));
    }
}

function attachEvents() {
    const input = document.getElementById('location');
    const submitBtn = document.getElementById('submit');
    submitBtn.addEventListener('click', () => displayData(input.value));
}

attachEvents();