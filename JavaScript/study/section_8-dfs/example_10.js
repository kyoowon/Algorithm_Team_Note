'use strict';

const example_10 = (arr, m) => {
    let answer = [];
    const n = arr.length;
    let ch = Array.from({length: n}, () => 0)
    let tmp = Array.from({length: m}, () => 0)
    function dfs(l){
        if(l === m){
            answer.push(tmp.slice())
        }else{
            for(let i = 0; i < n; i++){
                if(ch[i] === 0){
                    ch[i] = 1
                    tmp[l] = arr[i]
                    dfs(l + 1)
                    ch[i] = 0
                }
            }
        }
    }
    dfs(0)
    return answer
}

body.innerHTML += `
<h1>순열</h1>
${example_10([3, 6, 9], 2)}
`