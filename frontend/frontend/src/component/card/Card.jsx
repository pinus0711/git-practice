import React from 'react'
import { formatDistanceToNow } from "date-fns";
import { ko } from 'date-fns/locale';

const Card = ({ title, description, link, pubDate }) => {
	return (
		<div
			className='w-[630px] h-[250px]  flex flex-col justify-center p-10 border-2 border-[#e5e7eb] rounded-md shadow-sm cursor-pointer hover:border-[#bfdbfe] hover:shadow-md'
		>
			<div className='text-[20px] font-bold truncate'
				dangerouslySetInnerHTML={{ __html: title }}></div>
			<div className='mt-2 text-[17px]  line-clamp-3'
				dangerouslySetInnerHTML={{ __html: description }}></div>
			<div className='mt-2 self-end text-[#3b82f6]'>{formatDistanceToNow(new Date(pubDate), { addSuffix: true, locale: ko })}</div>
		</div>
	)
}

export default Card