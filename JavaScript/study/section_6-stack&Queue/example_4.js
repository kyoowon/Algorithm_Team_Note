const postfixCal = (s) => {
    let stack = []
    for (let c of s){
        if ('1' <= c && '9' >= c) stack.push(Number(c));
        else{
            let b = stack.pop();
            let a = stack.pop();
            let cal = 0
            switch (c) {
                case '+':
                    cal = a + b;
                    break;
                case '/':
                    cal = a / b;
                    break;
                case '-':
                    cal = a - b;
                    break;
                case '*':
                    cal = a * b;
                    break;
            }
            stack.push(cal)
        }
    }
    return stack.pop();
}

body.innerHTML += `
<h1>후위 연산</h1>
${postfixCal("352+*9-")}
`