import React from 'react'
import { hydrateRoot } from 'react-dom/client'
import store from "./src/store"
import { Provider } from 'react-redux'
import { BrowserRouter } from 'react-router-dom'
import App from './src/app.jsx'

hydrateRoot(document.getElementById('root'), 
    <Provider store={store}>
        <BrowserRouter>
            <App />
        </BrowserRouter>
    </Provider>
)