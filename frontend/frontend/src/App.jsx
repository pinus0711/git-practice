import "./index.css";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import NewsList from "./page/NewsList";
import { useEffect } from "react";
import { requestDummyNews, saveNews } from "./api/newsApi";
import ScrapForm from "./page/ScrapForm";

export const keywordList = {
  WOORI: "우리은행",
  NH: "농협은행",
  SH: "신한은행",
  KB: "국민은행",
  HANA: "하나은행"
};


function App() {
  const start = 1;
  const display = 100;

  const settingNewsData = async (keyword, start, display) => {
    const newsData = await requestDummyNews(keyword, start, display);
    newsData.news.forEach(async (news) => {
      await saveNews(news, keyword);
    })

  };

  useEffect(() => {
    if (localStorage.getItem("setting") === null || localStorage.getItem("setting") === false) {

      Object.values(keywordList).forEach(keyword =>
        settingNewsData(keyword, start, display)
      );

      localStorage.setItem("setting", true);
    }
  }, []);

  return (
    <Router>
      <Routes>
        <Route path="/" element={<NewsList />} />
        <Route path="/scrap/:newsId" element={<ScrapForm />} />
      </Routes>
    </Router>
  )
}

export default App
