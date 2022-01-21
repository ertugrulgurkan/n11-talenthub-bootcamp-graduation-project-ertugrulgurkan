import { Route, Routes } from 'react-router-dom';
import './App.css';
import HomePage from './components/home/HomePage';
import ErrorPage from './components/error/ErrorPage';
import Menu from './components/menu/Menu';
import React from 'react';
import DeleteUserPage from './components/user/DeleteUserPage';
import AddUserPage from './components/user/AddUserPage';
import UpdateUserPage from './components/user/UpdateUserPage';
import ApplyCreditPage from './components/credit/ApplyCreditPage';
import ViewCreditsPage from './components/credit/ViewCreditsPage';




class App extends React.Component {

  render() {
    return (
      <div className="App">
        <Menu></Menu>
        <Routes>
          <Route path="/" element={<HomePage></HomePage>}></Route>
          <Route path="*" element={<ErrorPage></ErrorPage>}></Route>
          <Route path="/add-user" element={<AddUserPage></AddUserPage>}></Route>
          <Route path="/update-user" element={<UpdateUserPage></UpdateUserPage>}></Route>
          <Route path="/delete-user" element={<DeleteUserPage></DeleteUserPage>}></Route>
          <Route path="/apply-credit" element={<ApplyCreditPage></ApplyCreditPage>}></Route>
          <Route path="/show-applications" element={<ViewCreditsPage></ViewCreditsPage>}></Route>

        </Routes>
      </div>
    );
  }

}

export default App;
