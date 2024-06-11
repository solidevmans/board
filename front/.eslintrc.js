/* eslint-env node */
require('@rushstack/eslint-patch/modern-module-resolution')

module.exports = {
  root: true,
  'extends': [
    'plugin:vue/vue3-essential',
    'eslint:recommended',
    "eslint-config-prettier",
    '@vue/eslint-config-typescript',
    '@vue/eslint-config-prettier/skip-formatting'
  ],
  parserOptions: {
    ecmaVersion: 'latest',
    sourceType: "module"
  },
  env:{
    browser: true,
    es2022:true,
    node:true
  },
  plugins: ["prettier"],
  rules: {
    "prettier/prettier" : "error"
  }
}
