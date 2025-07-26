import React, { useState } from 'react';
import { authenticateUser, registerUser } from '../../actions/users';
import { useDispatch } from 'react-redux';
export const LoginPageComponent = () => {
    const [userName, setUserName] = useState('');
    const [password, setPassword] = useState('');
    const [name, setName] = useState('');
    const [phone, setPhone] = useState('');
    const [password2, setPassword2] = useState('');
    const [email2, setEmail2] = useState('');
    const dispatch = useDispatch();
    const handleLogin = (e) => {
        e.preventDefault();
        dispatch(authenticateUser(userName, password));
        setUserName('');
        setPassword('');
    }
    const handleRegister = (e) =>{
        e.preventDefault();
        dispatch(registerUser(email2, password2, name, phone));
        setEmail2('');
        setPassword2('');
        setName('');
        setPhone('');
    }
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
            <h1>New User</h1>
            <form onSubmit={handleRegister}>
                <input type="text" required placeholder="Email" onChange={(e) => setEmail2(e.target.value)} />
                <input type="password" required placeholder="Password" onChange={(e) => setPassword2(e.target.value)} />
                <input type="text" required placeholder="Name" onChange={(e) => setName(e.target.value)} />
                <input type="text" required placeholder="Phone" onChange={(e) => setPhone(e.target.value)} />
                <button type="submit">Register</button>
            </form>
            
        </div>
    )
}