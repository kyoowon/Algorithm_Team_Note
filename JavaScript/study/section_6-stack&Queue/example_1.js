const body = document.querySelector("body")

const rightBracket = (s) => {
    let count = 0
    for (let c of s) {
        if (c === '(') count += 1
        else {
            if (count > 0) count -= 1
            else return "NO"
        }
    }
    if (count) return "NO"
    return "YES"
}

body.innerHTML += `
<h1>올바른 괄호</h1>
${rightBracket("(()(()))(()")}
`