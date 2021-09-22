function solve(width, height, color) {
    return {
        width,
        height,
        color: color[0].toUpperCase() + color.slice(1),
        calcArea: function () {
            return this.width * this.height
        },
    }
}