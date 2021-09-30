function solve(string, criteria) {
    let data;
    let propName
    let propValue;
    const isNotAll = criteria !== 'all';

    if (isNotAll) {
        [propName, propValue] = criteria.split('-');
        if (!propValue || !propValue) {
            throw new Error('Criteria are in wrong format! Invalid criteria!');
        }
    }

    try {
        data = JSON.parse(string);
    } catch (error) {
        data = [];
    }

    data.filter(function (i) {

        return isNotAll
            ? i[propName] === propValue
            : true;
    }).forEach((item, index) => console.log(`${index}. ${item.first_name} ${item.last_name} - ${item.email}`));
}