class Person {
    constructor(firstName, lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        Object.defineProperty(this, 'fullName', {
            enumerable: true,
            get() {
                return `${this.firstName} ${this.lastName}`
            },
            set(value) {
                [this.firstName, this.lastName] = value.split(' ');
            }
        });
    }
}