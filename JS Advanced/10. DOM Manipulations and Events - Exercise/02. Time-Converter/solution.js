function attachEventsListeners() {
    const days = document.getElementById('days');
    const hours = document.getElementById('hours');
    const minutes = document.getElementById('minutes');
    const seconds = document.getElementById('seconds');

    document.getElementById('daysBtn').addEventListener('click', () => {
        const daysValue = Number(days.value);
        hours.value = daysValue * 24;
        minutes.value = daysValue * 60 * 24;
        seconds.value = daysValue * 60 * 60 * 24;
    });

    document.getElementById('hoursBtn').addEventListener('click', () => {
        const hoursValue = Number(hours.value);
        days.value = hoursValue / 24;
        minutes.value = hoursValue * 60;
        seconds.value = hoursValue * 60 * 60;
    });

    document.getElementById('minutesBtn').addEventListener('click', () => {
        const minutesValue = Number(minutes.value);
        hours.value = minutesValue / 60;
        days.value = minutesValue / 60 / 24;
        seconds.value = minutesValue * 60;
    });

    document.getElementById('secondsBtn').addEventListener('click', () => {
        const secondsValue = Number(seconds.value);
        hours.value = secondsValue / 3600;
        minutes.value = secondsValue / 60;
        days.value = secondsValue / 60 / 60 / 24;
    });
}