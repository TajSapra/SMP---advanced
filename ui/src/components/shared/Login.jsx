import React from 'react';
export const LoginPageComponent = () => {
    return (
        <div>
            <h1>Login Page</h1>
            <div>
                <label>User Name: </label>
                <input type="text" placeholder="Username" />
            </div>
            <div>
                <label>Password: </label>
                <input type="password" placeholder="Password" />
            </div>
        </div>
    )
}