const example_4 = (n) => {
    const BFS = (n) => {
        let queue = [];
        let answer = "";
        queue.push(1);
        while (queue.length) {
            let v = queue.shift();
            answer += v + " ";
            for (let nv of [v * 2, v * 2 + 1]){
                if (nv < n)
                    queue.push(nv);
            }
        }
        return answer;
    }
    return BFS(n);
}

body.innerHTML += `
<h1>깊이 우선 탐색</h1>
${example_4(7)}
`