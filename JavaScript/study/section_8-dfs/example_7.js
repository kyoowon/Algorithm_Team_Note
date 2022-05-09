'use strict';

const example_7 = (timeer, quizs) => {
    let answer = Number.MIN_SAFE_INTEGER;
    let len = quizs.length;
    const dfs = (l, sum, time) => {
        if (timeer < time) return;
        if (l === len) {
            answer = Math.max(answer, sum)
        } else {
            dfs(l + 1, sum + quizs[l][0], time + quizs[l][1])
            dfs(l + 1, sum, time)
        }
    }
    dfs(0, 0, 0)
    return answer;
}


const arr4 = [
    [10, 5],
    [25, 12],
    [15, 8],
    [6, 3],
    [7, 4]
];

body.innerHTML += `
<h1>최대점수 구하기</h1>
${example_7(20, arr4)}
`