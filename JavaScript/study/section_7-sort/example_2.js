const recentlyUsed = (arr, n) => {
    answer = Array.from({
        length: n
    }, () => 0)
    arr.forEach((el) => {
        let pos = -1
        answer.forEach((cache, index) => {
            if (el === cache) pos = index
        })
        if (pos === -1) {
            for (let i = n - 1; i >= 1; i--) {
                answer[i] = answer[i - 1];
            }
        } else {
            for (let i = pos; i >= 1; i--) {
                answer[i] = answer[i - 1];
            }
        }
        answer[0] = el;
    })
    return answer;
}

// python deque => array
// python leftpop == shift
// python leftpush == unshift

const recentlyUsed2 = (arr, n) => {
    answer = Array.from({
        length: n
    }, () => 0)
    arr.forEach((el) => {
        let pos = -1
        answer.forEach((cache, index) => {
            if (el === cache) pos = index
        })
        if (pos === -1) {
            answer.unshift(el);
            if (answer.length > n) answer.pop()
        } else {
            answer.splice(pos, 1);
            answer.unshift(el)
        }
        answer[0] = el;
    })
    return answer;
}

body.innerHTML += `
<h1>Least Recently Used</h1>
${recentlyUsed2([1,2,3,2,6,2,3,5,7], 5)}
`