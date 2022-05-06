const conferncePlan = (arr) => {
    meeting = arr
    meeting.sort((a, b) => {
        if (a[1] - b[1] === 0) return a[0] - b[0]
        return a[1] - b[1]
    })
    let answer = 0
    let et = 0;
    for (let x of meeting){
        if(x[0] >= et){
            answer += 1
            et = x[1]
        }
    }
    return answer
}

let arr=[[1, 4], [2, 3], [3, 5], [4, 6], [5, 7]];

body.innerHTML += `
<h1>conferncePlan</h1>
${conferncePlan(arr)}
`