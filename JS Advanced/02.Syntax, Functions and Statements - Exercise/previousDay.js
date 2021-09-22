function solve(year, month, day) {
    let dateAsString = year + '-' + month + '-' + day;
    let newDate = new Date(dateAsString);
    newDate.setDate(day - 1);
    console.log(newDate.getFullYear() + `-` + (Number(newDate.getMonth()) + 1) + '-' + newDate.getDate());
}