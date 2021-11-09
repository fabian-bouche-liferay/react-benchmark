const path = require('path');
const outputPath = path.resolve(
    __dirname,
    './src/main/resources/META-INF/resources/dist'
);
const {ESBuildPlugin} = require('esbuild-loader')

module.exports = {
  entry: path.join(
      __dirname,
      './src/main/resources/META-INF/resources/lib/index.js'
  ),
  module: {
    rules: [
      {
        exclude: /node_modules/,
        test: /\.js$/,
        loader: 'esbuild-loader',
        options: {
          loader: 'jsx',
          target: 'es2015'
        }
      },
      {
        test: /\.(scss|css)$/,
        use: [
          {loader: 'style-loader'},
          {loader: 'css-loader'},
          {loader: 'sass-loader'},
        ],
      },
    ],
  },
  resolve: {
    extensions: ['.js', '.jsx'],
  },
  output: {
    filename: "[name].js",
    path: outputPath,
  },
  plugins: [
    new ESBuildPlugin()
  ]
};