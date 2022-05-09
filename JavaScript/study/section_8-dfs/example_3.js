"use strict";

const example_3 = (n) => {
    let answer;
    const dfs = (v) => {
        if(v > 7){
            return;
        } else {
            // 전위 순회
            // console.log(v)
            dfs(v * 2);
            // 중위 순회
            // console.log(v)
            dfs(v * 2 + 1)
            // 후위 순회
            // console.log(v)
        }
    }
    dfs(n)
    return answer;
}

body.innerHTML += `
<h1>이진 트리 순회</h1>
${example_3(1)}
`