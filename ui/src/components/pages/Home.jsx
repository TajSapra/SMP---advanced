import React from 'react';
import { useSelector } from 'react-redux';

const HomePageComponent = () => {
    const { isLoggedIn, user } = useSelector((state) => state.general);
    console.log("HomePageComponent loaded");
    return isLoggedIn?(
        <div>
            Hi {user ? user.name : 'Guest'}, welcome to the home page!
        </div>
    ): (
        <>
            <div>
                Welcome to SMP! Lets get you logged in.
            </div>
        </>
    );
};
export default HomePageComponent;