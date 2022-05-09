'use strict';

const example_9 = (coins, money) => {
    let answer = Number.MAX_SAFE_INTEGER
    const dfs = (sum, count) =>{
        if (sum > money) return;
        if (count > answer) return;
        if (sum == money){
            answer = Math.min(answer, count)
        }else{
            for (let coin of coins){
                dfs(sum + coin, count + 1)
            }
        }
    }
    dfs(0, 0)
    return answer
}

body.innerHTML += `
<h1>동전 교환</h1>
${example_9([1, 2, 5], 15)}
`