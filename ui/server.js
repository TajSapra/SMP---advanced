import express from "express";
import React from "react";
import { renderToString } from 'react-dom/server'
import { Provider } from 'react-redux'
import { StaticRouter } from 'react-router-dom/server'
import App from './src/app.jsx'
import store from './src/store'

const app=express()
const port=3000

app.use(express.static('dist'))

const renderedHTML = (jsx) => {
    return `
        <!DOCTYPE html>
        <html>
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>My SMP App</title>
            </head>
            <body>
                <div id="root">${jsx}</div>
                <script src="/clientBundle.js"></script>
            </body>
        </html>
    `    
}

app.get('*', (req, res) => {
    const jsx = renderToString(
        <Provider store={store}>
            <StaticRouter location={req.path}>
                <App />
            </StaticRouter>
        </Provider>
    );

    res.send(renderedHTML(jsx));
});
app.listen(port, ()=>{
    console.log(`listening on port: ${port}`)
})