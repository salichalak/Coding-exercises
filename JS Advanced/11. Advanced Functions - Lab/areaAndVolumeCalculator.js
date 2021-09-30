function solve(area, vol, input) {
    let objects = JSON.parse(input);

    function calcualte(obj) {
        let areaObj = Math.abs(area.call(obj));
        let volumeObj = Math.abs(vol.call(obj));

        return {
            area: areaObj,
            volume: volumeObj
        }
    }

    return objects.map(calcualte);
}