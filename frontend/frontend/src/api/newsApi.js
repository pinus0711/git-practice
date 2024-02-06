export const requestNewsList = async (query, start) => {
	const res = await fetch(`/api/newsList?query=${query}&start=${start}`,
		{ credentials: 'include' }
	);

	if (res.status === 401) {
		sessionStorage.clear();
		window.location.href = "/login";
	}

	return await res.json();
};