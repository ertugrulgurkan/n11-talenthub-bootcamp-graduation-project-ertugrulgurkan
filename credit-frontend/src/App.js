import { Route, Routes } from 'react-router-dom';
import './App.css';
import HomePage from './components/home/HomePage';
import ErrorPage from './components/error/ErrorPage';
import Menu from './components/menu/Menu';
import React from 'react';



class App extends React.Component {

  render() {
    return (
      <div className="App">
        <Menu></Menu>
        <Routes>
          <Route path="/" element={<HomePage></HomePage>}></Route>
          <Route path="*" element={<ErrorPage></ErrorPage>}></Route>
        </Routes>
      </div>
    );
  }

}

export default App;
