import { config } from "../config"

export const getUserDetails = (userId) => {
    return (dispatch, getState, {fetch})=>{
        let res = fetch(`${config.usersBaseUrl}/v1/users/${userId}`, {
            method: 'GET',
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