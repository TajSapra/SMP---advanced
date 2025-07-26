import React from 'react';

export const HomeFeedPageComponent = () => {
    const [postDescription, setPostDescription] = React.useState('');
    return (
        <div>
            <form>
                <h1>Create Posts</h1>
                <textarea placeholder="Post Description" value={postDescription} onChange={(e) => setPostDescription(e.target.value)} />
            </form>
        </div>
    );
}