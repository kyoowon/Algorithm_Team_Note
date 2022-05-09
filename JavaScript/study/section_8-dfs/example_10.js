'use strict';

const example_10 = (arr, selectNumber) => {
    if (selectNumber === 1) return arr.map((el) => [el])
    arr.forEach((fixed, index, origin) => {
        rest = origin.slice(index)
    })
}

body.innerHTML += `
<h1>순열</h1>
${example_10([3, 6, 9], 2)}
`