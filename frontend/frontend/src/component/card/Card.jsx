import React from 'react'

const Card = ({ title, description, link, pubDate }) => {
	return (
		<div
			className='w-[630px] p-10 border-2 border-[#e5e7eb] rounded-md shadow-sm cursor-pointer hover:border-[#bfdbfe] hover:shadow-md'
		>
			<div className=''
				dangerouslySetInnerHTML={{ __html: title }}></div>
			{/* <div>{link}</div> */}
			<div className='mt-2'
				dangerouslySetInnerHTML={{ __html: description }}></div>
			<div className='mt-2 text-right'>{pubDate}</div>
		</div>
	)
}

export default Card