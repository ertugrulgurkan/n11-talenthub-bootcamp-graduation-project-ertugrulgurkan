import { Route, Routes } from 'react-router-dom';
import './App.css';
import HomePage from './components/home/HomePage';
import ErrorPage from './components/error/ErrorPage';
import Menu from './components/menu/Menu';
import React from 'react';
import ApplyCreditPage from './components/credit/ApplyCreditPage';
import ShowCreditApplication from './components/credit/ShowCreditApplicationPage';




class App extends React.Component {

  render() {
    return (
      <div className="App">
        <Menu></Menu>
        <Routes>
          <Route path="/" element={<HomePage></HomePage>}></Route>
          <Route path="*" element={<ErrorPage></ErrorPage>}></Route>
          <Route path="/apply-credit" element={<ApplyCreditPage></ApplyCreditPage>}></Route>
          <Route path="/show-credit-application" element={<ShowCreditApplication></ShowCreditApplication>}></Route>
        </Routes>
      </div>
    );
  }

}

export default App;
