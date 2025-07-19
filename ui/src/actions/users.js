import { config } from "../config"
import { setLocalStorageItem } from "../util/browser-storage";

export const getUserDetails = (userId) => {
    return (dispatch, getState, {fetch})=>{
        const token = localStorage.getItem('token');
        console.log(token)
        let res = fetch(`${config.usersBaseUrl}/v1/users/details`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`
            }
        })
        res.then(response => {
            dispatch({
                type: 'SET_LOGIN_DETAILS',
                payload: {
                    isLoggedIn: true,
                    user: response.data
                }
            });
        }).catch(error => {
            console.error(error);
        });
    }
}

export const authenticateUser = (email, password) => {
    return (dispatch, getState, {fetch})=>{
        let res = fetch({
            url: `${config.usersBaseUrl}/v1/users/authenticate`,
            method: 'POST',
            data: JSON.stringify({email, password}),
            headers: {
                'Content-Type': 'application/json'
            }
        })
        res.then(response => {
            setLocalStorageItem('token', response.data.token);
            dispatch({
                type: 'SET_LOGIN_DETAILS',
                payload: {
                    isLoggedIn: true,
                    user: response.data.user
                }
            });
        }).catch(error => {
            console.error(error);
        });
    }
}