export const getUserPosts = () => {
    return (dispatch, getState, {fetch}) => {
        let response = fetch({
            url: `${config.postsBaseUrl}/v1/posts`,
        })
    }
}