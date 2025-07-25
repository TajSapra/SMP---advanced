import React from 'react';
import { useSelector } from 'react-redux';
import { LoginPageComponent } from '../shared/Login.jsx';
import { HomeFeedPageComponent } from './HomeFeed.jsx';

const HomePageComponent = () => {
    const { isLoggedIn, user } = useSelector((state) => state.general);
    console.log("HomePageComponent loaded");
    return isLoggedIn?(
        <>
            <div>
                Hi { user.name }, welcome to the home page!
            </div>
            <HomeFeedPageComponent />
        </>
    ): (
        <>
            <div>
                Welcome to SMP! Lets get you logged in.
            </div>
            <LoginPageComponent />
        </>
    );
};
export default HomePageComponent;