
const maxSales = (arr, days) => {
    let answer = []
    for(let i = 0; i <= arr.length - days; i++){
        answer.push(arr.slice(i, i + days).reduce((acc, v) => acc + v))
    }
    return Math.max(...answer)
}

const maxSalesSlidingWindow = (arr, days) => {
    let answer = []
    let sum = arr.slice(0, days).reduce((acc, v) => acc + v)
    answer.push(sum)
    for(let i = 0; i < arr.length - days; i++){
        sum += arr[i + days] - arr[i]
        answer.push(sum)
    }
    return Math.max(...answer)
}

body.innerHTML += `
<h1>최대 매출<h1>
<h2>${(maxSalesSlidingWindow([12, 15, 11, 20, 25, 10, 20, 19, 13, 15], 3))}</h2>
<h2>${(maxSales([12, 15, 11, 20, 25, 10, 20, 19, 13, 15], 3))}</h2>
`