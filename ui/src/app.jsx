import React, { useEffect } from 'react';
import routes from './routes';
import {Routes, Route} from 'react-router-dom'
import { useDispatch } from 'react-redux';
import { getUserDetails } from './actions/users';
import { getLocalStorageItem } from './util/browser-storage';

export default function App() {
  const dispatch = useDispatch();

  useEffect(()=>{
    const user = getLocalStorageItem('user')
    console.log('user', user);
    if(!user){
      dispatch({
        type: 'SET_LOGIN_DETAILS',
        payload: {
          isLoggedIn: false,
          user: null
        }
      })
    }
    else{
      dispatch(getUserDetails(user))    
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