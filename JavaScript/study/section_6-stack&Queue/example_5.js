const BracketCutter = (s) => {
    let stack = []
    let answer = 0
    for (let i = 0; i < s.length; i++) {
        if (s[i] === '(' && s[i + 1] === ')') {
            answer += stack.length;
            i++;
        } else {
            if (s[i] === '(') stack.push('(')
            else {
                stack.pop();
                answer += 1
            }
        }
    }
    return answer
}


body.innerHTML += `
<h1>쇠막대기</h1>
${BracketCutter("()(((()())(())()))(())")}
`