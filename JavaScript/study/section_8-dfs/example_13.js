'use strict';

const example_13 = (n, root) => {
    let answer, flag = 0
    let dy = Array.from(Array(11), () => Array(11).fill(0))
    const combi = (n, r) => {
        if (dy[n][r] > 0) return dy[n][r];
        if (n === r || r === 0) return 1;
        else return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r)
    }
    let ch = Array.from({length: n + 1}, () => 0)
    let b = Array.from({length: n}, () => 0)
    let p = Array.from({length: n}, () => 0)
    b = b.map((el, i) => el = combi(n - 1, i))
    const dfs = (l, sum) => {
        if (flag === 1) return
        if(l === n && sum === root){
            answer = p.slice();
            flag = 1
        }else{
            for (let i = 1; i <= n; i++){
                if(ch[i] === 0){
                    ch[i] = 1;
                    p[l] = i;
                    dfs(l + 1, sum + (b[l] * p[l]));
                    ch[i] = 0;
                }
            }
        }
    }
    dfs(0, 0)
    return answer;
}

body.innerHTML += `
<h1>파스칼 삼각형</h1>
${example_13(4, 16)}
`