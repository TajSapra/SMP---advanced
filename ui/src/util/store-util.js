export const createReducer = (initialState, fnMap) => {
    return (state = initialState, { type, payload }) => {
      const handler = fnMap[type]
      if (handler) {
        return handler.call(fnMap, state, payload)
      }
      return state
    }
}