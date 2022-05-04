
const findSubsequence = (arr, target) => {
    let p1 = 0
    let p2 = 1
    let answer = []
    while(p2 < arr.length){
        temp = arr.slice(p1, p2)
        sum = temp.reduce((acc, v) => acc + v, 0)
        if (sum < target) p2++;
        else if(sum > target) p1++;
        else {
            answer.push(temp)
            p2++;
        }
    }
    return answer
}

body.innerHTML += `
<h1>연속 부분수열 1<h1>
<h2>${findSubsequence([6, 2, 1, 3, 1, 1, 1, 2], 6)}</h2>
`