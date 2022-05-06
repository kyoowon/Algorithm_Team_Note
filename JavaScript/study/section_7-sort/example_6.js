const weddingTime = (arr) => {
    timeTable = []
    for (let v of arr){
        timeTable.push([v[0], 'S']);
        timeTable.push([v[1], 'E']);
    }
    timeTable.sort((a, b) => {
        if (a[0] === b[0]) return a[1].charCodeAt() - b[1].charCodeAt();
        else return a[0] - b[0]
    })
    let answer = 0
    let cnt = 0
    timeTable.forEach((el) => {
        if (el[1] === 'S') cnt++;
        else cnt--;
        answer = Math.max(answer, cnt);
    })
    return answer;
}
let arr2 = [
    [14, 18],
    [12, 15],
    [15, 20],
    [20, 30],
    [5, 14]
];

body.innerHTML += `
<h1>결혼식</h1>
${weddingTime(arr2)}
`