import { legacy_createStore as createStore, applyMiddleware } from 'redux';
import thunk from 'redux-thunk';
import rootReducer from './reducers';
import axios from 'axios'

axios.interceptors.request.use((config) => {
    const jwt = localStorage.getItem('token');
    const token = jwt?`Bearer ${jwt}`: '';
    config.headers.Authorization = token;
    return config;
}, (error) => {
    return Promise.reject(error)
});

function configureStore(initialState = {}, extraParams) {
    const thunkMiddleware = thunk.withExtraArgument(extraParams);
    const enhancer = applyMiddleware(thunkMiddleware);
    const store = createStore(rootReducer, initialState, enhancer);
    return store;
}

const store = configureStore({}, { fetch: axios })

export default store;