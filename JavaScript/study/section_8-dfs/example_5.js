"use strict";

const example_5 = (arr) => {
    let len = arr.length;
    let flag = 0
    let answer = Array.from({
        length: 2
    }, () => [])
    let cnt = Array.from({
        length: len
    }, () => 0);
    const bfs = (v) => {
        if (flag) return
        if (v === len) {
            let sum1 = 0;
            let sum2 = 0;
            cnt.forEach((el, i) => {
                if (el)
                    sum1 += arr[i];
                else
                    sum2 += arr[i];
            });
            let tmp1 = ""
            let tmp2 = ""
            if (sum1 === sum2) {
                cnt.forEach((el, i) => {
                    if (el) tmp1 += arr[i] + ' '
                    else tmp2 += arr[i] + ' '
                })
                answer[0].push(tmp1)
                answer[1].push(tmp2)
                flag = 1
            }
            return;
        } else {
            cnt[v] = 1
            bfs(v + 1)
            cnt[v] = 0
            bfs(v + 1)
        }
    }
    bfs(0);
    return answer;
}

const solution_5 = (arr) => {
    let answer = "NO";
    let flag = 0;
    let total = arr.reduce((acc, v) => acc + v, 0);
    let n = arr.length;
    const dfs = (l, sum) => {
        if (flag) return;
        if (l === n) {
            if ((total - sum) === sum) {
                answer = "YES";
                flag = 1
            }
        } else {
            dfs(l + 1, sum + arr[l])
            dfs(l + 1, sum)
        }
    }
    dfs(0, 0)
    return answer;
}


const arr2 = [1, 3, 5, 6, 7, 10]

body.innerHTML += `
<h1>부분 집합의 합 구하기</h1>
${example_5(arr2)}
${solution_5(arr2)}
`