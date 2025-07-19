export const setLocalStorageItem = (key, value) => {
    localStorage.setItem(key, value);
}

export const getLocalStorageItem = (key) => {
    const value = localStorage.getItem(key);
    return value;
}

export const removeLocalStorageItem = (key) => {
    localStorage.removeItem(key);
}
