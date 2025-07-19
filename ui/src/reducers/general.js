import { createReducer } from "../util/store-util";
const initialState = {
    isLoggedIn: false,
    user: null
}
export default createReducer(initialState, {
    SET_LOGIN_DETAILS: (state, payload) => {
        return {
            ...state,
            ...payload,
        }
    }
})