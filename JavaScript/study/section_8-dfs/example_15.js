'use strict';

const example_15 = (arr, r, target) => {
    let answer = 0
    let tmp = Array.from({length: r}, ()=>0)
    const dfs = (l, s) => {
        if (l === r){
            if (tmp.reduce((acc, v) => acc + v) % target === 0) answer += 1
        }else{
            for(let i=s; i < arr.length; i++){
                tmp[l] = arr[i]
                dfs(l + 1, i + 1)
            }
        }
    }
    dfs(0, 0);
    return answer
}

body.innerHTML += `
<h1>수들의 조합</h1>
${example_15([2, 4, 5, 8, 12], 3, 6)}
`