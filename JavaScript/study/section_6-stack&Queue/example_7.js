const classPlan = (plan, Class) => {
    let queue = plan.split('')
    for (let c of Class) {
        if (queue.length === 0) break;
        if (c === queue[0]) queue.shift()
    }
    if (queue.length) return "NO"
    return "YES"
}


body.innerHTML += `
<h1>수업 계획수립</h1>
${classPlan("CBA", "CBDAGE")}
`