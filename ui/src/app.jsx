import React from 'react';
import routes from './routes';
import { renderRoutes } from 'react-router-config';
import {Routes, Route} from 'react-router-dom'
import Home from './components/pages/Home.jsx';
export default function App() {
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