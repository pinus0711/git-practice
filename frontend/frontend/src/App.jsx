import "./index.css";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import NewsList from "./page/NewsList";
import Register from "./layout/Register";
import Login from "./layout/Login";

function App() {

  return (
    <Router>
      <Routes>
        <Route path="/" element={<NewsList />} />
        <Route path="/register" element={<Register/>} />
        <Route path="/login" element={<Login />} />
      </Routes>
    </Router>
  )
}

export default App
