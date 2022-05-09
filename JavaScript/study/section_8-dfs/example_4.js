"use strict";

const example_4 = (n) => {
    let answer = [];
    let cnt = Array.from({
        length: n + 1
    }, () => 0)
    const dfs = (v) => {
        if (v === n + 1) {
            let tmp = ""
            cnt.forEach((value, index) => {
                if (value === 1) {tmp += index + ' '}
            })
            if (tmp.length) answer.push(tmp.trim())
            return;
        } else {
            // 참여 o
            cnt[v] = 1
            dfs(v + 1)
            // 참여 x
            cnt[v] = 0
            dfs(v + 1)
        }
    }
    dfs(1)
    return answer;
}
body.innerHTML += `
<h1>부분 집합 구하기</h1>
${example_4(3)}
`