const packageJson = require('./package.json');
const path = require('path');
const UglifyJsPlugin = require('uglifyjs-webpack-plugin');
const CompressionPlugin = require("compression-webpack-plugin");
// var webpack = require('webpack');

const PATHS = {
    compiled: path.join(__dirname, 'target', 'packages', packageJson.name),
    output: path.join(__dirname, 'target', 'classes', 'js'),
    site: path.join(__dirname, 'target', 'classes')
};

module.exports = {
    entry: {
        main: [
            path.join(PATHS.compiled, packageJson.main)
        ]
    },
    resolve: {
        modules: [
            'node_modules'
        ]
    },
    plugins: [
        new CompressionPlugin({
            algorithm: "gzip",
            test: /\.js$|\.html$/,
            threshold: 10240,
            minRatio: 0.8
        })
    ],
    module: {
        rules: [
            {
                test: /\.js$/,
                use: [
                    'kotlin-source-map-loader'
                ],
                enforce: 'pre'
            }
        ]
    },
    optimization: {
        minimizer: [new UglifyJsPlugin()],
    },
    output: {
        path: PATHS.output,
        filename: packageJson.main
    },
    devServer: {
        contentBase: PATHS.site,
        compress: true,
        port: 9000
    },
    devtool: 'source-map'
};