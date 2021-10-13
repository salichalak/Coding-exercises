class Rectangle {
    constructor(w, h, c) {
        this.width = w
        this.height = h
        this.color = c
    }

    calcArea = () =>
        this.width * this.height;
}