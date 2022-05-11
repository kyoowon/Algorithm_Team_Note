'use strict';

const example_11 = (n) => {
    if (n === 1) return 1
    return n * example_11(n - 1)
}

body.innerHTML += `
<h1>팩토리얼</h1>
${example_11(5)}
`