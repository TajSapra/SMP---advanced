import React, { useEffect, useState } from 'react';
import { authenticateUser } from '../../actions/users';
import { useDispatch } from 'react-redux';
export const LoginPageComponent = () => {
    const [userName, setUserName] = useState('');
    const [password, setPassword] = useState('');
    const dispatch = useDispatch();
    const handleLogin = (e) => {
        e.preventDefault();
        dispatch(authenticateUser(userName, password));
    }
    useEffect(()=>{
        console.log(userName, password);
    }, [userName, password])
    return (
        <div>
            <h1>Login Page</h1>
            <form onSubmit={handleLogin}>
                <div>
                    <label>Email: </label>
                    <input type="text" required placeholder="Email" onChange={(e) => setUserName(e.target.value)} />
                </div>
                <div>
                    <label>Password: </label>
                    <input type="password" required placeholder="Password" onChange={(e) => setPassword(e.target.value)} />
                </div>
                <button type="submit">Login</button>
            </form>
        </div>
    )
}