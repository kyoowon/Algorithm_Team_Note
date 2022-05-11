'use strict';

const example_12 = (n, r) => {
    let answer;
    let dy = Array.from(Array(35), () => Array(35).fill(0))
    const dfs = (n, r) =>{
        if (dy[n][r] > 0) return dy[n][r]
        if (n === r || r === 0) return 1;
        else return dy[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r)
    }
    answer = dfs(n, r);
    return answer
}

body.innerHTML += `
<h1>조합</h1>
${example_12(33, 18)}
`