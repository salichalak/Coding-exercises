class artGallery {
    constructor(creator) {
        this.creator = creator;
        this.possibleArticles = {"picture": 200, "photo": 50, "item": 250};
        this.listOfArticles = [];
        this.guests = [];
    }

    addArticle(articleModel, articleName, quantity) {
        if (!this.possibleArticles.hasOwnProperty(articleModel.toLowerCase())) {
            throw new Error("This article model is not included in this gallery!");
        }
        if (this.listOfArticles.some(a => a.articleName === articleName)) {
            const current = this.listOfArticles.find(a => a.articleName === articleName);
            current.quantity = Number(current.quantity) + Number(quantity);
        } else {
            const toLowerCase = articleModel.toLowerCase()
            this.listOfArticles.push({
                articleModel: toLowerCase,
                articleName,
                quantity
            });
        }

        return `Successfully added article ${articleName} with a new quantity- ${quantity}.`;
    }

    inviteGuest(guestName, personality) {
        if (!this.guests.some(g => g.guestName === guestName)) {
            let points = 0
            if (personality === 'Vip') {
                points = 500;
            } else if (personality === 'Middle') {
                points = 250;
            } else {
                points = 50;
            }

            this.guests.push({
                guestName,
                points,
                purchaseArticle: 0
            });

            return `You have successfully invited ${guestName}!`;
        } else {
            throw new Error(`${guestName} has already been invited.`);
        }
    }

    buyArticle(articleModel, articleName, guestName) {
        if (this.possibleArticles.hasOwnProperty(articleModel.toLowerCase())) {
            if (this.listOfArticles.find(a => a.quantity === 0)) {
                return `The ${articleName} is not available.`;
            }
        }

        if (!this.listOfArticles.some(a => a.articleName === articleName) ||
            !this.possibleArticles.hasOwnProperty(articleModel.toLowerCase())) {
            throw new Error('This article is not found.');
        }

        if (!this.guests.find((g => g.guestName === guestName))) {
            return `This guest is not invited.`;
        } else {
            const currentGuest = this.guests.find((g => g.guestName === guestName))
            const currentArticle = this.listOfArticles.find((a => a.articleName === articleName))
            const articlePoints = this.possibleArticles[articleModel];
            if (currentGuest.points >= articlePoints) {
                currentGuest.points -= articlePoints;
                currentArticle.quantity -= 1;
                currentGuest.purchaseArticle += 1;
                return `${guestName} successfully purchased the article worth ${articlePoints} points.`;
            } else {
                return "You need to more points to purchase the article.";
            }
        }
    }

    showGalleryInfo(criteria) {
        if (criteria === 'article') {
            let output = `Articles information:\n`;
            for (const article of this.listOfArticles) {
                output += `${article.articleModel} - ${article.articleName} - ${article.quantity}\n`;
            }
            return output.slice(0, -1);
        } else if (criteria === 'guest') {
            let output = 'Guests information:\n';
            for (const guest of this.guests) {
                output += `${guest.guestName} - ${guest.purchaseArticle}\n`;
            }
            return output.slice(0, -1);
        }
    }
}