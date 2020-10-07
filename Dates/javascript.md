
### Dates
You can use the code below to convert the months to Turkish.

```js
var longMonthText = "Ali Bey ile 14 August 2022'de toplantım var.";
var shortMonthText = "Ali Bey ile 14 Nov 2022'de toplantım var.";

var longMonthReplace = {
  January: "Ocak",
  january: "ocak",
  February: "Şubat",
  february: "şubat",
  March: "Mart",
  march: "mart",
  April: "Nisan",
  april: "nisan",
  May: "Mayıs",
  may: "mayıs",
  June: "Haziran",
  june: "haziran",
  July: "Temmuz",
  july: "temmuz",
  August: "Ağustos",
  august: "ağustos",
  September: "Eylül",
  september: "eylül",
  Oktober: "Ekim",
  oktober: "ekim",
  November: "Kasım",
  november: "kasım",
  December: "Aralık",
  december: "aralık",
};


var shortMonthReplace = {
  Jan: "Oca",
  jan: "oca",
  Feb: "Şub",
  feb: "şub",
  Mar: "Mar",
  mar: "mar",
  Apr: "Nis",
  apr: "nis",
  May: "May",
  may: "may",
  June: "Haz",
  june: "haz",
  July: "Tem",
  july: "tem",
  Aug: "Ağu",
  aug: "ağu",
  Sep: "Eyl",
  sep: "eyl",
  Oct: "Eki",
  oct: "eki",
  Nov: "Kas",
  nov: "kas",
  Dec: "Ara",
  dec: "ara",
};

longMonthText = longMonthText.replace(new RegExp("(" + Object.keys(longMonthReplace).map(function(i){return i.replace(/[.?*+^$[\]\\(){}|-]/g, "\\$&")}).join("|") + ")", "g"), function(s){ return longMonthReplace[s]});
shortMonthText = shortMonthText.replace(new RegExp("(" + Object.keys(shortMonthReplace).map(function(i){return i.replace(/[.?*+^$[\]\\(){}|-]/g, "\\$&")}).join("|") + ")", "g"), function(s){ return shortMonthReplace[s]});

console.log(longMonthText) // "Ali Bey ile 14 Ağustos 2022'de toplantım var."
console.log(shortMonthText) // "Ali Bey ile 14 Kas 2022'de toplantım var."
```
<hr>
You can use the code below to convert the dates to Turkish.

```js
var longDayText = "Ali Bey ile Tuesday'de toplantım var.";
var shortDayText = "Ali Bey ile Tue'de toplantım var.";

var longDayReplace = {
  Monday: "Pazartesi",
  monday: "pazartesi",
  Tuesday: "Salı",
  tuesday: "salı",
  Wednesday: "Çarşamba",
  wednesday: "çarşamba",
  Thursday: "Perşembe",
  thursday: "perşembe",
  Friday: "Cuma",
  friday: "cuma",
  Saturday: "Cumartesi",
  saturday: "cumartesi",
  Sunday: "Pazar",
  sunday: "pazar",
};

var shortDayReplace = {
  Mon: "Pt",
  mon: "pt",
  Tue: "Sa",
  tue: "sa",
  Wed: "Ça",
  wed: "ça",
  Thu: "Pe",
  thu: "pe",
  Fri: "Cu",
  fri: "cu",
  Sat: "Ct",
  sat: "ct",
  Sun: "Pz",
  sun: "pz",
};

longDayText = longDayText.replace(new RegExp("(" + Object.keys(longDayReplace).map(function(i){return i.replace(/[.?*+^$[\]\\(){}|-]/g, "\\$&")}).join("|") + ")", "g"), function(s){ return longDayReplace[s]});
shortDayText = shortDayText.replace(new RegExp("(" + Object.keys(shortDayReplace).map(function(i){return i.replace(/[.?*+^$[\]\\(){}|-]/g, "\\$&")}).join("|") + ")", "g"), function(s){ return shortDayReplace[s]});

console.log(longDayText) // "Ali Bey ile Salı'de toplantım var."
console.log(shortDayText) // "Ali Bey ile Sa'de toplantım var."
```
