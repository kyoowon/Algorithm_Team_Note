'use strict';

const example_6 = (maxSize, dogs) => {
    let answer = Number.MIN_SAFE_INTEGER;
    let len = dogs.length;
    const dfs = (l, sum) => {
        if (sum > maxSize) return;
        if (l === len) {
            answer = Math.max(answer, sum)
        } else {
            dfs(l + 1, sum + dogs[l])
            dfs(l + 1, sum)
        }
    }
    dfs(0, 0)
    return answer;
}


const arr3 = [81, 58, 42, 33, 61];

body.innerHTML += `
<h1>바둑이 승차</h1>
${example_6(259, arr3)}
`