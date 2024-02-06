import React, { useEffect, useState } from 'react'
import DefaultLayout from '../layout/DefaultLayout'
import { requestNewsList } from '../api/newsApi';
import Card from '../component/card/Card';

const keywordList = {
	WOORI: "우리은행",
	NH: "농협은행",
	SH: "신한은행",
	KB: "국민은행",
	HANA: "하나은행"
};

const NewsList = () => {
	const [list, setList] = useState([]);
	const [query, setQuery] = useState(Object.values(keywordList)[0]);
	const [start, setStart] = useState(1);

	useEffect(() => {

		requestNewsList(query, start).then((res) => {
			const sortedNewsList = res.news.sort((a, b) => {
				const dateA = new Date(a.pubDate);
				const dateB = new Date(b.pubDate);
				return dateB - dateA;
			});

			setList(sortedNewsList);
		});
	}, [query, start]);


	return (
		<DefaultLayout>
			<div className='w-full h-full p-10 flex flex-col items-center'>
				<div className='w-[600px] mt-10 flex justify-between'>
					{
						Object.values(keywordList).map((keyword, idx) => {
							return <div key={idx}
								className={(query === keyword
									? 'bg-[#bfdbfe]'
									: 'bg-[#e0f2fe] hover:bg-[#dbeafe] active:bg-[#bfdbfe] active:relative active:top-[1px]')
									+ ` text-[#3b82f6] px-4 py-2 rounded-md shadow-sm cursor-pointer`}
								onClick={() => { setQuery(keyword) }}
							>
								{keyword}
							</div>
						})
					}
				</div>
				<div className='w-[80%] mt-10 flex justify-center flex-wrap gap-10'>
					{list.map((news, idx) => {
						return <Card key={idx} title={news.title} description={news.description} link={news.link} pubDate={news.pubDate} ></Card>
					})}
				</div>
			</div>
		</DefaultLayout>
	)
}

export default NewsList