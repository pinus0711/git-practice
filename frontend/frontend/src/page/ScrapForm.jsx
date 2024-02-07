import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom';
import { requestNewById } from '../api/newsApi';

const ScrapForm = () => {
	const params = useParams();
	const { newsId } = params;
	const [news, setNews] = useState({});

	if (!newsId) {
		return;
	}

	useEffect(() => {
		requestNewById(newsId)
			.then((res) => {
				setNews(res)
			});
	}, []);

	return (
		<div>
			<div>{news.id}</div>
			<div>{news.title}</div>
			<div>{news.description}</div>
			<div>{news.pubDate}</div>
			<div>{news.link}</div>
			<div>{news.keyword}</div>
		</div>
	)
}

export default ScrapForm