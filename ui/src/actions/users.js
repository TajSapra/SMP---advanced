import { config } from "../config"
import { removeLocalStorageItem, setLocalStorageItem } from "../util/browser-storage";

export const getUserDetails = (userId) => {
    return (dispatch, getState, {fetch})=>{
        let res = fetch(`${config.usersBaseUrl}/v1/users/details`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
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
            removeLocalStorageItem('token');
        });
    }
}

export const registerUser = (email, password, name, phone) => {
    return (dispatch, getState, {fetch})=>{
        let res = fetch({
            url: `${config.usersBaseUrl}/v1/users`,
            method: 'POST',
            data: {email, password, name, phone_number: phone, is_phone_verified:false},
            headers: {
                'Content-Type': 'application/json'
            }
        })
        res.then(response => {
            console.log("User registered successfully", response.data);
        }).catch(error => {
            console.error(error);
        });
    }
}