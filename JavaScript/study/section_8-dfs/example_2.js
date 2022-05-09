'use strict';

const example_2 = (n) => {
    let answer = ""
    const dfs = (n) => {
        if (n === 0) return;
        else {
            dfs(parseInt(n / 2));
            answer += (n % 2)
        }
    }
    dfs(n)
    return answer
}

body.innerHTML += `
<h1>2진 변환</h1>
${example_2(11)}
`