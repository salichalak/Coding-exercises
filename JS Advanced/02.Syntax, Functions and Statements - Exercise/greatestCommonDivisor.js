function gcd(num1, num2) {
    while (num2 != 0) {
        const temp = num2;
        num2 = num1 % num2;
        num1 = temp;
    }
 
    return num1;
}