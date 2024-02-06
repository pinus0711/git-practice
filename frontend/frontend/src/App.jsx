import "./index.css";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import NewsList from "./page/NewsList";

function App() {

  return (
    <Router>
      <Routes>
        <Route path="/" element={<NewsList />} />
      </Routes>
    </Router>
  )
}

export default App
