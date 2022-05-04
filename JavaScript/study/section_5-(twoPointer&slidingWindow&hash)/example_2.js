
const solution = (arr1, arr2) => {
    let answer = []
    arr1.forEach((value) => {
        if(arr2.includes(value)) answer.push(value)
    })
    return answer.sort((a, b) => a - b)
}

const sameAtoms = (arr1, arr2) => {
    let answer = []
    arr1.sort((a, b) => (a - b))
    arr2.sort((a, b) => (a - b))
    let p1 = p2 = 0
    while(p1 < arr1.length && p2 < arr2.length){
        if(arr1[p1] === arr2[p2]){
            answer.push(arr1[p1])
            p1++;
            p2++;
        }
        else if (arr1[p1] < arr2[p2]) p1++;
        else p2++;
    }
    return answer
}

body.innerHTML += `
<h1>공통 원소 구하기<h1>
<h2>${sameAtoms([1,3,9,5,2], [3,2,5,7,8])}</h2>
`