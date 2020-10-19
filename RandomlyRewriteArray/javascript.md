
### Randomly rewrite the existing array
You can use the code below to randomly rewrite the existing array

```js

function shuffle(a) {
    for (let i = a.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [a[i], a[j]] = [a[j], a[i]];
    }
    return a;
}

let arr = [0, 2, 4, 6, 8, 10, 12]

console.log(shuffle(arr)) //  [6, 2, 0, 10, 8, 12, 4]
console.log(shuffle(arr)) //  [10, 0, 2, 6, 8, 12, 4]

```
