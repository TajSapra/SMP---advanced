const path = require('path');

const serverConfig={
    mode:'development',
    target:'node',
    entry:'./server.js',
    output:{
        path:path.resolve(__dirname, 'dist'),
        filename:'Bundle.js'
    },
    devtool:'source-map',
    module:{
        rules:[
            {
                test: /\.js$/,
                use:{
                    loader:'babel-loader'
                },
                exclude:path.resolve(__dirname, './node_modules')
            },
            {
                test: /\.jsx$/,
                use:{
                    loader:'babel-loader'
                },
                exclude:path.resolve(__dirname, './node_modules')
            },
            {
                test: /\.css$/,
                use:[
                    'style-loader',
                    'css-loader'
                ],
            },
        ]
    }
}
const clientConfig={
    mode:'development',
    target:'web',
    entry:'./client.js',
    output:{
        path:path.resolve(__dirname, 'dist'),
        filename:'clientBundle.js',
        chunkFilename: '[name].clientBundle.js'
    },
    devtool:'source-map',
    module:{
        rules:[
            {
                test: /\.js$/,
                use:{
                    loader:'babel-loader'
                },
                exclude:path.resolve(__dirname, './node_modules')
            },
            {
                test: /\.jsx$/,
                use:{
                    loader:'babel-loader'
                },
                exclude:path.resolve(__dirname, './node_modules')
            },
            {
                test: /\.css$/,
                use:[
                    'style-loader',
                    'css-loader'
                ],
            },
        ]
    },
    optimization: {
        splitChunks: {
            cacheGroups: {
                default: false,
                vendors: false,
            },
        },
    }
}
module.exports=[serverConfig, clientConfig]