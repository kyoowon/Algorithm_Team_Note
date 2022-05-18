const example_5 = (s, target) => {
    let ch = Array.from({length : 10001}, () => 0)
    let dis = Array.from({length : 10001}, () => 0)
    let queue = [];
    ch[s] = 1;
    queue.push(s)
    while (queue.length){
        let x = queue.shift()
        for (let nx of [x - 1, x + 1, x + 5]){
            if (nx === target) return dis[x] + 1
            if (nx > 0 && nx < 10000 && ch[nx] === 0){
                ch[nx] = 1;
                queue.push(nx);
                dis[nx] = dis[x] + 1
            }
        }
    }
}

body.innerHTML += `
<h1>송아지 찾기</h1>
${example_5(5, 14)}
`