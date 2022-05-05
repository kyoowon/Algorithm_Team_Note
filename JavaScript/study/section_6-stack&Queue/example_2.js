const deleteStringInBracket = (s) => {
    let temp = []
    let answer = ""
    for (c of s){
        if (c === '(') temp.push(c)
        else if (c === ')') temp.pop()
        else if (temp.length === 0) answer += c
    }
    return answer
}

body.innerHTML += `
<h1>괄호 문자 제거</h1>
${deleteStringInBracket("(A(BC)D)EF(G(H)(IJ)K)LM(N)")}
`