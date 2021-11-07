async function loadRepos() {
	const name = document.getElementById('username');
	const result = document.getElementById('repos');
	const res = await fetch(`https://api.github.com/users/${name.value}/repos`);
	const data = await res.json()
	result.innerHTML = ''

	data.forEach(({ name, url }) => {
		const a = document.createElement('a');
		a.innerHTML = name;
		a.href = url;
		const li = document.createElement('li');
		li.appendChild(a);
		result.appendChild(li);
	});
}