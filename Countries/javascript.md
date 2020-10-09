
### Countries
You can use the code below to convert the countries to Turkish. (Don't forget to import countriesData.js file in your project)

```js
const { countries } = require("./countriesData");

let filterCountries = countries.find(({ name }) => name === "Turkey");

console.log(
  `${filterCountries.name}(${filterCountries.code}) olan ülkenin Türkçesi: ${filterCountries.tr_name}`
); // Turkey(TR) olan ülkenin Türkçesi: Türkiye 

```
