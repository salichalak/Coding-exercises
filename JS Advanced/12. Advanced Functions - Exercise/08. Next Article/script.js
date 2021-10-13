function getArticleGenerator(articles) {
    const output = document.getElementById("content");
    const copy = articles.slice();

    return function showNext(arr = []) {
        if (copy[0]) {
            const article = document.createElement("article");
            article.innerHTML = copy.shift();
            output.appendChild(article);
        }
        return showNext;
    }
}