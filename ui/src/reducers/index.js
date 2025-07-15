import { combineReducers } from "redux";
import {routerReducer as router} from 'react-router-redux'
import general from "./general";

export default combineReducers({
    router,
    general
})