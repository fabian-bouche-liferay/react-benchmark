const { merge } = require("webpack-merge");
const common = require("./webpack.common.js");
const crypto = require("crypto");
const { ESBuildMinifyPlugin } = require("esbuild-loader");

module.exports = merge(common, {
  mode: "production",
  optimization: {
    minimize: true,
    minimizer: [
      new ESBuildMinifyPlugin({
        target: "es2015",
      }),
    ],
    runtimeChunk: "single",
    splitChunks: {
      chunks: "all",
      maxInitialRequests: Infinity,
      minSize: 0,
      cacheGroups: {
        vendor: {
          test: /[\\/]node_modules[\\/]/,
          name(module) {
            // get the name. E.g. node_modules/packageName/not/this/part.js
            // or node_modules/packageName
            const packageName = module.context.match(
              /[\\/]node_modules[\\/](.*?)([\\/]|$)/
            )[1];

            if (packageName.includes("react")) return "engine";
            if (
              packageName.includes("clay") ||
              packageName.includes("material") ||
              packageName.includes("mui")
            ) return "ui";

            return "vendor";
          },
        },
      },
    },
  },
});