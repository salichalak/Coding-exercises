function cooking(num, op1, op2, op3, op4, op5) {
    const operations = [op1, op2, op3, op4, op5];

    for (const operation of operations) {
        switch (operation) {
            case "chop":
                console.log(num /= 2);
                break;
            case "dice":
                console.log(num = Math.sqrt(num));
                break;
            case "spice":
                console.log(num += 1);
                break;
            case "bake":
                console.log(num *= 3);
                break;
            case "fillet":
                console.log(num *= 0.8);
                break;
        }
    }
}