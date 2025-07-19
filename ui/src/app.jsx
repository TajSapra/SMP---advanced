import React, { useEffect } from 'react';
import routes from './routes';
import {Routes, Route} from 'react-router-dom'
import { useDispatch } from 'react-redux';
import { getUserDetails } from './actions/users';
import { getLocalStorageItem, removeLocalStorageItem } from './util/browser-storage';

export default function App() {
  const dispatch = useDispatch();

  useEffect(()=>{
    const token = getLocalStorageItem('token');
    if(!token){
      dispatch({
        type: 'SET_LOGIN_DETAILS',
        payload: {
          isLoggedIn: false,
        }
      })
      removeLocalStorageItem('token');
      removeLocalStorageItem('user');
    }
    else{
      dispatch(getUserDetails())    
    }
    
  }, [])

  return (
    <div>
      <Routes>
        {routes.map(element=>(
          <Route path={element.path} Component={element.component}></Route>
        ))}
      </Routes>
    </div>
  );
}