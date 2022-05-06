const switchTail = (arr) => {
    let answer = []
    let temp = arr.slice().sort((a, b) => a - b)
    for (let i = 0; i < arr.length; i++){
        if (temp[i] !== arr[i]) answer.push(i + 1)
    }
    return answer
}

// arr.slice() - deap Copy

body.innerHTML += `
<h1>switchTail</h1>
${switchTail([120, 125, 152, 130, 135, 135, 143, 127, 160])}
`