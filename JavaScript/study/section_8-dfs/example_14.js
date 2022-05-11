'use strict';

const example_14 = (n, r) => {
    let answer = []
    let tmp = Array.from({length: r}, ()=>0)
    const dfs = (l, s) => {
        if (l === r){
            answer.push(tmp.slice())
        }else{
            for(let i=s; i <= n; i++){
                tmp[l] = i
                dfs(l + 1, i+1)
            }
        }
    }
    dfs(0, 1);
    return answer
}

body.innerHTML += `
<h1>조합 구하기</h1>
${example_14(4, 2)}
`