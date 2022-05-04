const body = document.querySelector("body")

const solution1 = (arr1, arr2) => {
    answer = [...arr1, ...arr2]
    answer.sort((a, b) => a - b)
    return answer
}

const solution2 = (arr1, arr2) => {
    answer = []
    n = arr1.length
    m = arr2.length
    p1 = p2 = 0
    while (p1 < n && p2 < m) {
        if (arr1[p1] <= arr2[p2]) answer.push(arr1[p1++]);
        else answer.push(arr2[p2++]);
    }
    while (p1 < n) answer.push(arr1[p1++])
    while (p2 < m) answer.push(arr2[p2++])
    return answer
}


body.innerHTML = `
<h1>두 배열 합치기<h1>
<h2>${solution2([1,3, 5], [2,3, 6, 7,9])}</h2>
`