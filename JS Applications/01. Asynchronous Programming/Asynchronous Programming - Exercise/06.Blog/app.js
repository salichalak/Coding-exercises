const posts = document.getElementById('posts');
const loadPostsBtn = document.getElementById('btnLoadPosts');
const viewPostBtn = document.getElementById('btnViewPost');

function attachEvents() {
    loadPostsBtn.addEventListener('click', async () => {
        const res = await fetch('http://localhost:3030/jsonstore/blog/posts');
        const data = await res.json();
        Object.values(data).forEach(post => {
            posts.appendChild(createElement('option', post.title, ['value', post.id]));
        });
    });


    viewPostBtn.addEventListener('click', async () => {
        const id = posts.value;
        const post = await getPostInfo(id);
        const postTitle = document.getElementById('post-title');
        postTitle.textContent = post.title;
        const postBody = document.getElementById('post-body');
        postBody.textContent = post.body;
        const res = await fetch('http://localhost:3030/jsonstore/blog/comments');
        const data = await res.json();
        const comments = Object.values(data).filter(p => p.postId == id);
        const postComments = document.getElementById('post-comments');
        postComments.innerHTML = '';
        comments.forEach(c => {
            postComments.appendChild(createElement('li', c.text, ['id', c.id]));
        });
    });

    function createElement(type, content, attributes = []) {
        const element = document.createElement(type);
        if (content) {
            element.textContent = content;
        }
        if (attributes.length > 0) {
            element.setAttribute(attributes[0], attributes[1]);
        }
        return element;
    }

    async function getPostInfo(id) {
        const res = await fetch('http://localhost:3030/jsonstore/blog/posts/' + id);
        const data = await res.json();
        return data;
    }
}

attachEvents();