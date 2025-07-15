import { createReducer } from "../util/store-util";
const initialState = {
    testValue:null,
}
export default createReducer(initialState, {
    TEST_ACTION: (state, payload) => {
        return {
            ...state,
            testValue: payload
        }
    }
})