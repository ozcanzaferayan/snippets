
### IsTurkishMobileNumber
You can use the code below to check if given mobile phone number valid according to Turkish mobile number pattern.

```js
function isTurkishMobileNumber(candidate){
  const rgx = /^(\+?90|0)?(501|505|506|507|530|531|532|533|534|535|536|537|538|539|540|541|542|543|544|545|546|547|548|549|551|552|553|554|555|559)\d{7}$/;
  return candidate.match(rgx) != null;
}

console.log(isTurkishMobileNumber("5301234567"));     
console.log(isTurkishMobileNumber("+905301234567"));  
console.log(isTurkishMobileNumber("5581234567"));     
console.log(isTurkishMobileNumber("+905581234567"));  
// true
// true
// false
// false
```
