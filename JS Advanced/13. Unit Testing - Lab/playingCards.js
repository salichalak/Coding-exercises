function makeCard(face, suit) {
    const faces = [2, 3, 4, 5, 6, 7, 8, 9, 10, 'J', 'Q', 'K', 'A'];
    if (!faces.includes(face)) {throw new Error("Invalid card face: " + face);}

    const suites = ['S', 'H', 'D', 'C'];
    if (!suites.includes(suit)) {throw new Error("Invalid card suit: " + suit);}

    let card = {
        face,
        suit,
        toString() {
            let result = {
                'S': "\u2660",
                'H': "\u2665",
                'D': "\u2666",
                'C': "\u2663"
            };
            return card.face + result[card.suit];
        }
    }
    return card;
}