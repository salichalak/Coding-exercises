function attachEvents() {
    const locationElement = document.getElementById('location');
    const getWeatherBtn = document.getElementById('submit');
    getWeatherBtn.addEventListener('click', getInfo);

    const imgParser = {
        Sunny: () => '☀',
        'Partly sunny': () => '⛅',
        Overcast: () => '☁',
        Rain: () => '☂'
    }

    function getInfo() {
        let forecastContainer = document.getElementById('forecast');
        forecastContainer.style.direction = 'block';
        fetch('http://localhost:3030/jsonstore/forecaster/locations')
            .then(body => body.json())
            .then(locations => {
                let locationName = locationElement.value;
                let location = locations.find(l => l.name === locationName);
                return fetch('http://localhost:3030/jsonstore/forecaster/today/' + location.code)
                .then(body => body.json())
                .then(currentWeatherReport => ({code:location.code, currentWeatherReport}))
            })
            .then(({code, currentWeatherReport}) => {
                let report = createCurrentWeatherElement(currentWeatherReport);
                let currentForecastDiv = document.querySelector('#current');
                currentForecastDiv.append(report);

            return fetch('http://localhost:3030/jsonstore/forecaster/today/' + code);
            })
            .then(body => body.json())
            .then(upcomingWeatherReport => {

            })

        function createCurrentWeatherElement(weatherReport) {
            const forecastsDiv = document.createElement('div');
            forecastsDiv.classList.add('forecasts');

            const conditionSymbolSpan = document.createElement('span');
            conditionSymbolSpan.classList.add('condition', 'symbol');
            conditionSymbolSpan.textContent = imgParser[weatherReport.forecast.condition]();

            let conditionSpan = document.createElement('span');
            conditionSpan.classList.add('condition');

            let nameSpan = document.createElement('span');
            nameSpan.classList.add('forecast-data');
            nameSpan.textContent = weatherReport.name;

            let temperatureSpan = document.createElement('span');
            temperatureSpan.classList.add('forecast-data');
            temperatureSpan.textContent = `${weatherReport.forecast.low}°/${weatherReport.forecast.high}°`;

            let weatherSpan = document.createElement('span');
            weatherSpan.classList.add('forecast-data');
            weatherSpan.textContent = weatherReport.forecast.condition;

            conditionSpan.appendChild(nameSpan);
            conditionSpan.appendChild(temperatureSpan);
            conditionSpan.appendChild(weatherSpan);

            forecastsDiv.appendChild(conditionSymbolSpan);
            forecastsDiv.appendChild(conditionSymbol);
        }
    }
}

attachEvents();