function solve(arr) {
    let data = [];
    for (let i = 0; i < arr.length; i++) {
        let [name, level, items] = arr[i].split(' / ');
        level = Number(level);
        items = items !== undefined
            ? items.split(', ')
            : [];

        data.push({name, level, items});

    }
    return JSON.stringify(data);
}