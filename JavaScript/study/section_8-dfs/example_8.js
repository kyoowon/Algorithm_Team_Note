'use strict';

const example_8 = (n, r) => {
    let answer = []
    const dfs = (l, arr) => {
        if (l == r){
            let tmp = arr.slice()
            answer.push(tmp)
        } else{
            for (let i = 1; i <= n; i++){
                arr.push(i)
                dfs(l + 1, arr)
                arr.pop()
            }
        }
    }
    dfs(0, [])
    console.log(answer)
    return answer
}

body.innerHTML += `
<h1>중복 순열</h1>
${example_8(3, 2)}
`