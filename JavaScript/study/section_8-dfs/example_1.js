'use strict';

const example_1 = (n) => {
    const dfs = (l, arr) =>{
        if (l == 0) return;
        else{
            dfs(l - 1, arr)
            arr.push(l)
        }
        return arr
    }
    let answer = dfs(n, [])
    return answer
}

let body = document.querySelector("body");
body.innerHTML = `
<h1>재귀 함수</h1>
${example_1(3)}
`