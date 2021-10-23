class Story {
    constructor(title, creator) {
        this.title = title;
        this.creator = creator;
        this._comments = [];
        this._likes = [];
    }

    get likes() {
        if (this._likes.length === 0) {
            return `${this.title} has 0 likes`;
        } else if (this._likes.length === 1) {
            return `${this._likes[0]} likes this story!`;
        }

        return `${this._likes[0]} and ${this._likes.slice(1).length} others like this story!`;
    }

    like(username) {
        if (this._likes.includes(username)) {
            throw new Error("You can't like the same story twice!");
        }
        if (username === this.creator) {
            throw new Error("You can't like your own story!");
        }

        this._likes.push(username);
        return `${username} liked ${this.title}!`;
    }

    dislike(username) {
        if (!this._likes.includes(username)) {
            throw new Error("You can't dislike this story!");
        }
        this._likes = this._likes.filter(user => user !== username);

        return `${username} disliked ${this.title}`;
    }

    comment(username, content, id) {
        let comment = {
            Id: id,
            Username: username,
            Content: content,
            Replies: [],
        };

        let matchingComment = this._comments.find(c => c.Id === id);

        if (matchingComment) {
            let replyID = Number(matchingComment.Id + '.' + (matchingComment.Replies.length + 1));
            let reply = {
                Id: replyID,
                Username: username,
                Content: content,
            };

            matchingComment.Replies.push(reply);

            return 'You replied successfully';
        }

        comment.Id = this._comments.length + 1;
        this._comments.push(comment);

        return `${username} commented on ${this.title}`;
    }

    toString(sortingType) {
        const sortingLibrary = {
            asc: (a, b) => a.Id - b.Id,
            desc: (a, b) => b.Id - a.Id,
            username: a.Username.localeCompare(b.Username)
        }

        const sortedComments = this._comments.sort(sortingLibrary[sortingType]);
        sortedComments.forEach(c => c.Replies.sort(sortingLibrary[sortingType]));

        let commentsStringArr = [];
        for (const comment of sortedComments) {
            const commentsAsString = `--${comment.Id}. ${comment.Username}: ${comment.Content}`
            let repliesAsString = comment.Replies
                .map(r => `--- ${r.Id}. ${r.Username}: ${r.Content}`)
                .join('\n');
            repliesAsString = comment.Replies.length > 0 ? `\n${repliesAsString}` : '';
            const result = `${commentsAsString}${repliesAsString}`;
            commentsStringArr.push(result);
        }

        const fullCommentString = commentsStringArr.join('\n');

        return `Title: ${this.title}
Creator: ${this.creator}
Likes: ${this._likes.length}
Comments:
${fullCommentString}`
    }
}