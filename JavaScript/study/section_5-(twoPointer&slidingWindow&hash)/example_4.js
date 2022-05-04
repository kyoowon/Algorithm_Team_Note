
const findSubsequence2 = (arr, target) => {
    let answer = []
    let p1 = 0
    let p2 = 1
    while (p2 <= arr.length && p1 < p2){
        let sum = arr.slice(p1, p2).reduce((acc, v) => acc + v, 0)
        if (sum <= target){
            for(let i = p2 - 1; i >= p1; i--) answer.push(arr.slice(i, p2))
            p2++;
        } else p1++;
    }
    return answer
}

body.innerHTML += `
<h1>연속 부분수열 2<h1>
<h2>${findSubsequence2([1, 3, 1, 2, 3], 5).length}</h2>
`